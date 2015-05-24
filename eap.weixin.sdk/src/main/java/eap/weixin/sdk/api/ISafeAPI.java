package eap.weixin.sdk.api;

import eap.weixin.sdk.dto.CheckMessageDTO;
import eap.weixin.sdk.dto.ServerListResponseDTO;

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
public interface ISafeAPI {
	boolean checkSource(CheckMessageDTO checkMsgDTO) throws Exception;
	ServerListResponseDTO getWexinIpList(IAccessTokenCallback accessTokenCallback) throws Exception;
}