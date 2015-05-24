package eap.weixin.sdk.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


public class ServerListResponseDTO extends ResponseDTO {
	
	@JsonProperty("ip_list")
	private List<String> ipList;

	public List<String> getIpList() {
		return ipList;
	}
	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}
}