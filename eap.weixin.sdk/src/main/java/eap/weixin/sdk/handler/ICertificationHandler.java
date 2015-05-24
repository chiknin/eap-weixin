package eap.weixin.sdk.handler;

import javax.servlet.http.HttpServletRequest;

public interface ICertificationHandler {
	public boolean inWhiteList(HttpServletRequest request) throws Exception;
	public String getToken(HttpServletRequest request) throws Exception;
	public String getAesKey(String openId) throws Exception;
}