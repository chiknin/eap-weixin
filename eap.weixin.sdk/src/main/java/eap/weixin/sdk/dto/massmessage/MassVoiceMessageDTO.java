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
public class MassVoiceMessageDTO extends MassMessageBaseDTO {
	
	@JsonProperty("voice")
	private VoiceDTO voiceDTO;
	
	public MassVoiceMessageDTO() {
		setMsgType(WeixinConst.MsgType.VOICE);
	}

	public VoiceDTO getVoiceDTO() {
		return voiceDTO;
	}
	public void setVoiceDTO(VoiceDTO voiceDTO) {
		this.voiceDTO = voiceDTO;
	}
	
	public static class VoiceDTO implements Serializable {
		
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