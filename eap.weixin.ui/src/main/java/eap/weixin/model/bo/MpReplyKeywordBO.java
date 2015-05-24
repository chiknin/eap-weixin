package eap.weixin.model.bo;

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
public class MpReplyKeywordBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/** 事件 */
	private String keyword;
	/** 回复素材ID */
	private Long mediaId;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public String getKeyword() {
		return this.keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getMediaId() {
		return this.mediaId;
	}
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}
}