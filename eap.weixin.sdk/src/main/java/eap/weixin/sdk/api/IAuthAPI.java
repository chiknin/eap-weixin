package eap.weixin.sdk.api;

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
public interface IAuthAPI {
	AccessTokenDTO getAccessToken(String appId, String secret);
	AccessTokenDTO getAccessToken(String appId, String secret, String code);
	AccessTokenDTO refreshAccessToken(String appId, String secret, String refreshToken);
	JsApiTicketDTO getJsApiTicket(IAccessTokenCallback accessTokenCallback) throws Exception;
}