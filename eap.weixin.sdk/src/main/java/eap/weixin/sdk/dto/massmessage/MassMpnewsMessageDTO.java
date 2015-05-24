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
public class MassMpnewsMessageDTO extends MassMessageBaseDTO {
	
	@JsonProperty("mpnews")
	private MpnewsDTO mpnewsDTO;
	
	public MassMpnewsMessageDTO() {
		setMsgType(WeixinConst.MsgType.MPNEWS);
	}
	
	public MpnewsDTO getMpnewsDTO() {
		return mpnewsDTO;
	}
	public void setMpnewsDTO(MpnewsDTO mpnewsDTO) {
		this.mpnewsDTO = mpnewsDTO;
	}
	
	public static class MpnewsDTO implements Serializable {
		
		@JsonProperty("media_id")
		private String mediaId;
		
		public MpnewsDTO() {
		}
		public MpnewsDTO(String mediaId) {
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