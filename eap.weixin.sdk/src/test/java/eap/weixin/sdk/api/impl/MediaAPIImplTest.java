package eap.weixin.sdk.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
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
public class MediaAPIImplTest extends WeixinBaseTest {
	
	private IMediaAPI mediaAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		mediaAPI = new MediaAPIImpl();
		((MediaAPIImpl) mediaAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void uploadNewsMedia() throws Exception {
		NewsMediaDTO newsMediaDTO = new NewsMediaDTO();
		
		List<NewsMediaDTO.ArticleDTO> articleDTOList = new ArrayList<NewsMediaDTO.ArticleDTO>();
		NewsMediaDTO.ArticleDTO articleDTO = new NewsMediaDTO.ArticleDTO();
		articleDTO.setThumbMediaId("z_Xf3jBrEPBxGliwNy0gltT7wFoh0f6LEnqWB_VmHSWKankN3nUsITyC0UWrffaI");
		articleDTO.setAuthor("xxx");
		articleDTO.setTitle("Happy Day");
		articleDTO.setContentSourceUrl("www.qq.com");
		articleDTO.setContent("content");
		articleDTO.setDigest("digest");
		articleDTO.setShowConverPic("1");
		articleDTOList.add(articleDTO);
		newsMediaDTO.setArticleDTOList(articleDTOList);
		
		MediaReponseDTO rspDTO = mediaAPI.uploadNewsMedia(accessTokenCallback, newsMediaDTO);
		System.out.println("[Output] uploadNewsMedia -> " + JsonUtil.toJson(rspDTO));
		// [Output] uploadNewsMedia -> {"type":"news","media_id":"LrKKGgqpssXucrejMJcCv8UTmGVYJUWhC32kdJ1Os_aQMKt0snAX4Lqdg2NrFvu2","created_at":1417086571}
	}
	
	@Test
	public void uploadVideoMedia() throws Exception {
		VideoMediaDTO videoMediaDTO = new VideoMediaDTO();
		videoMediaDTO.setMediaId("rF4UdIMfYK3efUfyoddYRMU50zMiRmmt_l0kszupYh_SzrcW5Gaheq05p_lHuOTQ");
		videoMediaDTO.setTitle("TITLE");
		videoMediaDTO.setDescription("Description");
		
		MediaReponseDTO rspDTO = mediaAPI.uploadVideoMedia(accessTokenCallback, videoMediaDTO);
		System.out.println("[Output] uploadVideoMedia -> " + JsonUtil.toJson(rspDTO));
		// [Output] uploadVideoMedia -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void getMedia() throws Exception {
		MediaFileResponseDTO rspDTO = mediaAPI.getMedia(accessTokenCallback, "P8vzi8sKrAhKNHGHeAEWDEV9_RWpVuuVi9IJWIA6eePs-PEwYAuAQBpQ_xGPhRh1");
		if (rspDTO.getErrorCode() == null || "0".equals(rspDTO.getErrorCode())) {
			System.out.println("[Output] uploadVideoMedia -> " + rspDTO.getData().length);
			// [Output] uploadVideoMedia -> 5246
		} else {
			System.out.println("[Output] uploadVideoMedia -> " + rspDTO.getErrorCode() + ":" + rspDTO.getErrorMsg());
			// [Output] uploadVideoMedia -> 40007:invalid media_id
		}
	}
}
