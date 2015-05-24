package eap.weixin.sdk.dto.templatemessage;

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
public class TemplateMessageDTO implements Serializable {
	
//	@JsonProperty("touser")
	private String toUser;
	
//	@JsonProperty("template_id")
	private String templateId;
	
//	@JsonProperty("url")
	private String url;
	
//	@JsonProperty("topcolor")
	private String topColor;
	
//	@JsonProperty("data")
	private List<DataItemDTO> dataList;
	
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopColor() {
		return topColor;
	}
	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}
	public List<DataItemDTO> getDataList() {
		return dataList;
	}
	public void setDataList(List<DataItemDTO> dataList) {
		this.dataList = dataList;
	}

	public static class DataItemDTO implements Serializable {
		
		private String name;
		private String value;
		private String color;
		
		public DataItemDTO() {
		}
		public DataItemDTO(String name, String value, String color) {
			this.name = name;
			this.value = value;
			this.color = color;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	}
}