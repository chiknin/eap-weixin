package eap.weixin.sdk.dto.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonProperty;
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
public class ReplyTextMessageDTO extends MessageBaseDTO {
	
	@XmlTransient
	@JsonProperty("text")
	private TextDTO textDTO;
	
	@XmlElement(name="Content")
	@XmlCDATA
	private String content; // TODO -> textDTO
	
	public ReplyTextMessageDTO() {
		setMsgType(WeixinConst.MsgType.TEXT);
	}
	
	public TextDTO getTextDTO() {
		return textDTO;
	}
	public void setTextDTO(TextDTO textDTO) {
		this.textDTO = textDTO;
		if (this.textDTO != null) {
			this.content = this.textDTO.getContent();
		}
	}
	public String getContent() {
		return textDTO != null ? textDTO.getContent() : null;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class TextDTO implements Serializable {
		
		@JsonProperty("content")
		private String content;
		
		public TextDTO() {
		}
		public TextDTO(String content) {
			this.content = content;
		}

		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
}