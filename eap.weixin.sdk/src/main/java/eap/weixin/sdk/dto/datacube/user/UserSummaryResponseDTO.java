package eap.weixin.sdk.dto.datacube.user;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.datacube.user.UserCumulateResponseDTO.ItemDTO;

/**
 * <p> Title: 获取用户增减数据 </p>
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
public class UserSummaryResponseDTO extends ResponseDTO {
	
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
		
		/** 用户的渠道 */
		@JsonProperty("user_source")
		private String userSource;
		
		/** 新增的用户数量 */
		@JsonProperty("new_user")
		private Long newUser;
		
		/** 取消关注的用户数量 */
		@JsonProperty("cancel_user")
		private Long cancelUser;
	
		public String getRefDate() {
			return refDate;
		}
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}
		public String getUserSource() {
			return userSource;
		}
		public void setUserSource(String userSource) {
			this.userSource = userSource;
		}
		public Long getNewUser() {
			return newUser;
		}
		public void setNewUser(Long newUser) {
			this.newUser = newUser;
		}
		public Long getCancelUser() {
			return cancelUser;
		}
		public void setCancelUser(Long cancelUser) {
			this.cancelUser = cancelUser;
		}
	}
}