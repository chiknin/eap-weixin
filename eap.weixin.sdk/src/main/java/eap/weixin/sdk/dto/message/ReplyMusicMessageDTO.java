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
public class ReplyMusicMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="Music")
	@JsonProperty("music")
	private MusicDTO musicDTO;
	
	public ReplyMusicMessageDTO() {
		setMsgType(WeixinConst.MsgType.MUSIC);
	}
	
	public MusicDTO getMusicDTO() {
		return musicDTO;
	}
	public void setMusicDTO(MusicDTO musicDTO) {
		this.musicDTO = musicDTO;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class MusicDTO implements Serializable {
		
		@XmlElement(name="Title")
		@XmlCDATA
		@JsonProperty("title")
		private String title;
		
		@XmlElement(name="Description")
		@XmlCDATA
		@JsonProperty("description")
		private String description;
		
		@XmlElement(name="MusicUrl")
		@XmlCDATA
		@JsonProperty("musicurl")
		private String musicUrl;
		
		@XmlElement(name="HQMusicUrl")
		@XmlCDATA
		@JsonProperty("hqmusicurl")
		private String hqMusicUrl;
		
		@XmlElement(name="ThumbMediaId")
		@XmlCDATA
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		
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
		public String getMusicUrl() {
			return musicUrl;
		}
		public void setMusicUrl(String musicUrl) {
			this.musicUrl = musicUrl;
		}
		public String getHqMusicUrl() {
			return hqMusicUrl;
		}
		public void setHqMusicUrl(String hqMusicUrl) {
			this.hqMusicUrl = hqMusicUrl;
		}
		public String getThumbMediaId() {
			return thumbMediaId;
		}
		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}
	}
}