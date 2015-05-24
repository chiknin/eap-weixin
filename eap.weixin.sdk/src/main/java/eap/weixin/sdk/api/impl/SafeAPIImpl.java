package eap.weixin.sdk.api.impl;

import java.util.Arrays;

import eap.util.EDcodeUtil;
import eap.util.StringUtil;
import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.ISafeAPI;
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
public class SafeAPIImpl extends AbstractAPI implements ISafeAPI {

	public boolean checkSource(CheckMessageDTO checkMsgDTO) throws Exception {
		String signature = checkMsgDTO.getSignature();
		if (StringUtil.isBlank(signature)) {
			return false;
		}
		
		String token = checkMsgDTO.getToken();
		if (StringUtil.isBlank(token)) {
			return false;
		}
		
		String timestamp = checkMsgDTO.getTimestamp();
		if (StringUtil.isBlank(timestamp)) {
			return false;
		}
		
		String nonce = checkMsgDTO.getNonce();
		if (StringUtil.isBlank(nonce)) {
			return false;
		}
		
		String[] plaintextArray = {token, timestamp, nonce};
		Arrays.sort(plaintextArray);
		String plaintext = StringUtil.join(plaintextArray);
		
		if (EDcodeUtil.sha1(plaintext).equalsIgnoreCase(signature)) {
			return true;
		}
		
		return false;
	}

	public ServerListResponseDTO getWexinIpList(IAccessTokenCallback accessTokenCallback) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ServerListResponseDTO>() {
			public ServerListResponseDTO execute(String accessToken) {
				String rspData = weixinClient.getCallbackIp(accessToken);
				return parseJson(rspData, ServerListResponseDTO.class);
			}
		});
	}
}