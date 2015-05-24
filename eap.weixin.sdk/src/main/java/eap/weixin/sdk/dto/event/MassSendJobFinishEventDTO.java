package eap.weixin.sdk.dto.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eap.weixin.sdk.dto.EventBaseDTO;

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
@XmlRootElement(name="xml")
public class MassSendJobFinishEventDTO extends EventBaseDTO {
	
	@XmlElement(name="Status")
	private String status;
	
	@XmlElement(name="TotalCount")
	private Integer totalCount;
	
	@XmlElement(name="FilterCount")
	private Integer filterCount;
	
	@XmlElement(name="SentCount")
	private Integer sentCount;
	
	@XmlElement(name="ErrorCount")
	private Integer errorCount;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getFilterCount() {
		return filterCount;
	}
	public void setFilterCount(Integer filterCount) {
		this.filterCount = filterCount;
	}
	public Integer getSentCount() {
		return sentCount;
	}
	public void setSentCount(Integer sentCount) {
		this.sentCount = sentCount;
	}
	public Integer getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}
}