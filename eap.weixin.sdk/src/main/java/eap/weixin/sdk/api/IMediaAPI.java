package eap.weixin.sdk.api;

import eap.weixin.sdk.dto.media.MediaFileResponseDTO;
import eap.weixin.sdk.dto.media.MediaReponseDTO;
import eap.weixin.sdk.dto.media.NewsMediaDTO;
import eap.weixin.sdk.dto.media.VideoMediaDTO;

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
public interface IMediaAPI {
	public MediaReponseDTO uploadNewsMedia(IAccessTokenCallback accessTokenCallback, NewsMediaDTO newsMediaDTO) throws Exception;
	public MediaReponseDTO uploadVideoMedia(IAccessTokenCallback accessTokenCallback, VideoMediaDTO videoMediaDTO) throws Exception;
	public MediaFileResponseDTO getMedia(IAccessTokenCallback accessTokenCallback, String mediaId) throws Exception;
}