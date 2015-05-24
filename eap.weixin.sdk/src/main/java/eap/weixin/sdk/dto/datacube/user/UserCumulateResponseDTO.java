package eap.weixin.sdk.dto.datacube.user;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgDistMonthResponseDTO.ItemDTO;

/**
 * <p> Title: 获取累计用户数据 </p>
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
public class UserCumulateResponseDTO extends ResponseDTO {
	
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
		
		/** 总用户量 */
		@JsonProperty("cumulate_user")
		private Long cumulateUser;
	
		public String getRefDate() {
			return refDate;
		}
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}
		public Long getCumulateUser() {
			return cumulateUser;
		}
		public void setCumulateUser(Long cumulateUser) {
			this.cumulateUser = cumulateUser;
		}
	}
}