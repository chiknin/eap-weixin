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
public class MpUserGroupBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/**  */
	private Integer mpGroupId;
	/**  */
	private String name;
	/**  */
	private Integer count;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public Integer getMpGroupId() {
		return this.mpGroupId;
	}
	public void setMpGroupId(Integer mpGroupId) {
		this.mpGroupId = mpGroupId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}