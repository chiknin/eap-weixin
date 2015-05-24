package eap.weixin.sdk.dto.datacube.article;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import eap.weixin.sdk.dto.ResponseDTO;

/**
 * <p> Title: 获取图文统计数据 </p>
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
public class UserReadResponseDTO extends ResponseDTO {
	
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
		
		/** 图文页的阅读人数 */
		@JsonProperty("int_page_read_user")
		private Long intPageReadUser;
		
		/** 图文页的阅读次数 */
		@JsonProperty("int_page_read_count")
		private Long intPageReadCount;
		
		/** 原文页的阅读人数 */
		@JsonProperty("ori_page_read_user")
		private Long oriPageReadUser;
		
		/** 原文页的阅读次数 */
		@JsonProperty("ori_page_read_count")
		private Long oriPageReadCount;
		
		/** 分享的人数 */
		@JsonProperty("share_user")
		private Long shareUser;
		
		/** 分享的次数 */
		@JsonProperty("share_count")
		private Long shareCount;
		
		/** 收藏的人数 */
		@JsonProperty("add_to_fav_user")
		private Long addToFavUser;
		
		/** 收藏的次数 */
		@JsonProperty("add_to_fav_count")
		private Long addToFavCount;

		public String getRefDate() {
			return refDate;
		}
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}
		public Long getIntPageReadUser() {
			return intPageReadUser;
		}
		public void setIntPageReadUser(Long intPageReadUser) {
			this.intPageReadUser = intPageReadUser;
		}
		public Long getIntPageReadCount() {
			return intPageReadCount;
		}
		public void setIntPageReadCount(Long intPageReadCount) {
			this.intPageReadCount = intPageReadCount;
		}
		public Long getOriPageReadUser() {
			return oriPageReadUser;
		}
		public void setOriPageReadUser(Long oriPageReadUser) {
			this.oriPageReadUser = oriPageReadUser;
		}
		public Long getOriPageReadCount() {
			return oriPageReadCount;
		}
		public void setOriPageReadCount(Long oriPageReadCount) {
			this.oriPageReadCount = oriPageReadCount;
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
		public Long getAddToFavUser() {
			return addToFavUser;
		}
		public void setAddToFavUser(Long addToFavUser) {
			this.addToFavUser = addToFavUser;
		}
		public Long getAddToFavCount() {
			return addToFavCount;
		}
		public void setAddToFavCount(Long addToFavCount) {
			this.addToFavCount = addToFavCount;
		}
	}
}