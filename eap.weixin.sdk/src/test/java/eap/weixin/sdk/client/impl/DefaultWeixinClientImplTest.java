package eap.weixin.sdk.client.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.FileUtil;
import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.WeixinTestUtil;
import eap.weixin.sdk.client.IWeixinClient;
import eap.weixin.sdk.client.MediaType;

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
public class DefaultWeixinClientImplTest {
	
	private IWeixinClient weixinClient;
	
	private String appId;
	private String secret;
	private String accessToken;
	
	@BeforeClass
	public void beforeClass() {
		appId = "wx2795ed48af470051";
		secret = "8a37d4be54f288f3ea6a38002165c64f";
		weixinClient = WeixinTestUtil.buildWeixinClient();
		
		accessToken = "zo6-fOvEKy4jgS754KKnAtfR0ZLZXeyfor6kQ7ADbR6QH3voDGBb8R1meAsIdu8dSPxA4ILTqvFKLAgUF3INFkSgOulSsk5H0cOIeKFGNTM";
	}
	
	@Test
	public void buildSnsApiBaseUrl() {
		String result = weixinClient.buildSnsApiBaseUrl(appId, "http://www.e-nci.com", "1");
//		Assert.assertEquals(result, "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2795ed48af470051&redirect_uri=http%3A%2F%2Fwww.e-nci.com&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
		System.out.println("[Output] buildSnsApiBaseUrl -> " + result);
		// [Output] buildSnsApiBaseUrl -> https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2795ed48af470051&redirect_uri=http%3A%2F%2Fwww.e-nci.com&response_type=code&scope=snsapi_base&state=1#wechat_redirect
	}
	
	@Test
	public void buildSnsApiUserInfoUrl() {
		String result = weixinClient.buildSnsApiUserInfoUrl(appId, "http://www.e-nci.com", "1");
		System.out.println("[Output] buildSnsApiUserInfoUrl -> " + result);
		// [Output] buildSnsApiUserInfoUrl -> https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2795ed48af470051&redirect_uri=http://www.e-nci.com&response_type=code&scope=snsapi_base&state=1#wechat_redirect
	}
	
	@Test
	public void getAccessToken() {
		String accessToken = weixinClient.getAccessToken(appId, secret);
		System.out.println("[Output] getToken -> " + accessToken);
		// [Output] getToken -> {"access_token":"gi0FC4rlPXmIJVJ7YP809Mw2xKq-vL9E846sJ0p9SCUcNclZWUnulmgTgepHqZjzLawSVxJea-SCwOvpu_OywFICNXkvrMM76l_SEpWRELg","expires_in":7200}"
	}
	
	@Test
	public void getAccessToken_code() {
		String code = "";
		String result = weixinClient.getAccessToken(appId, secret, code);
		System.out.println("[Output] getAccessToken_code -> " + result);
	}
	
	@Test
	public void getCallbackIp() {
		String result = weixinClient.getCallbackIp(accessToken);
		System.out.println("[Output] getCallbackIp -> " + result);
		// [Output] getCallbackIp -> {"ip_list":["101.226.62.77","101.226.62.78","101.226.62.79","101.226.62.80","101.226.62.81","101.226.62.82","101.226.62.83","101.226.62.84","101.226.62.85","101.226.62.86","101.226.103.59","101.226.103.60","101.226.103.61","101.226.103.62","101.226.103.63","101.226.103.69","101.226.103.70","101.226.103.71","101.226.103.72","101.226.103.73","140.207.54.73","140.207.54.74","140.207.54.75","140.207.54.76","140.207.54.77","140.207.54.78","140.207.54.79","140.207.54.80"]}
	}
	
