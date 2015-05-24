package eap.weixin.sdk.dto.message;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
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
public class ReplyNewsMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="ArticleCount")
	@JsonIgnore
	private Integer articleCount;
	
	@XmlElement(name="Articles")
	@JsonProperty("news")
	private NewsDTO newsDTO;
	
	public ReplyNewsMessageDTO() {
		setMsgType(WeixinConst.MsgType.NEWS);
	}
	
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public NewsDTO getNewsDTO() {
		return newsDTO;
	}
	public void setNewsDTO(NewsDTO newsDTO) {
		this.newsDTO = newsDTO;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class NewsDTO implements Serializable {
		
		@XmlElement(name="item")
		@JsonProperty("articles")
		private List<ArticleDTO> articleDTOList;
		
		public List<ArticleDTO> getArticleDTOList() {
			return articleDTOList;
		}
		public void setArticleDTOList(List<ArticleDTO> articleDTOList) {
			this.articleDTOList = articleDTOList;
		}
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ArticleDTO implements Serializable {
		
		@XmlElement(name="Title")
		@XmlCDATA
		@JsonProperty("title")
		private String title;
		
		@XmlElement(name="Description")
		@XmlCDATA
		@JsonProperty("description")
		private String description;
		
		@XmlElement(name="PicUrl")
		@XmlCDATA
		@JsonProperty("picurl")
		private String picUrl;
		
		@XmlElement(name="Url")
		@XmlCDATA
		@JsonProperty("url")
		private String url;
		
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
		public String getPicUrl() {
			return picUrl;
		}
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
}