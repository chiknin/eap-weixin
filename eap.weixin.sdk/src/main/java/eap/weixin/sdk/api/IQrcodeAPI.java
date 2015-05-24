package eap.weixin.sdk.api;

import eap.weixin.sdk.dto.qrcode.QrcodeDTO;
import eap.weixin.sdk.dto.qrcode.QrcodeFileResponseDTO;
import eap.weixin.sdk.dto.qrcode.QrcodeResponseDTO;

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
public interface IQrcodeAPI {
	public QrcodeResponseDTO createQrcode(IAccessTokenCallback accessTokenCallback, QrcodeDTO qrcodeDTO) throws Exception;
	public QrcodeFileResponseDTO getQrcode(String ticket) throws Exception;
	public String getQrcodeUrl(String ticket) throws Exception;
}