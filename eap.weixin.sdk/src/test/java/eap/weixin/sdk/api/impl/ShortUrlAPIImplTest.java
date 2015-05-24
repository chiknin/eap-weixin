package eap.weixin.sdk.api.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
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
public class ShortUrlAPIImplTest extends WeixinBaseTest {
	
	private IShortUrlAPI shortUrlAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		shortUrlAPI = new ShortUrlAPIImpl();
		((ShortUrlAPIImpl) shortUrlAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void toShortUrl() throws Exception {
		String longUrl = "http://58.135.84.44/weixin/gateway/weixin";
		ShortUrlResponseDTO rspDTO = shortUrlAPI.toShortUrl(accessTokenCallback, longUrl);
		System.out.println("[Output] getWexinIpList -> " + JsonUtil.toJson(rspDTO));
	}
}
