package eap.weixin.sdk.dto.media;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

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
public class NewsMediaDTO implements Serializable {
	
	@JsonProperty("articles")
	private List<ArticleDTO> articleDTOList;
	
	public List<ArticleDTO> getArticleDTOList() {
		return articleDTOList;
	}
	public void setArticleDTOList(List<ArticleDTO> articleDTOList) {
		this.articleDTOList = articleDTOList;
	}
	
	public static class ArticleDTO implements Serializable {
		
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		
		@JsonProperty("author")
		private String author;
		
		@JsonProperty("title")
		private String title;
		
		@JsonProperty("content_source_url")
		private String contentSourceUrl;
		
		@JsonProperty("content")
		private String content;
		
		@JsonProperty("digest")
		private String digest;
		
		@JsonProperty("show_cover_pic")
		private String showConverPic;
		
		public String getThumbMediaId() {
			return thumbMediaId;
		}
		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContentSourceUrl() {
			return contentSourceUrl;
		}
		public void setContentSourceUrl(String contentSourceUrl) {
			this.contentSourceUrl = contentSourceUrl;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getDigest() {
			return digest;
		}
		public void setDigest(String digest) {
			this.digest = digest;
		}
		public String getShowConverPic() {
			return showConverPic;
		}
		public void setShowConverPic(String showConverPic) {
			this.showConverPic = showConverPic;
		}
	}
}