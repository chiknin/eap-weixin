package eap.weixin.sdk.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eap.EapContext;
import eap.util.CharsetUtil;
import eap.util.EDcodeUtil;
import eap.util.UrlUtil;
import eap.weixin.sdk.client.ClientException;
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
public class DefaultWeixinClientImpl implements IWeixinClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultWeixinClientImpl.class);
	private static final Logger WEIXIN_MSG_LOG = LoggerFactory.getLogger("weixin.msg");
	
	private HttpClient httpClient;
	
	public String buildSnsApiBaseUrl(String appId, String redirectUri, String state) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={appid}&redirect_uri={redirect_uri}&response_type={response_type}&scope=snsapi_base&state={state}#wechat_redirect";
		return UrlUtil.formatUrl(url, new String[][] {
			{"appid", appId},
			{"redirect_uri", UrlUtil.encode(redirectUri)},
			{"state", state},
			{"response_type", "code"},
			{"scope", "snsapi_base"}
		});
	}

	public String buildSnsApiUserInfoUrl(String appId, String redirectUri, String state) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={appid}&redirect_uri={redirect_uri}&response_type={response_type}&scope=snsapi_base&state={state}#wechat_redirect";
		return UrlUtil.formatUrl(url, new String[][] {
			{"appid", appId},
			{"redirect_uri", UrlUtil.encode(redirectUri)},
			{"state", state},
			{"response_type", "code"},
			{"scope", "snsapi_userinfo"}
		});
	}

	public String getAccessToken(String appId, String secret) {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"appid", appId},
			{"secret", secret},
		});
		
		return httpGet(url);
	}

	public String getAccessToken(String appId, String secret, String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type=authorization_code";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"appid", appId},
			{"secret", secret},
			{"code", code},
		});
		
		return httpGet(url);
	}

	public String getCallbackIp(String accessToken) {
		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken}
		});
		
		return httpGet(url);
	}

	public String postMediaUpload(String accessToken, final MediaType mediaType, final InputStream inputStream) { // byte[] mediaBytes
		String url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token={access_token}&type={type}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
			{"type", mediaType.getMediaType()}
		});
		
		PostMethod httpMethod = new PostMethod(url);
		PartSource mediaPartSource = new PartSource() {
			@Override
			public long getLength() {
				try {
					return inputStream.available();
				} catch (IOException e) {
					LOG.debug(e.getMessage(), e);
					return 0;
				}
			}
			@Override
			public String getFileName() {
				return "noname." + mediaType.getFileFormat();
			}
			@Override
			public InputStream createInputStream() throws IOException {
				return inputStream;
			}
		};
		FilePart mediaFilePart = new FilePart("media", mediaPartSource, mediaType.getMineType(), "UTF-8");
		MultipartRequestEntity requestEntity = new MultipartRequestEntity(new Part[] {mediaFilePart}, httpMethod.getParams());
		httpMethod.setRequestEntity(requestEntity);
		
		return executeHttpMethod(httpMethod);
	}

	public Object[] getMedia(String accessToken, String mediaId) {
		String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token={access_token}&media_id={media_id}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
			{"media_id", mediaId}
		});
		
		GetMethod httpMethod = new GetMethod(url);
		byte[] rspBytes = executeHttpMethod0(httpMethod);
		
		Header[] headers = httpMethod.getResponseHeaders("Content-disposition");
		if (headers != null && headers.length > 0) {
			return new Object[] {true, rspBytes}; // mediaBytes
		} else {
			return new Object[] {false, CharsetUtil.getString(rspBytes, "UTF-8")};
		}
	}

	public String postMessageCustomSend(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postMediaUploadNews(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postMediaUploadVideo(String accessToken, String data) {
		String url = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postMessageMassSendAll(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	public String postMessageMassSend(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postMessageMassDelete(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postMessageTemplateSend(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postGroupsCreate(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String getGropus(String accessToken) {
		String url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpGet(url);
	}

	public String postGroupsGetId(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postGroupsUpdate(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postGroupsMembersUpdate(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	public String postUserInfoUpdateRemark(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String getUserInfo(String accessToken, String openId, String lang) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={access_token}&openid={openid}&lang={lang}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
			{"openid", openId},
			{"lang", lang}
		});
		
		return httpGet(url);
	}

	public String getUserList(String accessToken, String nextOpenId) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token={access_token}&next_openid={next_openid}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
			{"next_openid", nextOpenId}
		});
		
		return httpGet(url);
	}

	public String postCustomServiceRecord(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/customservice/getrecord?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String postMenuCreate(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public String getMenu(String accessToken) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken}
		});
		
		return httpGet(url);
	}

	public String getMenuDelete(String accessToken) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpGet(url);
	}

	public String postQrcodeCreate(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	public Object[] getQrcode(String ticket) {
		String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={ticket}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"ticket", UrlUtil.encode(ticket)}
		});
		
		GetMethod httpMethod = new GetMethod(url);
		byte[] rspBytes = executeHttpMethod0(httpMethod);
		
		Header[] headers = httpMethod.getResponseHeaders("Content-Type");
		if (headers != null && headers.length > 0 && "image/jpg".equalsIgnoreCase(headers[0].getValue())) {
			return new Object[] {true, rspBytes}; // mediaBytes
		} else {
			return new Object[] {false, CharsetUtil.getString(rspBytes, "UTF-8")};
		}
	}
	
	public String getShowQrcodeUrl(String ticket) {
		String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={ticket}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"ticket", UrlUtil.encode(ticket)}
		});
		
		return url;
	}
	
	public String postShortUrl(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
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
	public String postDataCubeGetUserSummary(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getusersummary?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}

	/**
	 * 获取累计用户数据
	 * https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUserCumulate(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getusercumulate?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取图文群发每日数据
	 * https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetArticleSummary(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取图文群发总数据
	 * https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetArticleTotal(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getarticletotal?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取图文统计数据
	 * https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUserRead(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getuserread?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取图文统计分时数据
	 * https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUserReadHour(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取图文分享转发数据
	 * https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUserShare(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getusershare?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取图文分享转发分时数据
	 * https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUserShareHour(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getusersharehour?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息发送概况数据
	 * https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsg(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息分送分时数据
	 * https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsgHour(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息发送周数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsgWeek(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息发送月数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsgMonth(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息发送分布数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsgDist(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息发送分布周数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsgDistWeek(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取消息发送分布月数据
	 * https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetUpstreamMsgDistMonth(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取接口分析数据
	 * https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetInterfaceSummary(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	/**
	 * 获取接口分析分时数据
	 * https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN
	 * @param accessToken
	 * @param data
	 * @return
	 */
	public String postDataCubeGetInterfaceSummaryHour(String accessToken, String data) {
		String url = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token={access_token}";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpPost(url, data);
	}
	
	public String getJsApiTicket(String accessToken) {
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={access_token}&type=jsapi";
		url = UrlUtil.formatUrl(url, new String[][] {
			{"access_token", accessToken},
		});
		
		return httpGet(url);
	}
	
	protected String httpPost(String url, String content) {
		String requestId = EDcodeUtil.uuid();
		WEIXIN_MSG_LOG.info("REQUEST[{}] {} {} {}", requestId, "POST", url, content);
		EapContext.publish("weixin.outbound.BEFORE", new Object[] {requestId, "POST", url, content});
		
		PostMethod httpMethod = new PostMethod(url);
		StringRequestEntity requestEntity = null;
		try {
			requestEntity = new StringRequestEntity(content, "text/plain", "UTF-8"); // TODO content-type  // Content-Type: text/plain; charset=UTF-8
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage(), e);
		}
		httpMethod.setRequestEntity(requestEntity);
		
		String rspBody = executeHttpMethod(httpMethod);
		
		WEIXIN_MSG_LOG.info("RESPONSE[{}] {}", requestId, rspBody);
		EapContext.publish("weixin.outbound.AFTER", new Object[] {requestId, "POST", url, content, rspBody});
		
		return rspBody;
	}
	protected String httpGet(String url) {
		String requestId = EDcodeUtil.uuid();
		WEIXIN_MSG_LOG.info("REQUEST[{}] {} {}", requestId, "GET", url);
		EapContext.publish("weixin.outbound.BEFORE", new Object[] {requestId, "GET", url});
		
		GetMethod httpMethod = new GetMethod(url);
		String rspBody = executeHttpMethod(httpMethod);
		
		WEIXIN_MSG_LOG.info("RESPONSE[{}] {}", requestId, rspBody);
		EapContext.publish("weixin.outbound.AFTER", new Object[] {requestId, "GET", url, rspBody});
		
		return rspBody;
	}
	protected String executeHttpMethod(HttpMethod httpMethod) {
		byte[] rsponseBody = executeHttpMethod0(httpMethod);
		return CharsetUtil.getString(rsponseBody, "UTF-8");
		
	}
	protected byte[] executeHttpMethod0(HttpMethod httpMethod) {
		try {
			int rspCode = httpClient.executeMethod(httpMethod);
			if (rspCode == HttpStatus.SC_OK) {
				return httpMethod.getResponseBody();
			} else {
				throw new ClientException(rspCode + "", "http status error, " + rspCode);
			}
		} catch (Exception e) {
			throw new ClientException(e.getMessage(), e);
		} finally {
			if (httpMethod != null) {
				httpMethod.releaseConnection();
			}
		}
	}

	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}
}