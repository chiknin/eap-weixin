package eap.weixin.sdk.api;

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
public interface IMessageAPI {
	
	public ResponseDTO sendTextMessage(IAccessTokenCallback accessTokenCallback, ReplyTextMessageDTO textMessageDTO) throws Exception;
	public ResponseDTO sendImageMessage(IAccessTokenCallback accessTokenCallback, ReplyImageMessageDTO imageMessageDTO) throws Exception;
	public ResponseDTO sendVoiceMessage(IAccessTokenCallback accessTokenCallback, ReplyVoiceMessageDTO voiceMessageDTO) throws Exception;
	public ResponseDTO sendVideoMessage(IAccessTokenCallback accessTokenCallback, ReplyVideoMessageDTO videoMessageDTO) throws Exception;
	public ResponseDTO sendMusicMessage(IAccessTokenCallback accessTokenCallback, ReplyMusicMessageDTO musicMessageDTO) throws Exception;
	public ResponseDTO sendNewsMessage(IAccessTokenCallback accessTokenCallback, ReplyNewsMessageDTO newsMessageDTO) throws Exception;
	
	public ResponseDTO sendMassTextMessage(IAccessTokenCallback accessTokenCallback, MassTextMessageDTO massTextMessageDTO) throws Exception;
	public ResponseDTO sendMassImageMessage(IAccessTokenCallback accessTokenCallback, MassImageMessageDTO massImageMessageDTO) throws Exception;
	public ResponseDTO sendMassVoiceMessage(IAccessTokenCallback accessTokenCallback, MassVoiceMessageDTO massVoiceMessageDTO) throws Exception;
	public ResponseDTO sendMassMpnewMessage(IAccessTokenCallback accessTokenCallback, MassMpnewsMessageDTO massMpnewsMessageDTO) throws Exception;
	public ResponseDTO sendMassMpvideoMessage(IAccessTokenCallback accessTokenCallback, MassMpvideoMessageDTO massMpvideoMessageDTO) throws Exception;
	
	public ResponseDTO sendTemplateMessage(IAccessTokenCallback accessTokenCallback, TemplateMessageDTO templateMessageDTO) throws Exception;
}