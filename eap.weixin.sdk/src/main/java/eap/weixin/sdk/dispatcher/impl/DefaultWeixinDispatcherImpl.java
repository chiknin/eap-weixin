package eap.weixin.sdk.dispatcher.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eap.EapContext;
import eap.util.EDcodeUtil;
import eap.util.IoUtil;
import eap.util.StringUtil;
import eap.util.XmlUtil;
import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.api.ISafeAPI;
import eap.weixin.sdk.dispatcher.IWeixinDispatcher;
import eap.weixin.sdk.dto.CheckMessageDTO;
import eap.weixin.sdk.dto.MessageBaseDTO;
import eap.weixin.sdk.dto.event.ClickEventDTO;
import eap.weixin.sdk.dto.event.LocationEventDTO;
import eap.weixin.sdk.dto.event.MassSendJobFinishEventDTO;
import eap.weixin.sdk.dto.event.ScanEventDTO;
import eap.weixin.sdk.dto.event.SubscribeEventDTO;
import eap.weixin.sdk.dto.event.TemplateSendJobFinishEventDTO;
import eap.weixin.sdk.dto.event.UnsubscribeEventDTO;
import eap.weixin.sdk.dto.event.ViewEventDTO;
import eap.weixin.sdk.dto.message.ReceiveImageMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveLinkMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveLocationMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveTextMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveVideoMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveVoiceMessageDTO;
import eap.weixin.sdk.handler.ICertificationHandler;
import eap.weixin.sdk.handler.IEventHandler;
import eap.weixin.sdk.handler.IMessageHandler;

/**
 * <p> Title: </p>
 * <p> Description: </p>
 * @作者 chiknin@gmail.com
 * @创建时间 
 * @版本 1.00
 * @修改记录
 * <pre>
 * 版本       修改人         修改时间         修改内容描述
 * ----------------------------------------
 * 
 * ----------------------------------------
 * </pre>
 */
