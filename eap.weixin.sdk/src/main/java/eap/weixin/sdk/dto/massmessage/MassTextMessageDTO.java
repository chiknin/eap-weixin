package eap.weixin.sdk.dto.massmessage;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.dto.MassMessageBaseDTO;

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
public class MassTextMessageDTO extends MassMessageBaseDTO {
	
	@JsonProperty("text")
	private TextDTO textDTO;

	public MassTextMessageDTO() {
		setMsgType(WeixinConst.MsgType.TEXT);
	}

	public TextDTO getTextDTO() {
		return textDTO;
	}
	public void setTextDTO(TextDTO textDTO) {
		this.textDTO = textDTO;
	}

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