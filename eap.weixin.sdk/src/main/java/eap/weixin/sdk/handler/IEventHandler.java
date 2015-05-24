package eap.weixin.sdk.handler;

import eap.weixin.sdk.dto.MessageBaseDTO;
import eap.weixin.sdk.dto.event.ClickEventDTO;
import eap.weixin.sdk.dto.event.LocationEventDTO;
import eap.weixin.sdk.dto.event.MassSendJobFinishEventDTO;
import eap.weixin.sdk.dto.event.ScanEventDTO;
import eap.weixin.sdk.dto.event.SubscribeEventDTO;
import eap.weixin.sdk.dto.event.TemplateSendJobFinishEventDTO;
import eap.weixin.sdk.dto.event.UnsubscribeEventDTO;
import eap.weixin.sdk.dto.event.ViewEventDTO;

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
public interface IEventHandler {
	
	public MessageBaseDTO onClickEvent(ClickEventDTO clickEventDTO) throws Exception;
	public MessageBaseDTO onLocationEvent(LocationEventDTO locationEventDTO) throws Exception;
	public MessageBaseDTO onViewEvent(ViewEventDTO viewEventDTO) throws Exception;
	public MessageBaseDTO onSubscribeEvent(SubscribeEventDTO subscribeEventDTO) throws Exception;
	public MessageBaseDTO onUnsubscribeEvent(UnsubscribeEventDTO unsubscribeEventDTO) throws Exception;
	public MessageBaseDTO onScanEvent(ScanEventDTO scanEventDTO) throws Exception;
	public void onTemplateSendJobFinishEvent(TemplateSendJobFinishEventDTO templateSendJobFinishEventDTO) throws Exception;
	public void onMassSendJobFinishEvent(MassSendJobFinishEventDTO massSendJobFinishEventDTO) throws Exception;
	
}