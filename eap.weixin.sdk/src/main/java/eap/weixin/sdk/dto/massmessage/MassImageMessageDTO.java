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
public class MassImageMessageDTO extends MassMessageBaseDTO {
	
	@JsonProperty("image")
	private ImageDTO imageDTO;
	
	public MassImageMessageDTO() {
		setMsgType(WeixinConst.MsgType.IMAGE);
	}
	
	public ImageDTO getImageDTO() {
		return imageDTO;
	}
	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}

	public static class ImageDTO implements Serializable {
		
		@JsonProperty("media_id")
		private String mediaId;
		
		public ImageDTO() {
		}
		public ImageDTO(String mediaId) {
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