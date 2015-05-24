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
public class MpReplyEventBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/** 事件 */
	private String event;
	/** 事件key */
	private String eventKey;
	/** 回复素材ID */
	private Long mediaId;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public String getEvent() {
		return this.event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventKey() {
		return this.eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public Long getMediaId() {
		return this.mediaId;
	}
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}
}