package eap.weixin.sdk.dto.event;

import javax.xml.bind.annotation.XmlRootElement;

import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.dto.EventBaseDTO;

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
@XmlRootElement(name="xml")
public class UnsubscribeEventDTO extends EventBaseDTO {
	public UnsubscribeEventDTO() {
		setMsgType(WeixinConst.MsgType.EVENT);
		setEvent(WeixinConst.Event.UNSUBSCRIBE);
	}
}