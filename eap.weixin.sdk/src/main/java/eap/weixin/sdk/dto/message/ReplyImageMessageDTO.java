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
public class ReplyImageMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="Image")
	@JsonProperty("image")
	private ImageDTO imageDTO;
	
	public ReplyImageMessageDTO() {
		setMsgType(WeixinConst.MsgType.IMAGE);
	}
	
	public ImageDTO getImageDTO() {
		return imageDTO;
	}
	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ImageDTO implements Serializable {
		
		@XmlElement(name="MediaId")
		@XmlCDATA
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