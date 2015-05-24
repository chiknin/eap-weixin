package eap.weixin.sdk.api.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eap.util.JsonUtil;
import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.client.IWeixinClient;
import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.user.UserInfoResponseDTO;

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
public class AbstractAPI {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass()); 
	
	protected IWeixinClient weixinClient;
	
	protected String toJson(Object data) {
		if (data == null) {
			return "{}";
		}
		
		return JsonUtil.toJson(data);
	}
	
	protected <T> T parseJson(String json, Class<T> clazz) {
		if (json == null || json.length() == 0) {
			return null;
		}
		
		return JsonUtil.parseJson(json, clazz);
	}
	
	protected <T extends ResponseDTO> T request(IAccessTokenCallback accessTokenCallback, IRequestCallback<T> requestCallback) throws Exception {
		int retry = 0, retryNum = 1; // total execute 2 request
		ResponseDTO rspDTO = null;
		do {
			String accessToken = accessTokenCallback.getAccessToken(retry);
			rspDTO = requestCallback.execute(accessToken);
			if (rspDTO != null) {
				if ("42001".equals(rspDTO.getErrorCode())) { // access_token超时
					retry++;
					LOG.info("access_token expired ({}), {}", retry, accessToken);
					continue;
				}
			}
			return (T) rspDTO;
		} while (retry <= retryNum);
		
		return (T) rspDTO;
	}
	protected static interface IRequestCallback<T extends ResponseDTO> {
		T execute(String accessToken);
	}

	public void setWeixinClient(IWeixinClient weixinClient) {
		this.weixinClient = weixinClient;
	}
	
	public static void main(String[] args) throws Exception {
		AbstractAPI api = new AuthAPIImpl();
		UserInfoResponseDTO rspDTO = api.request(new IAccessTokenCallback() {
			@Override
			public String getAccessToken(int currentRetry) {
				return "" + System.nanoTime();
			}
		}, new IRequestCallback<UserInfoResponseDTO>() {
			@Override
			public UserInfoResponseDTO execute(String accessToken) {
				UserInfoResponseDTO r = new UserInfoResponseDTO();
				r.setErrorCode("42001");
				return r;
			}
		});
		
		System.out.println(ToStringBuilder.reflectionToString(rspDTO));
	}
}