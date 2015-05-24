package eap.weixin.sdk.api.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.IoUtil;
import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
import eap.weixin.sdk.api.IAuthAPI;
import eap.weixin.sdk.dto.auth.AccessTokenDTO;

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
public class AuthAPIImplTest extends WeixinBaseTest{
	
	private IAuthAPI authAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		authAPI = new AuthAPIImpl();
		((AuthAPIImpl) authAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void getAccessToken() {
		AccessTokenDTO rspDTO = authAPI.getAccessToken(appId, secret);
		System.out.println("[Output] getAccessToken -> " + JsonUtil.toJson(rspDTO));
		// [Output] getAccessToken -> {"access_token":"VtTqFC78XrLitjM9vp9euWtSaI1o-d0tpjbB9iD8SBBEWzdUeuwnixFqRc8stgmwF_OzzT3TO7E2JZO7ekko_f9ibbnWpNkL2lFzyN8d42g","expires_in":7200}
		
		try {
			IoUtil.write(rspDTO.getAccessToken(), new FileOutputStream("test-output/" + "AccessToken-" + appId + ".txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAccessToken_code() {
		
	}
	
	@Test
	public void refreshAccessToken() {
		
	}
}