package eap.weixin.sdk.dto.datacube.upstreammsg;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;

/**
 * <p> Title: 获取消息发送周数据 </p>
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
public class UpstreamMsgWeekResponseDTO extends ResponseDTO {
	
	@JsonProperty("list")
	private List<ItemDTO> itemDTOList;

	public List<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}
	public void setItemDTOList(List<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}

	public static class ItemDTO implements Serializable {
	
		/** 数据的日期 */
		@JsonProperty("ref_date")
		private String refDate; 
		
		/** 消息类型 */
		@JsonProperty("msg_type")
		private String msgType; 
		
		/** 上行发送了消息的用户数 */
		@JsonProperty("msg_user")
		private Long msgUser; 
		
		/** 上行发送了消息的消息总数 */
		@JsonProperty("msg_count")
		private Long msgCount;
	
		public String getRefDate() {
			return refDate;
		}
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}
		public String getMsgType() {
			return msgType;
		}
		public void setMsgType(String msgType) {
			this.msgType = msgType;
		}
		public Long getMsgUser() {
			return msgUser;
		}
		public void setMsgUser(Long msgUser) {
			this.msgUser = msgUser;
		}
		public Long getMsgCount() {
			return msgCount;
		}
		public void setMsgCount(Long msgCount) {
			this.msgCount = msgCount;
		}
	}
}