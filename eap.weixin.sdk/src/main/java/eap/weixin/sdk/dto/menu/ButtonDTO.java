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
public class ButtonDTO implements Serializable {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("sub_button")
	private List<ButtonDTO> subButtonDTOList;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ButtonDTO> getSubButtonDTOList() {
		return subButtonDTOList;
	}
	public void setSubButtonDTOList(List<ButtonDTO> subButtonDTOList) {
		this.subButtonDTOList = subButtonDTOList;
	}
}