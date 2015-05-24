package eap.weixin.sdk.dispatcher.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.XmlUtil;
import eap.weixin.sdk.WeixinBaseTest;
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
import eap.weixin.sdk.dto.message.ReplyImageMessageDTO;
import eap.weixin.sdk.dto.message.ReplyMusicMessageDTO;
import eap.weixin.sdk.dto.message.ReplyNewsMessageDTO;
import eap.weixin.sdk.dto.message.ReplyTextMessageDTO;
import eap.weixin.sdk.dto.message.ReplyVideoMessageDTO;
import eap.weixin.sdk.dto.message.ReplyVoiceMessageDTO;
import eap.weixin.sdk.dto.message.ReplyImageMessageDTO.ImageDTO;
import eap.weixin.sdk.dto.message.ReplyMusicMessageDTO.MusicDTO;
import eap.weixin.sdk.dto.message.ReplyNewsMessageDTO.ArticleDTO;
import eap.weixin.sdk.dto.message.ReplyNewsMessageDTO.NewsDTO;
import eap.weixin.sdk.dto.message.ReplyTextMessageDTO.TextDTO;
import eap.weixin.sdk.dto.message.ReplyVideoMessageDTO.VideoDTO;
import eap.weixin.sdk.dto.message.ReplyVoiceMessageDTO.VoiceDTO;
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
public class DefaultWeixinDispatcherTest extends WeixinBaseTest {
	
	private DefaultWeixinDispatcherImpl weixinDispatcher;
	
	@BeforeClass
	public void beforeClass() {
		weixinDispatcher = new DefaultWeixinDispatcherImpl();
		weixinDispatcher.setCertificationHandler(new CertificationHandlerImpl());
		weixinDispatcher.setEventHandler(new EventHandlerImpl());
		weixinDispatcher.setMessageHandler(new MessageHandlerImpl());
	}
	
	@Test
	public void checkSource() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/gateway/weixin/wx2795ed48af470051");
		// request.setQueryString("?timestamp=1417154451432&nonce=PVoFPY&signature=f02ca2ed130688f687a7a79795a5cc306bc5ff69&echostr=helloworld");
		request.addParameter("timestamp", "1417154451432");
		request.addParameter("nonce", "PVoFPY");
		request.addParameter("signature", "f02ca2ed130688f687a7a79795a5cc306bc5ff69");
		request.addParameter("echostr", "helloworld");
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] checkSource -> " + rspMsg);
		// [Output] checkSource -> helloworld
	}
	
	@Test
	public void onClickEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[CLICK]]></Event>"
			+ "<EventKey><![CDATA[EVENTKEY]]></EventKey>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onClickEvent -> " + rspMsg);
	}
	
	@Test
	public void onLocationEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[LOCATION]]></Event>"
			+ "<Latitude>23.137466</Latitude>"
			+ "<Longitude>113.352425</Longitude>"
			+ "<Precision>119.385040</Precision>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onLocationEvent -> " + rspMsg);
	}
	
	@Test
	public void onViewEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[VIEW]]></Event>"
			+ "<EventKey><![CDATA[www.qq.com]]></EventKey>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onViewEvent -> " + rspMsg);
	}
	
	@Test
	public void onSubscribeEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[subscribe]]></Event>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onSubscribeEvent -> " + rspMsg);
	}
	
	@Test
	public void onUnsubscribeEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[unsubscribe]]></Event>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onUnsubscribeEvent -> " + rspMsg);
	}
	
	@Test
	public void onScanEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[subscribe]]></Event>"
			+ "<EventKey><![CDATA[qrscene_123123]]></EventKey>"
			+ "<Ticket><![CDATA[TICKET]]></Ticket>"
		  + "</xml>"
			
