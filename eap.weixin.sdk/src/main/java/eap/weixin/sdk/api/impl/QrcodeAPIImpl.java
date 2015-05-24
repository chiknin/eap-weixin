package eap.weixin.sdk.api.impl;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IQrcodeAPI;
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
public class QrcodeAPIImpl extends AbstractAPI implements IQrcodeAPI {
	
	public QrcodeResponseDTO createQrcode(IAccessTokenCallback accessTokenCallback, final QrcodeDTO qrcodeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<QrcodeResponseDTO>() {
			public QrcodeResponseDTO execute(String accessToken) {
				String reqData = toJson(qrcodeDTO);
				String rspData = weixinClient.postQrcodeCreate(accessToken, reqData);
				return parseJson(rspData, QrcodeResponseDTO.class);
			}
		});
	}
	
	public QrcodeFileResponseDTO getQrcode(String ticket) throws Exception {
		Object[] rspData = weixinClient.getQrcode(ticket);
		if ((Boolean) rspData[0]) {
			QrcodeFileResponseDTO rspDTO = new QrcodeFileResponseDTO();
			rspDTO.setData((byte[]) rspData[1]);
			return rspDTO;
		} else { // error
			return parseJson((String) rspData[1], QrcodeFileResponseDTO.class);
		}
	}
	
	public String getQrcodeUrl(String ticket) throws Exception {
		return weixinClient.getShowQrcodeUrl(ticket);
	}
}