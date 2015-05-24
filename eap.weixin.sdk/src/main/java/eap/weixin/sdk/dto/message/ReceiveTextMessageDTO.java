package eap.weixin.sdk.dto.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.dto.MessageBaseDTO;

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
public class ReceiveTextMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="Content")
	@XmlCDATA
	private String content;
	
	public ReceiveTextMessageDTO() {
		setMsgId(WeixinConst.MsgType.TEXT);
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}