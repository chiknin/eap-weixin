package eap.weixin.sdk.api.impl;

import java.util.HashMap;
import java.util.Map;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IShortUrlAPI;
import eap.weixin.sdk.dto.shorturl.ShortUrlResponseDTO;

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
public class ShortUrlAPIImpl extends AbstractAPI implements IShortUrlAPI {
	
	public ShortUrlResponseDTO toShortUrl(IAccessTokenCallback accessTokenCallback, final String longUrl) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ShortUrlResponseDTO>() {
			public ShortUrlResponseDTO execute(String accessToken) {
				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("action", "long2short");
				reqMap.put("long_url", longUrl);
				
				String reqData = toJson(reqMap);
				String rspData = weixinClient.postShortUrl(accessToken, reqData);
				return parseJson(rspData, ShortUrlResponseDTO.class);
			}
		});
	}
}