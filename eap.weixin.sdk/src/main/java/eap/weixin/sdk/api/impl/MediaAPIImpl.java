package eap.weixin.sdk.api.impl;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IMediaAPI;
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
public class MediaAPIImpl extends AbstractAPI implements IMediaAPI {

	public MediaReponseDTO uploadNewsMedia(IAccessTokenCallback accessTokenCallback, final NewsMediaDTO newsMediaDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<MediaReponseDTO>() {
			public MediaReponseDTO execute(String accessToken) {
				String reqData = toJson(newsMediaDTO);
				String rspData = weixinClient.postMediaUploadNews(accessToken, reqData);
				return parseJson(rspData, MediaReponseDTO.class);
			}
		});
	}

	public MediaReponseDTO uploadVideoMedia(IAccessTokenCallback accessTokenCallback, final VideoMediaDTO videoMediaDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<MediaReponseDTO>() {
			public MediaReponseDTO execute(String accessToken) {
				String reqData = toJson(videoMediaDTO);
				String rspData = weixinClient.postMediaUploadVideo(accessToken, reqData);
				return parseJson(rspData, MediaReponseDTO.class);
			}
		});
	}

	public MediaFileResponseDTO getMedia(IAccessTokenCallback accessTokenCallback, final String mediaId) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<MediaFileResponseDTO>() {
			public MediaFileResponseDTO execute(String accessToken) {
				Object[] rspData = weixinClient.getMedia(accessToken, mediaId);
				if ((Boolean) rspData[0]) {
					MediaFileResponseDTO rspDTO = new MediaFileResponseDTO();
					rspDTO.setData((byte[]) rspData[1]);
					return rspDTO;
				} else { // error
					return parseJson((String) rspData[1], MediaFileResponseDTO.class);
				}
			}
		});
	}
}