//			"<xml>"
//			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
//			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
//			+ "<CreateTime>123456789</CreateTime>"
//			+ "<MsgType><![CDATA[event]]></MsgType>"
//			+ "<Event><![CDATA[SCAN]]></Event>"
//			+ "<EventKey><![CDATA[SCENE_VALUE]]></EventKey>"
//			+ "<Ticket><![CDATA[TICKET]]></Ticket>"
//		  + "</xml>"
			
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onScanEvent -> " + rspMsg);
	}
	
	@Test
	public void onTemplateSendJobFinishEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[gh_7f083739789a]]></ToUserName>"
			+ "<FromUserName><![CDATA[oia2TjuEGTNoeX76QEjQNrcURxG8]]></FromUserName>"
			+ "<CreateTime>1395658984</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[TEMPLATESENDJOBFINISH]]></Event>"
			+ "<MsgID>200163840</MsgID>"
			+ "<Status><![CDATA[success]]></Status>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onTemplateSendJobFinishEvent -> " + rspMsg);
	}
	
	@Test
	public void onMassSendJobFinishEvent() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[gh_3e8adccde292]]></ToUserName>"
			+ "<FromUserName><![CDATA[oR5Gjjl_eiZoUpGozMo7dbBJ362A]]></FromUserName>"
			+ "<CreateTime>1394524295</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[MASSSENDJOBFINISH]]></Event>"
			+ "<MsgID>1988</MsgID>"
			+ "<Status><![CDATA[sendsuccess]]></Status>"
			+ "<TotalCount>100</TotalCount>"
			+ "<FilterCount>80</FilterCount>"
			+ "<SentCount>75</SentCount>"
			+ "<ErrorCount>5</ErrorCount>"
			+ "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onMassSendJobFinishEvent -> " + rspMsg);
	}
	
	@Test
	public void onTextMessage() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>1348831860</CreateTime>"
			+ "<MsgType><![CDATA[text]]></MsgType>"
			+ "<Content><![CDATA[this is a test]]></Content>"
			+ "<MsgId>1234567890123456</MsgId>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onTextMessage -> " + rspMsg);
	}
	
	@Test
	public void onImageMessage() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>1348831860</CreateTime>"
			+ "<MsgType><![CDATA[image]]></MsgType>"
			+ "<PicUrl><![CDATA[this is a url]]></PicUrl>"
			+ "<MediaId><![CDATA[media_id]]></MediaId>"
			+ "<MsgId>1234567890123456</MsgId>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onImageMessage -> " + rspMsg);
	}
	
	@Test
	public void onVoiceMessage() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>1357290913</CreateTime>"
			+ "<MsgType><![CDATA[voice]]></MsgType>"
			+ "<MediaId><![CDATA[media_id]]></MediaId>"
			+ "<Format><![CDATA[Format]]></Format>"
			+ "<MsgId>1234567890123456</MsgId>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onVoiceMessage -> " + rspMsg);
	}
	
	@Test
	public void onVideoMessage() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>1357290913</CreateTime>"
			+ "<MsgType><![CDATA[video]]></MsgType>"
			+ "<MediaId><![CDATA[media_id]]></MediaId>"
			+ "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>"
			+ "<MsgId>1234567890123456</MsgId>"
		  + "</xml>"
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onVideoMessage -> " + rspMsg);
	}
	
	@Test
	public void onLocationMessage() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>1351776360</CreateTime>"
			+ "<MsgType><![CDATA[location]]></MsgType>"
			+ "<Location_X>23.134521</Location_X>"
			+ "<Location_Y>113.358803</Location_Y>"
			+ "<Scale>20</Scale>"
			+ "<Label><![CDATA[位置信息]]></Label>"
			+ "<MsgId>1234567890123456</MsgId>"
		  + "</xml>" 
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onLocationMessage -> " + rspMsg);
	}
	
	@Test
	public void onLinkMessage() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/gateway/weixin/wx2795ed48af470051");
		request.setContent((
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
			+ "<CreateTime>1351776360</CreateTime>"
			+ "<MsgType><![CDATA[link]]></MsgType>"
			+ "<Title><![CDATA[公众平台官网链接]]></Title>"
			+ "<Description><![CDATA[公众平台官网链接]]></Description>"
			+ "<Url><![CDATA[url]]></Url>"
			+ "<MsgId>1234567890123456</MsgId>"
		  + "</xml>" 
		).getBytes());
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		weixinDispatcher.dispath(request, response);
		
		String rspMsg = response.getContentAsString();
		System.out.println("[Output] onLinkMessage -> " + rspMsg);
	}
	
	
	public static class CertificationHandlerImpl implements ICertificationHandler {
		
		@Override
		public boolean inWhiteList(HttpServletRequest request) {
			return true;
		}
		
		public String getToken(HttpServletRequest request) {
			String uri = request.getRequestURI();
			String appId = "wx2795ed48af470051"; // get appId from uri
			String token = "123456"; // get token from appId
			return token; 
		}
		
		public String getAesKey(String openId) {
			return null;
			
//			String encodingAESKey = "";
//			String aesKey = EDcodeUtil.base64Encode(encodingAESKey + "=");
//			return aesKey;
		}
	}
	
	public static class EventHandlerImpl implements IEventHandler {

		@Override
		public MessageBaseDTO onClickEvent(ClickEventDTO reqDTO) {
			System.out.println("[EVENT] onClickEvent -> " + XmlUtil.toXml(reqDTO));
			
			ReplyTextMessageDTO textMsgDTO = new ReplyTextMessageDTO();
			textMsgDTO.setToUser(reqDTO.getFromUser());
			textMsgDTO.setFromUser(reqDTO.getToUser());
			textMsgDTO.setCreateTime(System.currentTimeMillis());
			textMsgDTO.setTextDTO(new TextDTO("hello"));
			
			return textMsgDTO;
		}

		@Override
		public MessageBaseDTO onLocationEvent(LocationEventDTO reqDTO) {
			System.out.println("[EVENT] onLocationEvent -> " + XmlUtil.toXml(reqDTO));
			
			ReplyTextMessageDTO textMsgDTO = new ReplyTextMessageDTO();
			textMsgDTO.setToUser(reqDTO.getFromUser());
			textMsgDTO.setFromUser(reqDTO.getToUser());
			textMsgDTO.setCreateTime(System.currentTimeMillis());
			textMsgDTO.setTextDTO(new TextDTO("hello"));
			
			return textMsgDTO;
		}

		@Override
		public MessageBaseDTO onViewEvent(ViewEventDTO reqDTO) {
			System.out.println("[EVENT] onViewEvent -> " + XmlUtil.toXml(reqDTO));
			
			return null;
		}

		@Override
		public MessageBaseDTO onSubscribeEvent(SubscribeEventDTO reqDTO) {
			System.out.println("[EVENT] onSubscribeEvent -> " + XmlUtil.toXml(reqDTO));
			
			ReplyImageMessageDTO imageMsgDTO = new ReplyImageMessageDTO();
			imageMsgDTO.setToUser(reqDTO.getFromUser());
			imageMsgDTO.setFromUser(reqDTO.getToUser());
			imageMsgDTO.setCreateTime(System.currentTimeMillis());
			imageMsgDTO.setImageDTO(new ImageDTO("P8vzi8sKrAhKNHGHeAEWDEV9_RWpVuuVi9IJWIA6eePs-PEwYAuAQBpQ_xGPhRh1"));
			
			return imageMsgDTO;
		}

		@Override
		public MessageBaseDTO onUnsubscribeEvent(UnsubscribeEventDTO reqDTO) {
			System.out.println("[EVENT] onUnsubscribeEvent -> " + XmlUtil.toXml(reqDTO));
			
			return null;
		}

		@Override
		public MessageBaseDTO onScanEvent(ScanEventDTO reqDTO) {
			System.out.println("[EVENT] onSubscribeEvent -> " + XmlUtil.toXml(reqDTO));
			
			ReplyVoiceMessageDTO voiceMsgDTO = new ReplyVoiceMessageDTO();
			voiceMsgDTO.setToUser(reqDTO.getFromUser());
			voiceMsgDTO.setFromUser(reqDTO.getToUser());
			voiceMsgDTO.setCreateTime(System.currentTimeMillis());
			voiceMsgDTO.setVoiceDTO(new VoiceDTO("1"));
			
			return voiceMsgDTO;
		}

		@Override
		public void onTemplateSendJobFinishEvent(TemplateSendJobFinishEventDTO reqDTO) {
			System.out.println("[EVENT] onTemplateSendJobFinishEvent -> " + XmlUtil.toXml(reqDTO));
		}

		@Override
		public void onMassSendJobFinishEvent(MassSendJobFinishEventDTO reqDTO) {
			System.out.println("[EVENT] onMassSendJobFinishEvent -> " + XmlUtil.toXml(reqDTO));
		}
	}
	
	public static class MessageHandlerImpl implements IMessageHandler {

		@Override
		public MessageBaseDTO onTextMessage(ReceiveTextMessageDTO reqDTO) {
			System.out.println("[EVENT] onTextMessage -> " + XmlUtil.toXml(reqDTO));
			
			ReplyVideoMessageDTO videoMsgDTO = new ReplyVideoMessageDTO();
			videoMsgDTO.setToUser(reqDTO.getFromUser());
			videoMsgDTO.setFromUser(reqDTO.getToUser());
			videoMsgDTO.setCreateTime(System.currentTimeMillis());
			
			VideoDTO videoDTO = new VideoDTO();
			videoDTO.setTitle("title");
			videoDTO.setDescription("description");
			videoDTO.setMediaId("1");
			videoMsgDTO.setVideoDTO(videoDTO);
			
			return videoMsgDTO;
		}

		@Override
		public MessageBaseDTO onImageMessage(ReceiveImageMessageDTO reqDTO) {
			System.out.println("[EVENT] onImageMessage -> " + XmlUtil.toXml(reqDTO));
			
			ReplyMusicMessageDTO musicMsgDTO = new ReplyMusicMessageDTO();
			musicMsgDTO.setToUser(reqDTO.getFromUser());
			musicMsgDTO.setFromUser(reqDTO.getToUser());
			musicMsgDTO.setCreateTime(System.currentTimeMillis());
			
			MusicDTO musicDTO = new MusicDTO();
			musicDTO.setTitle("TITLE");
			musicDTO.setDescription("DESCRIPTION");
			musicDTO.setMusicUrl("MUSIC_Url");
			musicDTO.setHqMusicUrl("HQ_MUSIC_Url");
			musicDTO.setThumbMediaId("1");
			musicMsgDTO.setMusicDTO(musicDTO);;
			
			return musicMsgDTO;
		}

		@Override
		public MessageBaseDTO onVoiceMessage(ReceiveVoiceMessageDTO reqDTO) {
			System.out.println("[EVENT] onVoiceMessage -> " + XmlUtil.toXml(reqDTO));
			
			return null;
		}

		@Override
		public MessageBaseDTO onVideoMessage(ReceiveVideoMessageDTO reqDTO) {
			System.out.println("[EVENT] onVideoMessage -> " + XmlUtil.toXml(reqDTO));
			
			return null;
		}

		@Override
		public MessageBaseDTO onLocationMessage(ReceiveLocationMessageDTO reqDTO) {
			System.out.println("[EVENT] onLocationMessage -> " + XmlUtil.toXml(reqDTO));
			
			ReplyNewsMessageDTO newsMessageDTO = new ReplyNewsMessageDTO();  
			newsMessageDTO.setToUser(reqDTO.getFromUser());
			newsMessageDTO.setFromUser(reqDTO.getToUser());
			newsMessageDTO.setCreateTime(System.currentTimeMillis());
			newsMessageDTO.setArticleCount(2);
			
			NewsDTO newsDTO = new NewsDTO();
			List<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
			
			ArticleDTO articleDTO_1 = new ArticleDTO();
			articleDTO_1.setTitle("title1");
			articleDTO_1.setDescription("description1");
			articleDTO_1.setPicUrl("picurl");
			articleDTO_1.setUrl("url");
			articleDTOList.add(articleDTO_1);
			
			ArticleDTO articleDTO_2 = new ArticleDTO();
			articleDTO_2.setTitle("title2");
			articleDTO_2.setDescription("description2");
			articleDTO_2.setPicUrl("picurl");
			articleDTO_2.setUrl("url");
			articleDTOList.add(articleDTO_2);
			
			newsDTO.setArticleDTOList(articleDTOList);
			newsMessageDTO.setNewsDTO(newsDTO);
			
			return newsMessageDTO;
		}

		@Override
		public MessageBaseDTO onLinkMessage(ReceiveLinkMessageDTO reqDTO) {
			System.out.println("[EVENT] onLinkMessage -> " + XmlUtil.toXml(reqDTO));
			
			return null;
		}
	}
}