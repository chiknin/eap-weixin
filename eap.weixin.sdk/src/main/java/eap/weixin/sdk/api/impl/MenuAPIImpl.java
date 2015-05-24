package eap.weixin.sdk.api.impl;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IMenuAPI;
import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.menu.MenuDTO;
import eap.weixin.sdk.dto.menu.MenuResponseDTO;

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
public class MenuAPIImpl extends AbstractAPI implements IMenuAPI {

	public ResponseDTO createMenu(IAccessTokenCallback accessTokenCallback, final MenuDTO menuDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String reqData = toJson(menuDTO);
				String rspData = weixinClient.postMenuCreate(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public MenuResponseDTO getMenu(IAccessTokenCallback accessTokenCallback) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<MenuResponseDTO>() {
			public MenuResponseDTO execute(String accessToken) {
				String rspData = weixinClient.getMenu(accessToken);
				return parseJson(rspData, MenuResponseDTO.class);
			}
		});
	}

	public ResponseDTO deleteMenu(IAccessTokenCallback accessTokenCallback) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				String rspData = weixinClient.getMenuDelete(accessToken);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}
}