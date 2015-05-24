package eap.weixin.sdk.api.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
import eap.weixin.sdk.api.IQrcodeAPI;
import eap.weixin.sdk.dto.qrcode.QrcodeDTO;
import eap.weixin.sdk.dto.qrcode.QrcodeFileResponseDTO;
import eap.weixin.sdk.dto.qrcode.QrcodeResponseDTO;

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
public class QrcodeAPIImplTest extends WeixinBaseTest {
	
	private IQrcodeAPI qrcodeAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		qrcodeAPI = new QrcodeAPIImpl();
		((QrcodeAPIImpl) qrcodeAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void createQrcode() throws Exception {
		QrcodeDTO qrcodeDTO = new QrcodeDTO();
		qrcodeDTO.setExpireSeconds(1800);
		qrcodeDTO.setActionName("QR_SCENE");
		qrcodeDTO.setActionInfoDTO(new QrcodeDTO.ActionInfoDTO(new QrcodeDTO.SceneDTO("1")));
		
		QrcodeResponseDTO rspDTO = qrcodeAPI.createQrcode(accessTokenCallback, qrcodeDTO);
		System.out.println("[Output] createQrcode -> " + JsonUtil.toJson(rspDTO));
		// [Output] createQrcode -> {"ticket":"gQG77zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0VIVlNRY0xsZWhZRG5ZOU54VnYtAAIEIAx4VAMECAcAAA==","url":"http://weixin.qq.com/q/EHVSQcLlehYDnY9NxVv-","expire_seconds":1800}
		// https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=
	}
	
	@Test
	public void getQrcode() throws Exception {
		String ticket = "1gQG77zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0VIVlNRY0xsZWhZRG5ZOU54VnYtAAIEIAx4VAMECAcAAA==";
		QrcodeFileResponseDTO rspDTO = qrcodeAPI.getQrcode(ticket);
		if (rspDTO.getErrorCode() == null || "0".equals(rspDTO.getErrorCode())) {
			System.out.println("[Output] getQrcode -> " + rspDTO.getData().length);
			// [Output] getQrcode -> 27308
		} else { // throw 404
			System.out.println("[Output] getQrcode -> " + rspDTO.getErrorCode() + ":" + rspDTO.getErrorMsg());
			// http status error, 404
		}
	}
}