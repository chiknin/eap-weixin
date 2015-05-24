package eap.weixin.sdk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import eap.util.IoUtil;
import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.client.IWeixinClient;

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
public class WeixinBaseTest {
	
	protected IWeixinClient weixinClient;
	
	protected String appId;
	protected String secret;
	protected String accessToken;
	
	protected IAccessTokenCallback accessTokenCallback;
	
	public void init() {
		appId = "wx2795ed48af470051";
//		appId = "wx9585e36bb24b3850";
//		appId = "wx93838e33b95677aa";
		secret = "8a37d4be54f288f3ea6a38002165c64f";
//		secret = "ace43ec8a26e008fc60da9565aa55515";
//		secret = "0ba19355ad55d74c2008675a505a0667";
		
		
		weixinClient = WeixinTestUtil.buildWeixinClient();
		
		try {
			accessToken = IoUtil.toString(new FileInputStream("test-output/" + "AccessToken-" + appId + ".txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		accessTokenCallback = new IAccessTokenCallback() {
			public String getAccessToken(int currentRetry) {
				return accessToken;
			}
		};
		
//		System.setProperty("https.protocols", "SSLv3,SSLv2Hello");
	}
}