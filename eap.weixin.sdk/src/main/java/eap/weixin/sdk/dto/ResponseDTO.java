package eap.weixin.sdk.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.util.JsonUtil;

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
public class ResponseDTO implements Serializable {
	
	@JsonProperty("errcode")
	private String errorCode;
	
	@JsonProperty("errmsg")
	private String errorMsg;
	
	@JsonProperty("msgid") // === msg_id
	private String msgId;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getMsgId() {
		return msgId;
	}
	
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@JsonProperty("msg_id")
	public void setMsg_id(String msgId) {
		this.msgId = msgId;
	}
}