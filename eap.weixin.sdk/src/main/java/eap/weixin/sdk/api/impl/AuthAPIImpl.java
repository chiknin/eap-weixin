package eap.weixin.sdk.api.impl;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IAuthAPI;
import eap.weixin.sdk.dto.auth.AccessTokenDTO;
import eap.weixin.sdk.dto.auth.JsApiTicketDTO;

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
public class AuthAPIImpl extends AbstractAPI implements IAuthAPI {
	
	public AccessTokenDTO getAccessToken(String appId, String secret) {
		String rspData = weixinClient.getAccessToken(appId, secret);
		return parseJson(rspData, AccessTokenDTO.class);
	}
	
	public AccessTokenDTO getAccessToken(String appId, String secret, String code) {
		String rspData = weixinClient.getAccessToken(appId, secret, code);
		return parseJson(rspData, AccessTokenDTO.class);
	}
	
	public AccessTokenDTO refreshAccessToken(String appId, String secret, String refreshToken) {
		throw new UnsupportedOperationException("not implemented"); 
	}
	
	public JsApiTicketDTO getJsApiTicket(IAccessTokenCallback accessTokenCallback) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<JsApiTicketDTO>() {
			public JsApiTicketDTO execute(String accessToken) {
				String rspData = weixinClient.getJsApiTicket(accessToken);
				return parseJson(rspData, JsApiTicketDTO.class);
			}
		});
	}
}