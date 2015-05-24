package eap.weixin.sdk.api;

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
public interface IMenuAPI {
	public ResponseDTO createMenu(IAccessTokenCallback accessTokenCallback, MenuDTO menuDTO) throws Exception;
	public MenuResponseDTO getMenu(IAccessTokenCallback accessTokenCallback) throws Exception;
	public ResponseDTO deleteMenu(IAccessTokenCallback accessTokenCallback) throws Exception;
}