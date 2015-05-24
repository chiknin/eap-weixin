package eap.weixin.sdk.client;

import java.io.InputStream;

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
public interface IWeixinClient {
	
	// https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
	String buildSnsApiBaseUrl(String appId, String redirectUri, String state);
	
	// https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
	String buildSnsApiUserInfoUrl(String appId, String redirectUri, String state);
	
	// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	String getAccessToken(String appId, String secret);
	
	// https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	String getAccessToken(String appId, String secret, String code);
	
	
	
	// https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
	String getCallbackIp(String accessToken);
	
	// http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
	String postMediaUpload(String accessToken, MediaType mediaType, InputStream inputStream);
	
	// http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
	Object[] getMedia(String accessToken, String mediaId);
	
	// https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
	String postMessageCustomSend(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN
	String postMediaUploadNews(String accessToken, String data);
	
	// https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN 
	String postMediaUploadVideo(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN
	String postMessageMassSendAll(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN
	String postMessageMassSend(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN
	String postMessageMassDelete(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
	String postMessageTemplateSend(String accessToken, String data);
	
	
	
	// https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN
	String postGroupsCreate(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN
	String getGropus(String accessToken);
	
	// https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN
	String postGroupsGetId(String accessToken, String data); // getUserGroup
	
	// https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN
	String postGroupsUpdate(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN
	String postGroupsMembersUpdate(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN
	String postUserInfoUpdateRemark(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	String getUserInfo(String accessToken, String openId, String lang);
	
	// https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
	String getUserList(String accessToken, String nextOpenId);
	
	
	
	// https://api.weixin.qq.com/cgi-bin/customservice/getrecord?access_token=ACCESS_TOKEN
	String postCustomServiceRecord(String accessToken, String data);
	
	
	
	// https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
	String postMenuCreate(String accessToken, String data);
	
	// https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN
	String getMenu(String accessToken);
	
	// https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN
	String getMenuDelete(String accessToken);
	
	
	
	// https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
	String postQrcodeCreate(String accessToken, String data);
	
	// https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET
	Object[] getQrcode(String ticket);
	
	// https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET
	String getShowQrcodeUrl(String ticket);
	
	// https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN
	String postShortUrl(String accessToken, String data);
	
	
	// ----------------------
	// 数据统计接口
	// ----------------------
	
	/**
	 * 获取用户增减数据
	 * https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUserSummary(String accessToken, String data);

	/**
	 * 获取累计用户数据
	 * https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUserCumulate(String accessToken, String data);
	
	/**
	 * 获取图文群发每日数据
	 * https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetArticleSummary(String accessToken, String data);
	
	/**
	 * 获取图文群发总数据
	 * https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetArticleTotal(String accessToken, String data);
	
	/**
	 * 获取图文统计数据
	 * https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUserRead(String accessToken, String data);
	
	/**
	 * 获取图文统计分时数据
	 * https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUserReadHour(String accessToken, String data);
	
	/**
	 * 获取图文分享转发数据
	 * https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUserShare(String accessToken, String data);
	
	/**
	 * 获取图文分享转发分时数据
	 * https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUserShareHour(String accessToken, String data);
	
	/**
	 * 获取消息发送概况数据
	 * https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsg(String accessToken, String data);
	
	/**
	 * 获取消息分送分时数据
	 * https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsgHour(String accessToken, String data);
	
	/**
	 * 获取消息发送周数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsgWeek(String accessToken, String data);
	
	/**
	 * 获取消息发送月数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsgMonth(String accessToken, String data);
	
	/**
	 * 获取消息发送分布数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsgDist(String accessToken, String data);
	
	/**
	 * 获取消息发送分布周数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsgDistWeek(String accessToken, String data);
	
	/**
	 * 获取消息发送分布月数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetUpstreamMsgDistMonth(String accessToken, String data);
	
	/**
	 * 获取接口分析数据
	 * https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetInterfaceSummary(String accessToken, String data);
	
	/**
	 * 获取接口分析分时数据
	 * https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	String postDataCubeGetInterfaceSummaryHour(String accessToken, String data);

	/**
	 * 获取jsapi_ticket
	 * https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
	 * @param accessToken
	 * @return
	 */
	String getJsApiTicket(String accessToken);
}