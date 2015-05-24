package eap.weixin.sdk.api.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
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
public class SafeAPIImplTest extends WeixinBaseTest {
	
	private ISafeAPI safeAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		safeAPI = new SafeAPIImpl();
		((SafeAPIImpl) safeAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void checkSource() throws Exception {
		CheckMessageDTO checkMsgDTO = new CheckMessageDTO();
		checkMsgDTO.setToken("123456");
		checkMsgDTO.setTimestamp("1417154451432");
		checkMsgDTO.setNonce("PVoFPY");
		checkMsgDTO.setEchostr("helloworld");
		
		checkMsgDTO.setSignature("f02ca2ed130688f687a7a79795a5cc306bc5ff69");
		
		boolean isLegal = safeAPI.checkSource(checkMsgDTO);
		System.out.println("[Output] checkSource -> " + isLegal);
		// [Output] checkSource -> true
	}
	
	@Test
	public void getWexinIpList() throws Exception {
		ServerListResponseDTO rspDTO  = safeAPI.getWexinIpList(accessTokenCallback);
		System.out.println("[Output] getWexinIpList -> " + JsonUtil.toJson(rspDTO));
		// [Output] getWexinIpList -> {"ip_list":["101.226.62.77","101.226.62.78","101.226.62.79","101.226.62.80","101.226.62.81","101.226.62.82","101.226.62.83","101.226.62.84","101.226.62.85","101.226.62.86","101.226.103.59","101.226.103.60","101.226.103.61","101.226.103.62","101.226.103.63","101.226.103.69","101.226.103.70","101.226.103.71","101.226.103.72","101.226.103.73","140.207.54.73","140.207.54.74","140.207.54.75","140.207.54.76","140.207.54.77","140.207.54.78","140.207.54.79","140.207.54.80"]}
	}
}
