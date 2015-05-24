package eap.weixin.sdk.dto.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
public class ReplyVoiceMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="Voice")
	@JsonProperty("voice")
	private VoiceDTO voiceDTO;
	
	public ReplyVoiceMessageDTO() {
		setMsgType(WeixinConst.MsgType.VIDEO);
	}
	
	public VoiceDTO getVoiceDTO() {
		return voiceDTO;
	}
	public void setVoiceDTO(VoiceDTO voiceDTO) {
		this.voiceDTO = voiceDTO;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class VoiceDTO implements Serializable {
		
		@XmlElement(name="MediaId")
		@XmlCDATA
		@JsonProperty("media_id")
		private String mediaId;
		
		public VoiceDTO() {
		}
		public VoiceDTO(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getMediaId() {
			return mediaId;
		}
		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}