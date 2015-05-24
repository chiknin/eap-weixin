package eap.weixin.sdk.dto.datacube.inter;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;

/**
 * <p> Title: 获取接口分析分时数据 </p>
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
public class InterfaceSummaryHourResponseDTO extends ResponseDTO {
	
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
		
		/**  */
		@JsonProperty("ref_hour")
		private String refHour;
		
		/** 被动回复用户消息的次数 */
		@JsonProperty("callback_count")
		private Long callbackCount;
		
		/** 失败次数 */
		@JsonProperty("fail_count")
		private Long failCount;
		
		/** 总耗时 */
		@JsonProperty("total_time_cost")
		private Long totalTimeCost;
		
		/** 最大耗时 */
		@JsonProperty("max_time_cost")
		private Long maxTimeCost;

		public String getRefDate() {
			return refDate;
		}
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}
		public String getRefHour() {
			return refHour;
		}
		public void setRefHour(String refHour) {
			this.refHour = refHour;
		}
		public Long getCallbackCount() {
			return callbackCount;
		}
		public void setCallbackCount(Long callbackCount) {
			this.callbackCount = callbackCount;
		}
		public Long getFailCount() {
			return failCount;
		}
		public void setFailCount(Long failCount) {
			this.failCount = failCount;
		}
		public Long getTotalTimeCost() {
			return totalTimeCost;
		}
		public void setTotalTimeCost(Long totalTimeCost) {
			this.totalTimeCost = totalTimeCost;
		}
		public Long getMaxTimeCost() {
			return maxTimeCost;
		}
		public void setMaxTimeCost(Long maxTimeCost) {
			this.maxTimeCost = maxTimeCost;
		}
	}
}
