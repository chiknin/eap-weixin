package eap.weixin.sdk.api;

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
public interface ICustomServiceAPI {
	public RecordListResponseDTO getRecordList(IAccessTokenCallback accessTokenCallback, RecordQueryDTO recordQueryDTO) throws Exception;
}