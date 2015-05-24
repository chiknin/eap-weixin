package eap.weixin.sdk.dto.menu;

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
public class MenuDTO implements Serializable {
	
	@JsonProperty("button")
	private List<ButtonDTO> buttonDTOList;

	public List<ButtonDTO> getButtonDTOList() {
		return buttonDTOList;
	}

	public void setButtonDTOList(List<ButtonDTO> buttonDTOList) {
		this.buttonDTOList = buttonDTOList;
	}
}