public class DefaultWeixinDispatcherImpl implements IWeixinDispatcher {
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultWeixinDispatcherImpl.class);
	private static final Logger WEIXIN_MSG_LOG = LoggerFactory.getLogger("weixin.msg");
	
	private ICertificationHandler certificationHandler;
	
	private IMessageHandler messageHandler;
	
	private IEventHandler eventHandler;
	
	private ISafeAPI safeAPI;
	
	public void dispath(HttpServletRequest request, HttpServletResponse response) {
		String requestId = EDcodeUtil.uuid();
		String responseText = "";
		try {
			
			boolean inWhiteList = certificationHandler.inWhiteList(request); // TODO
			if (!inWhiteList) {
				LOG.info("RECEIVE_NOT_IN_WHITE_LIST {}", dumpRequest(request, null));
				return;
			}
		
			String requestMethod = request.getMethod();
			if ("GET".equalsIgnoreCase(requestMethod)) {
				responseText = doGet(requestId, request, response);
			}
			else if ("POST".equalsIgnoreCase(requestMethod)) {
				responseText = doPost(requestId, request, response);
			}
			
			WEIXIN_MSG_LOG.info("REPLY[{}] {}", requestId, responseText);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			WEIXIN_MSG_LOG.info("REPLY_ERROR[{}] {}", requestId, e.getMessage());
			return;
		}
		
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(responseText);
			pw.flush();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	private String doGet(String requestId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WEIXIN_MSG_LOG.info("RECEIVE[{}] {}", requestId, dumpRequest(request, null));
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		CheckMessageDTO checkMessageDTO = new CheckMessageDTO();
		checkMessageDTO.setSignature(signature);
		checkMessageDTO.setTimestamp(timestamp);
		checkMessageDTO.setNonce(nonce);
		checkMessageDTO.setEchostr(echostr);
		checkMessageDTO.setToken(certificationHandler.getToken(request));
		
		if (safeAPI.checkSource(checkMessageDTO)) {
			return checkMessageDTO.getEchostr();
		}
		
		LOG.debug("CHECK_SOURCE_FAIL[{}] {}", requestId, checkMessageDTO);
		return "";
	}
	
	private String doPost(String requestId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg;
		try {
			msg = IoUtil.toString(request.getInputStream());
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			WEIXIN_MSG_LOG.info("RECEIVE_ERROR[{}] {}", requestId, dumpRequest(request, null));
			return "";
		}
		WEIXIN_MSG_LOG.info("RECEIVE[{}] {}", requestId, dumpRequest(request, msg));
		
		EapContext.publish("weixin.inbound.BEFORE", new Object[] {request, response, requestId, msg});
		
		// TODO 除重
		
		String toUserName = XmlUtil.getXmlNodeText(msg, "ToUserName");
		String aesKey = null;
		if (StringUtil.isNotBlank(toUserName)) {
			aesKey = certificationHandler.getAesKey(toUserName);
		}
		
		String plaintextReqMsg = unwrapMessage(msg, aesKey);
		String plaintextRspMsg = parsePlaintextMessage(plaintextReqMsg);
		String rspMsg = wrapMessage(plaintextRspMsg, aesKey);
		
		EapContext.publish("weixin.inbound.AFTER", new Object[] {request, response, requestId, msg, rspMsg});
		
		return rspMsg;
	}
	
	private String unwrapMessage(String msg, String aesKey) {
		if (StringUtil.isBlank(aesKey)) {
			return msg;
		}
		
//		String encrypt = XmlUtil.getXmlNodeText(msg, "Encrypt");
//		return EDcodeUtil.aesDecodeForBase64AsString(encrypt, aesKey);
		return msg; // TODO
	}
	private String wrapMessage(String plaintextRspMsg, String aesKey) {
		return plaintextRspMsg;
	}
	
	private String parsePlaintextMessage(String msg) throws Exception {
		String msgType = XmlUtil.getXmlNodeText(msg, "MsgType");
		if (StringUtil.isBlank(msgType)) {
			LOG.debug("unknow msg type, " + msgType);
			return "";
		}
		
		MessageBaseDTO rspDTO = null;
		if (WeixinConst.MsgType.EVENT.equalsIgnoreCase(msgType)) {
			String event = XmlUtil.getXmlNodeText(msg, "Event");
			if (WeixinConst.Event.CLICK.equalsIgnoreCase(event)) {
				ClickEventDTO clickEventDTO = XmlUtil.parseXml(msg, ClickEventDTO.class);
				rspDTO = eventHandler.onClickEvent(clickEventDTO);
			} 
			else if(WeixinConst.Event.LOCATION.equalsIgnoreCase(event)) {
				LocationEventDTO locationEventDTO = XmlUtil.parseXml(msg, LocationEventDTO.class);
				rspDTO = eventHandler.onLocationEvent(locationEventDTO);
			} 
			else if (WeixinConst.Event.VIEW.equalsIgnoreCase(event)) {
				ViewEventDTO viewEventDTO = XmlUtil.parseXml(msg, ViewEventDTO.class);
				rspDTO = eventHandler.onViewEvent(viewEventDTO);
			}
			else if (WeixinConst.Event.SUBSCRIBE.equalsIgnoreCase(event)) {
				SubscribeEventDTO subscribeEventDTO = XmlUtil.parseXml(msg, SubscribeEventDTO.class);
				rspDTO = eventHandler.onSubscribeEvent(subscribeEventDTO);
			}
			else if (WeixinConst.Event.UNSUBSCRIBE.equalsIgnoreCase(event)) {
				UnsubscribeEventDTO unsubscribeEventDTO = XmlUtil.parseXml(msg, UnsubscribeEventDTO.class);
				rspDTO = eventHandler.onUnsubscribeEvent(unsubscribeEventDTO);
			}
			else if (WeixinConst.Event.SCAN.equalsIgnoreCase(event)) {
				ScanEventDTO scanEventDTO = XmlUtil.parseXml(msg, ScanEventDTO.class);
				rspDTO = eventHandler.onScanEvent(scanEventDTO);
			}
			else if (WeixinConst.Event.TEMPLATE_SEND_JOB_FINISH.equalsIgnoreCase(event)) {
				TemplateSendJobFinishEventDTO templateSendJobFinishEventDTO = XmlUtil.parseXml(msg, TemplateSendJobFinishEventDTO.class);
				eventHandler.onTemplateSendJobFinishEvent(templateSendJobFinishEventDTO);
			}
			else if (WeixinConst.Event.MASS_SEND_JOB_FINISH.equalsIgnoreCase(event)) {
				MassSendJobFinishEventDTO massSendJobFinishEventDTO = XmlUtil.parseXml(msg, MassSendJobFinishEventDTO.class);
				eventHandler.onMassSendJobFinishEvent(massSendJobFinishEventDTO);
			}
		} 
		else if (WeixinConst.MsgType.TEXT.equalsIgnoreCase(msgType)) {
			ReceiveTextMessageDTO textMsgDTO = XmlUtil.parseXml(msg, ReceiveTextMessageDTO.class);
			rspDTO = messageHandler.onTextMessage(textMsgDTO);
		}
		else if (WeixinConst.MsgType.IMAGE.equalsIgnoreCase(msgType)) {
			ReceiveImageMessageDTO imageMsgDTO = XmlUtil.parseXml(msg, ReceiveImageMessageDTO.class);
			rspDTO = messageHandler.onImageMessage(imageMsgDTO);
		} 
		else if (WeixinConst.MsgType.VOICE.equalsIgnoreCase(msgType)) {
			ReceiveVoiceMessageDTO voiceMsgDTO = XmlUtil.parseXml(msg, ReceiveVoiceMessageDTO.class);
			rspDTO = messageHandler.onVoiceMessage(voiceMsgDTO);
		} 
		else if (WeixinConst.MsgType.VIDEO.equalsIgnoreCase(msgType)) {
			ReceiveVideoMessageDTO videoMsgDTO = XmlUtil.parseXml(msg, ReceiveVideoMessageDTO.class);
			rspDTO = messageHandler.onVideoMessage(videoMsgDTO);
		} 
		else if (WeixinConst.MsgType.LOCATION.equalsIgnoreCase(msgType)) {
			ReceiveLocationMessageDTO locationMsgDTO = XmlUtil.parseXml(msg, ReceiveLocationMessageDTO.class);
			rspDTO = messageHandler.onLocationMessage(locationMsgDTO);
		} 
		else if (WeixinConst.MsgType.LINK.equalsIgnoreCase(msgType)) {
			ReceiveLinkMessageDTO linkMsgDTO = XmlUtil.parseXml(msg, ReceiveLinkMessageDTO.class);
			rspDTO = messageHandler.onLinkMessage(linkMsgDTO);
		}
		if (rspDTO != null) {
			Map<String, Object> marshallerProps = new HashMap<String, Object>();
			marshallerProps.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerProps.put(Marshaller.JAXB_ENCODING, "UTF-8");
			marshallerProps.put(Marshaller.JAXB_FRAGMENT, true);
			
			String replyMsg = XmlUtil.toXml(rspDTO, marshallerProps);
			return replyMsg;
		}
		
		return "";
	}
	
	private String dumpRequest(HttpServletRequest request, String body) {
		StringBuilder dump = new StringBuilder();
		dump.append(request.getMethod()).append(" ")
		.append(request.getRequestURL()).append(" ");
		
		StringBuilder headersBuf = new StringBuilder();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			
			StringBuilder headerValuesBuf = new StringBuilder();
			Enumeration<String> headerValues = request.getHeaders(headerName);
			while (headerValues.hasMoreElements()) {
				String headerValue = headerValues.nextElement();
				headerValuesBuf.append(headerValue).append(",");
			}
			if (headerValuesBuf.length() > 0) {
				headerValuesBuf = headerValuesBuf.deleteCharAt(headerValuesBuf.length() - 1);
			}
			headersBuf.append(headerName).append("=[").append(headerValuesBuf).append("]").append(",");
		}
		if (headersBuf.length() > 0) {
			headersBuf = headersBuf.deleteCharAt(headersBuf.length() - 1);
		}
		dump.append("HEADER:{").append(headersBuf).append("} ");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		if (paramMap != null && paramMap.size() > 0) {
			StringBuilder paramsBuf = new StringBuilder();
			for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
				paramsBuf.append(entry.getKey()).append("=[").append(StringUtil.join(entry.getValue(), ",")).append("],");
				
			}
			if (paramsBuf.length() > 0) {
				paramsBuf = paramsBuf.deleteCharAt(paramsBuf.length() - 1);
			}
			dump.append("PARAM_MAP:{").append(paramsBuf).append("} ");
		}
		
		if (StringUtil.isNotBlank(body)) {
			dump.append("BODY: ").append(body);
		}
		
		return dump.toString();
	}
	
	public void setCertificationHandler(ICertificationHandler certificationHandler) {
		this.certificationHandler = certificationHandler;
	}
	public void setMessageHandler(IMessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}
	public void setEventHandler(IEventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}
	public void setSafeAPI(ISafeAPI safeAPI) {
		this.safeAPI = safeAPI;
	}

	public static void main(String[] args) throws Exception {
		String xml = 
			"<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName> "
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>"
			+ "</xml>";
		
		ReceiveTextMessageDTO result = XmlUtil.parseXml(xml, ReceiveTextMessageDTO.class);
		System.out.println(ToStringBuilder.reflectionToString(result));
		
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		props.put(Marshaller.JAXB_ENCODING, "UTF-8");
		props.put(Marshaller.JAXB_FRAGMENT, true);
		
		result.setContent("hello wolrd");
		String toXml = XmlUtil.toXml(result, props);
		System.out.println(toXml);
	}
}