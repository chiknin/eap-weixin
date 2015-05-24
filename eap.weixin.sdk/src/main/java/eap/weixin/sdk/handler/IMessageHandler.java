package eap.weixin.sdk.handler;

import eap.weixin.sdk.dto.MessageBaseDTO;
import eap.weixin.sdk.dto.message.ReceiveImageMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveLinkMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveLocationMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveTextMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveVideoMessageDTO;
import eap.weixin.sdk.dto.message.ReceiveVoiceMessageDTO;

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
public interface IMessageHandler {
	
	public MessageBaseDTO onTextMessage(ReceiveTextMessageDTO textMsgDTO) throws Exception;
	public MessageBaseDTO onImageMessage(ReceiveImageMessageDTO imageMsgDTO) throws Exception;
	public MessageBaseDTO onVoiceMessage(ReceiveVoiceMessageDTO voiceMsgDTO) throws Exception;
	public MessageBaseDTO onVideoMessage(ReceiveVideoMessageDTO videoMsgDTO) throws Exception;
	public MessageBaseDTO onLocationMessage(ReceiveLocationMessageDTO locationMsgDTO) throws Exception;
	public MessageBaseDTO onLinkMessage(ReceiveLinkMessageDTO linkMsgDTO) throws Exception;
	
}