	@Test
	public void postMediaUpload() throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream(new File("/data/bride.jpg"));
		String result = weixinClient.postMediaUpload(accessToken, MediaType.IMAGE_JPG, inputStream);
		System.out.println("[Output] postMediaUpload -> " + result);
		// [Output] postMediaUpload -> {"type":"image","media_id":"-Oj4Sy5sKl_vB77vz0nnElLaTU0ZM1xWrwt_T6Jcq1G1i_kRemRhT-sWuQOgDd1G","created_at":1417015895}
		
//		FileInputStream inputStream = new FileInputStream(new File("/data/bride.jpg"));
//		String result = weixinClient.postMediaUpload(accessToken, MediaType.THUMB_JPG, inputStream);
//		System.out.println("[Output] postMediaUpload -> " + result);
		// [Output] postMediaUpload -> {"type":"thumb","thumb_media_id":"z_Xf3jBrEPBxGliwNy0gltT7wFoh0f6LEnqWB_VmHSWKankN3nUsITyC0UWrffaI","created_at":1417016644}
	}
	
	@Test
	public void getMedia() {
		String mediaId = "P8vzi8sKrAhKNHGHeAEWDEV9_RWpVuuVi9IJWIA6eePs-PEwYAuAQBpQ_xGPhRh1";
		Object[] mediaData = weixinClient.getMedia(accessToken, mediaId);
		if ((Boolean) mediaData[0]) {
			System.out.println("[Output] getMedia -> " + ((byte[])mediaData[1]).length);
			// [Output] getMedia -> 5246
			FileUtil.write("/data/bride-1.jpg", (byte[])mediaData[1], 1024 * 8);
		} else {
			System.out.println("[Output] getMedia -> " + mediaData[1]);
			// [Output] getMedia -> {"errcode":40007,"errmsg":"invalid media_id"}
		}
	}
	
	@Test
	public void postMessageCustomSend() {
		String result = weixinClient.postMessageCustomSend(accessToken, "{\"touser\":\"oO7yRjtD8g2Q5_HXAjmfpY5V23nk\",\"msgtype\":\"text\",\"text\":{\"content\":\"Hello World\"}}");
		System.out.println("[Output] postMessageCustomSend -> " + result);
		// {"errcode":0,"errmsg":"ok"}
	}
	
	@Test
	public void postMediaUploadNews() {
		String result = weixinClient.postMediaUploadNews(accessToken, "{\"articles\":[{\"thumb_media_id\":\"z_Xf3jBrEPBxGliwNy0gltT7wFoh0f6LEnqWB_VmHSWKankN3nUsITyC0UWrffaI\",\"author\":\"xxx\",\"title\":\"Happy Day\",\"content_source_url\":\"www.qq.com\",\"content\":\"content\",\"digest\":\"digest\",\"show_cover_pic\":\"1\"},{\"thumb_media_id\":\"z_Xf3jBrEPBxGliwNy0gltT7wFoh0f6LEnqWB_VmHSWKankN3nUsITyC0UWrffaI\",\"author\":\"xxx\",\"title\":\"Happy Day\",\"content_source_url\":\"www.qq.com\",\"content\":\"content\",\"digest\":\"digest\",\"show_cover_pic\":\"1\"}]}");
		System.out.println("[Output] postMediaUploadNews -> " + result);
		// [Output] postMediaUploadNews -> {"type":"news","media_id":"NdFyCZoWozu3Pe6JUTLrum0I_3ikflQbFCqldOrLLsxxZznwRRtt3jJ9G47z4sl5","created_at":1417016854}
	}
	
	@Test
	public void postMediaUploadVideo() {
		String result = weixinClient.postMediaUploadVideo(accessToken, "{\"media_id\": \"rF4UdIMfYK3efUfyoddYRMU50zMiRmmt_l0kszupYh_SzrcW5Gaheq05p_lHuOTQ\",\"title\":\"TITLE\",\"description\":\"Description\"}");
		System.out.println("[Output] postMediaUploadVideo -> " + result);
		// {"errcode":40007,"errmsg":"invalid media_id"}
	}
	
	@Test
	public void postMessageMassSendAll() {
		String result = weixinClient.postMessageMassSendAll(accessToken, "{\"filter\":{\"group_id\":\"2\"},\"mpnews\":{\"media_id\":\"123dsdajkasd231jhksad\"},\"msgtype\":\"mpnews\"}");
		System.out.println("[Output] postMessageMassSendAll -> " + result);
		// [Output] postMessageMassSendAll -> {"errcode":40007,"errmsg":"invalid media_id"}
	}
	
	@Test
	public void postMessageMassDelete() {
		String result = weixinClient.postMessageMassDelete(accessToken, "{\"msg_id\":30124}");
		System.out.println("[Output] postMessageMassDelete -> " + result);
		// [Output] postMessageMassDelete -> {"errcode":40059,"errmsg":"invalid msg id"}
	}
	
	@Test
	public void postMessageTemplateSend() {
		String result = weixinClient.postMessageTemplateSend(accessToken, "{\"touser\":\"OPENID\",\"template_id\":\"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY\",\"url\":\"http://weixin.qq.com/download\",\"topcolor\":\"#FF0000\",\"data\":{\"first\":{\"value\":\"您好，您已成功消费。\",\"color\":\"#0A0A0A\"},\"keynote1\":{\"value\":\"巧克力\",\"color\":\"#CCCCCC\"},\"keynote2\":{\"value\":\"39.8元\",\"color\":\"#CCCCCC\"},\"keynote3\":{\"value\":\"2014年9月16日\",\"color\":\"#CCCCCC\"},\"remark\":{\"value\":\"欢迎再次购买。\",\"color\":\"#173177\"}}}");
		System.out.println("[Output] postMessageTemplateSend -> " + result);
		// [Output] postMessageTemplateSend -> {"errcode":40003,"errmsg":"invalid openid"}
	}
	
	@Test
	public void postGroupsCreate() {
		String result = weixinClient.postGroupsCreate(accessToken, "{\"group\":{\"name\":\"group-A\"}}");
		System.out.println("[Output] postGroupsCreate -> " + result);
		// {"group":{"id":100,"name":"group-A"}}
	}
	
	@Test
	public void getGropus() {
		String result = weixinClient.getGropus(accessToken);
		System.out.println("[Output] getGropus -> " + result);
		// {"groups":[{"id":0,"name":"未分组","count":1},{"id":1,"name":"黑名单","count":0},{"id":2,"name":"星标组","count":0},{"id":100,"name":"group-A","count":0}]}
	}
	
	@Test
	public void postGroupsGetId() {
		String result = weixinClient.postGroupsGetId(accessToken, "{\"openid\":\"oO7yRjtD8g2Q5_HXAjmfpY5V23nk\"}");
		System.out.println("[Output] postGroupsGetId -> " + result);
		// [Output] postGroupsGetId -> {"groupid":100}
		// [Output] postGroupsGetId -> {"errcode":49003,"errmsg":"not match openid with appid"}
	}
	
	@Test
	public void postGroupsUpdate() {
		String result = weixinClient.postGroupsUpdate(accessToken, "{\"group\":{\"id\":100,\"name\":\"金牌粉丝\"}}");
		System.out.println("[Output] postGroupsUpdate -> " + result);
		// [Output] postGroupsUpdate -> {"errcode":0,"errmsg":"ok"}
	}
	
	@Test
	public void postGroupsMembersUpdate() {
		String result = weixinClient.postGroupsMembersUpdate(accessToken, "{\"openid\":\"oO7yRjtD8g2Q5_HXAjmfpY5V23nk\",\"to_groupid\":100}");
		System.out.println("[Output] postGroupsMembersUpdate -> " + result);
		// [Output] postGroupsMembersUpdate -> {"errcode":0,"errmsg":"ok"}
		// [Output] postGroupsMembersUpdate -> {"errcode":49003,"errmsg":"not match openid with appid"}
	}
	
	@Test
	public void postUserInfoUpdateRemark() {
		String result = weixinClient.postUserInfoUpdateRemark(accessToken, "{\"openid\":\"oO7yRjtD8g2Q5_HXAjmfpY5V23nk\",\"remark\":\"chiknin-test\"}");
		System.out.println("[Output] postUserInfoUpdateRemark -> " + result);
		// {"errcode":0,"errmsg":"ok"}
	}
	
	@Test
	public void getUserInfo() {
		String result = weixinClient.getUserInfo(accessToken, "oO7yRjtD8g2Q5_HXAjmfpY5V23nk", WeixinConst.LANG.ZH_CN);
		System.out.println("[Output] getUserInfo -> " + result);
		// [Output] getUserInfo -> {"subscribe":1,"openid":"oO7yRjtD8g2Q5_HXAjmfpY5V23nk","nickname":"chiknin","sex":1,"language":"zh_CN","city":"西城","province":"北京","country":"中国","headimgurl":"http:\/\/wx.qlogo.cn\/mmopen\/I1OPdTuWhE8VJu4O9QeU6GuJ8rdWR6iacDmQvcWCOUtvtdxWphPYiaFUo9XYkdUWEFkY3pfXaLG8UYtTTEfh73GmeJqKciaM1fP\/0","subscribe_time":1416994629,"remark":""}
	}
	
	@Test
	public void getUserList() {
		String result = weixinClient.getUserList(accessToken, "");
		System.out.println("[Output] getUserList -> " + result);
		// [Output] getUserList -> {"total":1,"count":1,"data":{"openid":["oO7yRjtD8g2Q5_HXAjmfpY5V23nk"]},"next_openid":"oO7yRjtD8g2Q5_HXAjmfpY5V23nk"}
	}
	
	@Test
	public void postCustomServiceRecord() {
		String result = weixinClient.postCustomServiceRecord(accessToken, "{\"starttime\":123456789,\"endtime\":987654321,\"openid\":\"\",\"pagesize\":10,\"pageindex\":1}");
		System.out.println("[Output] postCustomServiceRecord -> " + result);
		// [Output] postCustomServiceRecord -> {"recordlist":[]}
	}
	
	@Test
	public void postMenuCreate() {
		String result = weixinClient.postMenuCreate(accessToken, "{\"button\":[{\"name\":\"扫码\",\"sub_button\":[{\"type\":\"scancode_waitmsg\", \"name\": \"扫码带提示\",\"key\": \"rselfmenu_0_0\",\"sub_button\":[]},{\"type\": \"scancode_push\",\"name\": \"扫码推事件\",\"key\": \"rselfmenu_0_1\",\"sub_button\":[]}]},{\"name\":\"发图\",\"sub_button\":[{\"type\":\"pic_sysphoto\",\"name\":\"系统拍照发图\",\"key\":\"rselfmenu_1_0\",\"sub_button\":[]},{\"type\":\"pic_photo_or_album\",\"name\": \"拍照或者相册发图\",\"key\": \"rselfmenu_1_1\",\"sub_button\":[]},{\"type\":\"pic_weixin\",\"name\":\"微信相册发图\",\"key\":\"rselfmenu_1_2\",\"sub_button\":[]}]},{\"name\": \"发送位置\",\"type\":\"location_select\",\"key\":\"rselfmenu_2_0\"}]}");
		System.out.println("[Output] postMenuCreate -> " + result);
		// [Output] postMenuCreate -> {"errcode":0,"errmsg":"ok"}
	}
	
	@Test
	public void getMenu() {
		String result = weixinClient.getMenu(accessToken);
		System.out.println("[Output] getMenu -> " + result);
		// [Output] getMenu -> {"menu":{"button":[{"name":"扫码","sub_button":[{"type":"scancode_waitmsg","name":"扫码带提示","key":"rselfmenu_0_0","sub_button":[]},{"type":"scancode_push","name":"扫码推事件","key":"rselfmenu_0_1","sub_button":[]}]},{"name":"发图","sub_button":[{"type":"pic_sysphoto","name":"系统拍照发图","key":"rselfmenu_1_0","sub_button":[]},{"type":"pic_photo_or_album","name":"拍照或者相册发图","key":"rselfmenu_1_1","sub_button":[]},{"type":"pic_weixin","name":"微信相册发图","key":"rselfmenu_1_2","sub_button":[]}]},{"type":"location_select","name":"发送位置","key":"rselfmenu_2_0","sub_button":[]}]}}
		// [Output] getMenu -> {"errcode":46003,"errmsg":"menu no exist"}
	}
	
	@Test
	public void getMenuDelete() {
		String result = weixinClient.getMenuDelete(accessToken);
		System.out.println("[Output] getMenuDelete -> " + result);
		// [Output] getMenuDelete -> {"errcode":0,"errmsg":"ok"}
	}
	
	@Test
	public void postQrcodeCreate() {
		String result = weixinClient.postQrcodeCreate(accessToken, "{\"expire_seconds\": 1800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 1}}}");
		System.out.println("[Output] postQrcodeCreate -> " + result);
		// [Output] postQrcodeCreate -> {"ticket":"gQHg7zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL3ozVXVyNmJsR3haaXlGQ191VnYtAAIEDIp2VAMECAcAAA==","expire_seconds":1800,"url":"http:\/\/weixin.qq.com\/q\/z3Uur6blGxZiyFC_uVv-"}
	}
	
	@Test
	public void getQrcode() {
		Object[] qrcodeData = weixinClient.getQrcode("1gQHg7zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL3ozVXVyNmJsR3haaXlGQ191VnYtAAIEDIp2VAMECAcAAA==");
		if ((Boolean) qrcodeData[0]) {
			System.out.println("[Output] getQrcode -> " + ((byte[])qrcodeData[1]).length);
			// [Output] getMedia -> 28440
			FileUtil.write("/data/qrcode.jpg", (byte[])qrcodeData[1], 1024 * 8);
		} else {
			System.out.println("[Output] getQrcode -> " + qrcodeData[1]);
			// [Output] getMedia -> {"errcode":40007,"errmsg":"invalid media_id"}
		}
	}
	
	@Test
	public void postShortUrl() {
		String result = weixinClient.postShortUrl(accessToken, "{\"action\":\"long2short\",\"long_url\":\"http://58.135.84.44/weixin/gateway/weixin\"}");
		System.out.println("[Output] postShortUrl -> " + result);
		// {"errcode":48001,"errmsg":"api unauthorized"}
	}
}