package eap.weixin.sdk.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.eclipse.persistence.oxm.annotations.XmlCDATA;

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
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageBaseDTO implements Serializable {
	
	@XmlElement(name="ToUserName")
	@XmlCDATA
	@JsonProperty("touser")
	private String toUser;
	
	@XmlElement(name="FromUserName")
	@XmlCDATA
	@JsonIgnore
	private String fromUser;
	
	@XmlElement(name="CreateTime")
	@JsonIgnore
	private Long createTime;
	
	@XmlElement(name="MsgType")
	@XmlCDATA
	@JsonProperty("msgtype")
	private String msgType;
	
	@XmlElement(name="MsgId")
	@JsonIgnore
	private String msgId;
	
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
}