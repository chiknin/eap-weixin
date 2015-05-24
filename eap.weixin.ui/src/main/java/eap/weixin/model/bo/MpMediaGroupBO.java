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
public class MpMediaGroupBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/**  */
	private String mediaType;
	/**  */
	private String groupName;
	/**  */
	private Integer count;
	/**  */
	private String builtin;
	
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
	public String getGroupName() {
		return this.groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getBuiltin() {
		return this.builtin;
	}
	public void setBuiltin(String builtin) {
		this.builtin = builtin;
	}
}