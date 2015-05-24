package eap.weixin.sdk.dto.menu;

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
public class MenuResponseDTO extends ResponseDTO {
	
	@JsonProperty("menu")
	private MenuDTO menuDTO;

	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}
}