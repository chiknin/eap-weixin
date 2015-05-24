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
public class MpMenuBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/**  */
	private String type;
	/**  */
	private String name;
	/**  */
	private String key;
	/**  */
	private String url;
	/**  */
	private Integer ordinal;
	/**  */
	private Long parentId;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getOrdinal() {
		return this.ordinal;
	}
	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}
	public Long getParentId() {
		return this.parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}