package eap.weixin.sdk.dto.qrcode;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;

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
public class QrcodeResponseDTO extends ResponseDTO {
	
	@JsonProperty("ticket")
	private String ticket;
	
	@JsonProperty("expire_seconds")
	private Long expireSeconds;
	
	@JsonProperty("url")
	private String url;

	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Long getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(Long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}