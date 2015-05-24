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
public class ReplyVideoMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="Video")
	@JsonProperty("video")
	private VideoDTO videoDTO;
	
	public ReplyVideoMessageDTO() {
		setMsgType(WeixinConst.MsgType.VIDEO);
	}
	
	public VideoDTO getVideoDTO() {
		return videoDTO;
	}
	public void setVideoDTO(VideoDTO videoDTO) {
		this.videoDTO = videoDTO;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class VideoDTO implements Serializable {
		
		@XmlElement(name="MediaId")
		@XmlCDATA
		@JsonProperty("media_id")
		private String mediaId;
		
		@XmlTransient
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		
		@XmlElement(name="Title")
		@XmlCDATA
		@JsonProperty("title")
		private String title;
		
		@XmlElement(name="Description")
		@XmlCDATA
		@JsonProperty("description")
		private String description;
		
		public String getMediaId() {
			return mediaId;
		}
		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
		public String getThumbMediaId() {
			return thumbMediaId;
		}
		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
}