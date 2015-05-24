package eap.weixin.sdk.dto.customservice;

import java.io.Serializable;
import java.util.List;

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
public class RecordListResponseDTO extends ResponseDTO {
	
	@JsonProperty("recordlist")
	private List<RecordDTO> recordList;

	public List<RecordDTO> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<RecordDTO> recordList) {
		this.recordList = recordList;
	}
	
	public static class RecordDTO implements Serializable {
		
		@JsonProperty("worker")
		private String worker;
		
		@JsonProperty("openid")
		private String openId;
		
		@JsonProperty("opercode")
		private String operCode;
		
		@JsonProperty("time")
		private Long time;
		
		@JsonProperty("text")
		private String text;
		
		public String getWorker() {
			return worker;
		}
		public void setWorker(String worker) {
			this.worker = worker;
		}
		public String getOpenId() {
			return openId;
		}
		public void setOpenId(String openId) {
			this.openId = openId;
		}
		public String getOperCode() {
			return operCode;
		}
		public void setOperCode(String operCode) {
			this.operCode = operCode;
		}
		public Long getTime() {
			return time;
		}
		public void setTime(Long time) {
			this.time = time;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
	}
}