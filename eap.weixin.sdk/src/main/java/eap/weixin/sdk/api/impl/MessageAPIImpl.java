package eap.weixin.sdk.api.impl;

import java.util.HashMap;
import java.util.Map;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IMessageAPI;
import eap.weixin.sdk.dto.MassMessageBaseDTO;
import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.massmessage.MassImageMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassMpnewsMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassMpvideoMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassTextMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassVoiceMessageDTO;
import eap.weixin.sdk.dto.message.ReplyImageMessageDTO;
import eap.weixin.sdk.dto.message.ReplyMusicMessageDTO;
import eap.weixin.sdk.dto.message.ReplyNewsMessageDTO;
import eap.weixin.sdk.dto.message.ReplyTextMessageDTO;
import eap.weixin.sdk.dto.message.ReplyVideoMessageDTO;
import eap.weixin.sdk.dto.message.ReplyVoiceMessageDTO;
import eap.weixin.sdk.dto.templatemessage.TemplateMessageDTO;
import eap.weixin.sdk.dto.templatemessage.TemplateMessageDTO.DataItemDTO;

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
public class MessageAPIImpl extends AbstractAPI implements IMessageAPI {

	public ResponseDTO sendTextMessage(IAccessTokenCallback accessTokenCallback, final ReplyTextMessageDTO textMessageDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(textMessageDTO);
				String rspData = weixinClient.postMessageCustomSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO sendImageMessage(IAccessTokenCallback accessTokenCallback, final ReplyImageMessageDTO imageMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(imageMessageDTO);
				String rspData = weixinClient.postMessageCustomSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO sendVoiceMessage(IAccessTokenCallback accessTokenCallback, final ReplyVoiceMessageDTO voiceMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(voiceMessageDTO);
				String rspData = weixinClient.postMessageCustomSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO sendVideoMessage(IAccessTokenCallback accessTokenCallback, final ReplyVideoMessageDTO videoMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(videoMessageDTO);
				String rspData = weixinClient.postMessageCustomSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO sendMusicMessage(IAccessTokenCallback accessTokenCallback, final ReplyMusicMessageDTO musicMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(musicMessageDTO);
				String rspData = weixinClient.postMessageCustomSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO sendNewsMessage(IAccessTokenCallback accessTokenCallback, final ReplyNewsMessageDTO newsMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(newsMessageDTO);
				String rspData = weixinClient.postMessageCustomSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO sendMassTextMessage(IAccessTokenCallback accessTokenCallback, final MassTextMessageDTO massTextMessageDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				return sendMassMessage(accessToken, massTextMessageDTO);
			}
		});
	}

	public ResponseDTO sendMassImageMessage(IAccessTokenCallback accessTokenCallback, final MassImageMessageDTO massImageMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				return sendMassMessage(accessToken, massImageMessageDTO);
			}
		});
	}

	public ResponseDTO sendMassVoiceMessage(IAccessTokenCallback accessTokenCallback, final MassVoiceMessageDTO massVoiceMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				return sendMassMessage(accessToken, massVoiceMessageDTO);
			}
		});
	}

	public ResponseDTO sendMassMpnewMessage(IAccessTokenCallback accessTokenCallback, final MassMpnewsMessageDTO massMpnewsMessageDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				return sendMassMessage(accessToken, massMpnewsMessageDTO);
			}
		});
	}
	
	public ResponseDTO sendMassMpvideoMessage(IAccessTokenCallback accessTokenCallback, final MassMpvideoMessageDTO massMpvideoMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				return sendMassMessage(accessToken, massMpvideoMessageDTO);
			}
		});
	}

	public ResponseDTO sendTemplateMessage(IAccessTokenCallback accessTokenCallback, final TemplateMessageDTO templateMessageDTO) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				Map<String, Object> reqDataMap = new HashMap<String, Object>();
				reqDataMap.put("touser", templateMessageDTO.getToUser());
				reqDataMap.put("template_id", templateMessageDTO.getTemplateId());
				reqDataMap.put("url", templateMessageDTO.getUrl());
				reqDataMap.put("topcolor", templateMessageDTO.getTopColor());
				
				Map<String, Map<String, Object>> dataItemDTOMap = new HashMap<String, Map<String, Object>>();
				for (DataItemDTO dataItemDTO : templateMessageDTO.getDataList()) {
					Map<String, Object> dataItemMap = new HashMap<String, Object>();
					dataItemMap.put("value", dataItemDTO.getValue());
					dataItemMap.put("color", dataItemDTO.getColor());
					dataItemDTOMap.put(dataItemDTO.getName(), dataItemMap);
				}
				reqDataMap.put("data", dataItemDTOMap);
				
				String reqData = toJson(reqDataMap);
				String rspData = weixinClient.postMessageTemplateSend(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}
	
	private ResponseDTO sendMassMessage(String accessToken, MassMessageBaseDTO reqDTO) {
		String reqData = toJson(reqDTO);
		String rspData = null;
		if (reqDTO.getFilterDTO() != null) { // group_id
			rspData = weixinClient.postMessageMassSendAll(accessToken, reqData);
		} else { // // touser
			rspData = weixinClient.postMessageMassSend(accessToken, reqData);
		}
		return parseJson(rspData, ResponseDTO.class);
	}
}