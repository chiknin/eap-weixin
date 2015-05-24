package eap.weixin.sdk.api.impl;

import eap.weixin.sdk.api.IAccessTokenCallback;
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
public class CustomServiceAPIImpl extends AbstractAPI implements ICustomServiceAPI {

	public RecordListResponseDTO getRecordList(IAccessTokenCallback accessTokenCallback, final RecordQueryDTO recordQueryDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<RecordListResponseDTO>() {
			public RecordListResponseDTO execute(String accessToken) {
				String reqData = toJson(recordQueryDTO);
				String rspData = weixinClient.postCustomServiceRecord(accessToken, reqData);
				return parseJson(rspData, RecordListResponseDTO.class);
			}
		});
	}
}