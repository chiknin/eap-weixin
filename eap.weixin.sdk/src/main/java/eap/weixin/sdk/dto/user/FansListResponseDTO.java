package eap.weixin.sdk.dto.user;

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
public class FansListResponseDTO extends ResponseDTO {
	
	@JsonProperty("total")
	private Integer total;
	
	@JsonProperty("count")
	private Integer count;
	
	@JsonProperty("data")
	private FansDTO fansDTO;
	
	@JsonProperty("next_openid")
	private String nextFansId;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public FansDTO getFansDTO() {
		return fansDTO;
	}
	public void setFansDTO(FansDTO fansDTO) {
		this.fansDTO = fansDTO;
	}
	public String getNextFansId() {
		return nextFansId;
	}
	public void setNextFansId(String nextFansId) {
		this.nextFansId = nextFansId;
	}
	
	public static class FansDTO implements Serializable {
		
		@JsonProperty("openid")
		private List<String> openIdList;

		public List<String> getOpenIdList() {
			return openIdList;
		}
		public void setOpenIdList(List<String> openIdList) {
			this.openIdList = openIdList;
		}
	}
}