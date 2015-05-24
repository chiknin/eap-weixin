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
public class MpUserBO extends BaseBO {
	
	/**  */
	private String mpOpenId;
	/**  */
	private String openId;
	/**  */
	private String unionId;
	/**  */
	private String nickName;
	/**  */
	private String remark;
	/**  */
	private String sex;
	/**  */
	private String country;
	/**  */
	private String province;
	/**  */
	private String city;
	/**  */
	private String headImgUrl;
	/**  */
	private String language;
	/**  */
	private String subscribe;
	/**  */
	private Date subscribeTime;
	/**  */
	private String privilege;
	/**  */
	private Integer mpGroupId;
	/**  */
	private String qrcodeScene;
	
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public String getOpenId() {
		return this.openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUnionId() {
		return this.unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getNickName() {
		return this.nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadImgUrl() {
		return this.headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSubscribe() {
		return this.subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public Date getSubscribeTime() {
		return this.subscribeTime;
	}
	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public String getPrivilege() {
		return this.privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public Integer getMpGroupId() {
		return this.mpGroupId;
	}
	public void setMpGroupId(Integer mpGroupId) {
		this.mpGroupId = mpGroupId;
	}
	public String getQrcodeScene() {
		return this.qrcodeScene;
	}
	public void setQrcodeScene(String qrcodeScene) {
		this.qrcodeScene = qrcodeScene;
	}
}