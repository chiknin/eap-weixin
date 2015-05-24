package eap.weixin.sdk.dto.user;

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
public class GroupsResponseDTO extends ResponseDTO {
	
	@JsonProperty("groups")
	private List<GroupDTO> groupDTOList;

	public List<GroupDTO> getGroupDTOList() {
		return groupDTOList;
	}
	public void setGroupDTOList(List<GroupDTO> groupDTOList) {
		this.groupDTOList = groupDTOList;
	}
}