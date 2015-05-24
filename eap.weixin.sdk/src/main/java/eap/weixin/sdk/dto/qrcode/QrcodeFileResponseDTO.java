package eap.weixin.sdk.dto.qrcode;

import org.codehaus.jackson.annotate.JsonIgnore;

import eap.weixin.sdk.dto.ResponseDTO;


public class QrcodeFileResponseDTO extends ResponseDTO {
	
	@JsonIgnore
	private byte[] data;
	
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
}