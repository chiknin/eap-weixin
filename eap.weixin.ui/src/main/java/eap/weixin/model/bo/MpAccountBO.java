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
public class MpAccountBO extends BaseBO {
	
	/** 账号类型：1-订阅号，2-服务号，3-企业号 */
	private String accountType;
	/** 公众号名称 */
	private String accountName;
	/** 微信原始ID， openid */
	private String openId;
	/** 微信号 */
	private String mpNo;
	/** 登录邮箱 */
	private String email;
	/** 公众号头像URL */
	private String headImgUrl;
	/**  */
	private String qrcodePicUrl;
	/**  */
	private String language;
	/**  */
	private String description;
	/** 应用ID */
	private String appId;
	/** 应用密钥 */
	private String appSecret;
	/**  */
	private String serverUrl;
	/**  */
	private String token;
	/**  */
	private String aesKey;
	/**  */
	private String encryptionMode;
	
	public String getAccountType() {
		return this.accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountName() {
		return this.accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getOpenId() {
		return this.openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getMpNo() {
		return this.mpNo;
	}
	public void setMpNo(String mpNo) {
		this.mpNo = mpNo;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadImgUrl() {
		return this.headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getQrcodePicUrl() {
		return this.qrcodePicUrl;
	}
	public void setQrcodePicUrl(String qrcodePicUrl) {
		this.qrcodePicUrl = qrcodePicUrl;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAppId() {
		return this.appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return this.appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getServerUrl() {
		return this.serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAesKey() {
		return this.aesKey;
	}
	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}
	public String getEncryptionMode() {
		return this.encryptionMode;
	}
	public void setEncryptionMode(String encryptionMode) {
		this.encryptionMode = encryptionMode;
	}
}