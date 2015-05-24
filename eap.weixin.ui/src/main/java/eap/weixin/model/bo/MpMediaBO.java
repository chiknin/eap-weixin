package eap.weixin.model.bo;

import java.util.Date;

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
public class MpMediaBO extends BaseBO {
	
	/** 公众号openid */
	private String mpOpenId;
	/** 媒体文件类型 */
	private String mediaType;
	/** 分组 */
	private Long groupId;
	/** 媒体文件格式 */
	private String format;
	/** 缩略图的媒体id（微信平台） */
	private String mpThumbMediaId;
	/** 消息的标题 */
	private String title;
	/** 消息内容 */
	private String description;
	/** 音乐链接 */
	private String musicUrl;
	/** 高品质音乐链接 */
	private String hqMusicUrl;
	/** 媒体id（微信平台） */
	private String mpMediaId;
	/** 创建时间（微信平台） */
	private Date mpCreatedTime;
	/** 文件名称 */
	private String fileName;
	/** 文件路径 */
	private String filePath;
	/** 如  是否过期 */
	private String status;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public String getMediaType() {
		return this.mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public Long getGroupId() {
		return this.groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getFormat() {
		return this.format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getMpThumbMediaId() {
		return this.mpThumbMediaId;
	}
	public void setMpThumbMediaId(String mpThumbMediaId) {
		this.mpThumbMediaId = mpThumbMediaId;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMusicUrl() {
		return this.musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String getHqMusicUrl() {
		return this.hqMusicUrl;
	}
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	public String getMpMediaId() {
		return this.mpMediaId;
	}
	public void setMpMediaId(String mpMediaId) {
		this.mpMediaId = mpMediaId;
	}
	public Date getMpCreatedTime() {
		return this.mpCreatedTime;
	}
	public void setMpCreatedTime(Date mpCreatedTime) {
		this.mpCreatedTime = mpCreatedTime;
	}
	public String getFileName() {
		return this.fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return this.filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}