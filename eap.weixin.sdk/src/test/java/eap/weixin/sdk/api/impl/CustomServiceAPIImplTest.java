package eap.weixin.sdk.api.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
import eap.weixin.sdk.api.ICustomServiceAPI;
import eap.weixin.sdk.dto.customservice.RecordListResponseDTO;
import eap.weixin.sdk.dto.customservice.RecordQueryDTO;

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
public class CustomServiceAPIImplTest extends WeixinBaseTest {
	
	private ICustomServiceAPI customServiceAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		customServiceAPI = new CustomServiceAPIImpl();
		((CustomServiceAPIImpl) customServiceAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void getRecordList() throws Exception {
		RecordQueryDTO recordQueryDTO = new RecordQueryDTO();
		recordQueryDTO.setStartTime(123456789L);
		recordQueryDTO.setEndTime(987654321L);
		recordQueryDTO.setPageSize(10);
		recordQueryDTO.setPageIndex(1);
		
		RecordListResponseDTO rspDTO = customServiceAPI.getRecordList(accessTokenCallback, recordQueryDTO);
		System.out.println("[Output] getRecordList -> " + JsonUtil.toJson(rspDTO));
		// [Output] getRecordList -> {"recordlist":[]}
	}
}