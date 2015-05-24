package eap.weixin.sdk.dto.datacube.article;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;

/**
 * <p> Title: 获取图文分享转发分时数据 </p>
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
public class UserShareHourResponseDTO extends ResponseDTO {
	
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
		
		/** 数据的小时 */
		@JsonProperty("ref_hour")
		private String refHour;
		
		/** 分享的场景 */
		@JsonProperty("share_scene")
		private String shareScene;
		
		/** 数据的小时 */
		@JsonProperty("share_user")
		private Long shareUser;
		
		/** 分享的次数 */
		@JsonProperty("share_count")
		private Long shareCount;

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
		public String getShareScene() {
			return shareScene;
		}
		public void setShareScene(String shareScene) {
			this.shareScene = shareScene;
		}
		public Long getShareUser() {
			return shareUser;
		}
		public void setShareUser(Long shareUser) {
			this.shareUser = shareUser;
		}
		public Long getShareCount() {
			return shareCount;
		}
		public void setShareCount(Long shareCount) {
			this.shareCount = shareCount;
		}
	}
}