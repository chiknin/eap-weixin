package eap.weixin.model.bo;

import java.math.BigDecimal;

import eap.base.BaseBO;


/**
 * <p> 标题: </p>
 * <p> 描述: </p>
 * @作者 fuumining
 * @创建时间 2015-05-24 12:07:56
 * @版本 1.00
 * @修改记录
 * <pre>
 * 版本       修改人         修改时间         修改内容描述
 * ----------------------------------------
 * 
 * ----------------------------------------
 * </pre>
 */
public class MpMediaArticleBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/**  */
	private Long mediaId;
	/**  */
	private String title;
	/** 消息的作者 */
	private String author;
	/** 消息摘要 */
	private String summary;
	/**  */
	private String content;
	/** 阅读原文链接 == url */
	private String contentSourceUrl;
	/**  */
	private BigDecimal ordinal;
	/** 缩略图的媒体id（微信平台） */
	private String mpThumbMediaId;
	/**  */
	private String picUrl;
	/** 是否显示封面，1为显示，0为不显示 */
	private String showCoverPic;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public Long getMediaId() {
		return this.mediaId;
	}
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSummary() {
		return this.summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentSourceUrl() {
		return this.contentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	public BigDecimal getOrdinal() {
		return this.ordinal;
	}
	public void setOrdinal(BigDecimal ordinal) {
		this.ordinal = ordinal;
	}
	public String getMpThumbMediaId() {
		return this.mpThumbMediaId;
	}
	public void setMpThumbMediaId(String mpThumbMediaId) {
		this.mpThumbMediaId = mpThumbMediaId;
	}
	public String getPicUrl() {
		return this.picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getShowCoverPic() {
		return this.showCoverPic;
	}
	public void setShowCoverPic(String showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
}