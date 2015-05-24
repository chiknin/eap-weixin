package eap.weixin.sdk.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

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
public class MassMessageBaseDTO implements Serializable {
	
	@JsonProperty("msgtype")
	private String msgType;
	
	@JsonProperty("filter")
	private FilterDTO filterDTO;
	
	@JsonProperty("touser")
	private List<String> toUserList;
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public FilterDTO getFilterDTO() {
		return filterDTO;
	}
	public void setFilterDTO(FilterDTO filterDTO) {
		this.filterDTO = filterDTO;
	}
	public List<String> getToUserList() {
		return toUserList;
	}
	public void setToUserList(List<String> toUserList) {
		this.toUserList = toUserList;
	}
	
	public static class FilterDTO {
		
		@JsonProperty("group_id")
		private String groupId;
		
		public FilterDTO() {
		}
		
		public FilterDTO(String groupId) {
			this.groupId = groupId;
		}

		public String getGroupId() {
			return groupId;
		}

		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}
	}
}