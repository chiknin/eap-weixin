package eap.weixin.sdk.api.impl;

import eap.weixin.sdk.api.IAccessTokenCallback;
import eap.weixin.sdk.api.IDataCubeAPI;
import eap.weixin.sdk.dto.datacube.DateRangeDTO;
import eap.weixin.sdk.dto.datacube.article.ArticleSummaryResponseDTO;
import eap.weixin.sdk.dto.datacube.article.ArticleTotalResponseDTO;
import eap.weixin.sdk.dto.datacube.article.UserReadHourResponseDTO;
import eap.weixin.sdk.dto.datacube.article.UserReadResponseDTO;
import eap.weixin.sdk.dto.datacube.article.UserShareHourResponseDTO;
import eap.weixin.sdk.dto.datacube.article.UserShareResponseDTO;
import eap.weixin.sdk.dto.datacube.inter.InterfaceSummaryHourResponseDTO;
import eap.weixin.sdk.dto.datacube.inter.InterfaceSummaryResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgDistMonthResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgDistResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgDistWeekResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgHourResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgMonthResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgResponseDTO;
import eap.weixin.sdk.dto.datacube.upstreammsg.UpstreamMsgWeekResponseDTO;
import eap.weixin.sdk.dto.datacube.user.UserCumulateResponseDTO;
import eap.weixin.sdk.dto.datacube.user.UserSummaryResponseDTO;

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
public class DataCubeAPIImpl extends AbstractAPI implements IDataCubeAPI {

	public UserSummaryResponseDTO getUserSummary(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserSummaryResponseDTO>() {
			public UserSummaryResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUserSummary(accessToken, reqData);
				return parseJson(rspData, UserSummaryResponseDTO.class);
			}
		});
	}

	public UserCumulateResponseDTO getUserCumulate(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserCumulateResponseDTO>() {
			public UserCumulateResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUserCumulate(accessToken, reqData);
				return parseJson(rspData, UserCumulateResponseDTO.class);
			}
		});
	}

	public ArticleSummaryResponseDTO getArticleSummary(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ArticleSummaryResponseDTO>() {
			public ArticleSummaryResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetArticleSummary(accessToken, reqData);
				return parseJson(rspData, ArticleSummaryResponseDTO.class);
			}
		});
	}

	public ArticleTotalResponseDTO getArticleTotal(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ArticleTotalResponseDTO>() {
			public ArticleTotalResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetArticleTotal(accessToken, reqData);
				return parseJson(rspData, ArticleTotalResponseDTO.class);
			}
		});
	}

	public UserReadResponseDTO getUserRead(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserReadResponseDTO>() {
			public UserReadResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUserRead(accessToken, reqData);
				return parseJson(rspData, UserReadResponseDTO.class);
			}
		});
	}

	public UserReadHourResponseDTO getUserReadHour(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserReadHourResponseDTO>() {
			public UserReadHourResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUserReadHour(accessToken, reqData);
				return parseJson(rspData, UserReadHourResponseDTO.class);
			}
		});
	}

	public UserShareResponseDTO getUserShare(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserShareResponseDTO>() {
			public UserShareResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUserShare(accessToken, reqData);
				return parseJson(rspData, UserShareResponseDTO.class);
			}
		});
	}

	public UserShareHourResponseDTO getUserShareHour(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserShareHourResponseDTO>() {
			public UserShareHourResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUserShareHour(accessToken, reqData);
				return parseJson(rspData, UserShareHourResponseDTO.class);
			}
		});
	}

	public UpstreamMsgResponseDTO getUpstreamMsg(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgResponseDTO>() {
			public UpstreamMsgResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsg(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgResponseDTO.class);
			}
		});
	}

	public UpstreamMsgHourResponseDTO getUpstreamMsgHour(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgHourResponseDTO>() {
			public UpstreamMsgHourResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsgHour(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgHourResponseDTO.class);
			}
		});
	}

	public UpstreamMsgWeekResponseDTO getUpstreamMsgWeek(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgWeekResponseDTO>() {
			public UpstreamMsgWeekResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsgWeek(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgWeekResponseDTO.class);
			}
		});
	}

	public UpstreamMsgMonthResponseDTO getUpstreamMsgMonth(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgMonthResponseDTO>() {
			public UpstreamMsgMonthResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsgMonth(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgMonthResponseDTO.class);
			}
		});
	}

	public UpstreamMsgDistResponseDTO getUpstreamMsgDist(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgDistResponseDTO>() {
			public UpstreamMsgDistResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsgDist(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgDistResponseDTO.class);
			}
		});
	}

	public UpstreamMsgDistWeekResponseDTO getUpstreamMsgDistWeek(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgDistWeekResponseDTO>() {
			public UpstreamMsgDistWeekResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsgDistWeek(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgDistWeekResponseDTO.class);
			}
		});
	}

	public UpstreamMsgDistMonthResponseDTO getUpstreamMsgDistMonth(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UpstreamMsgDistMonthResponseDTO>() {
			public UpstreamMsgDistMonthResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetUpstreamMsgDistMonth(accessToken, reqData);
				return parseJson(rspData, UpstreamMsgDistMonthResponseDTO.class);
			}
		});
	}

	public InterfaceSummaryResponseDTO getInterfaceSummary(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<InterfaceSummaryResponseDTO>() {
			public InterfaceSummaryResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetInterfaceSummary(accessToken, reqData);
				return parseJson(rspData, InterfaceSummaryResponseDTO.class);
			}
		});
	}

	public InterfaceSummaryHourResponseDTO getInterfaceSummaryHour(IAccessTokenCallback accessTokenCallback, final DateRangeDTO dateRangeDTO) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<InterfaceSummaryHourResponseDTO>() {
			public InterfaceSummaryHourResponseDTO execute(String accessToken) {
				String reqData = toJson(dateRangeDTO);
				String rspData = weixinClient.postDataCubeGetInterfaceSummaryHour(accessToken, reqData);
				return parseJson(rspData, InterfaceSummaryHourResponseDTO.class);
			}
		});
	}
}