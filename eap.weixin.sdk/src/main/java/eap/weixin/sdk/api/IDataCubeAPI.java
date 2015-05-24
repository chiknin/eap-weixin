package eap.weixin.sdk.api;

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
public interface IDataCubeAPI {
	
	public UserSummaryResponseDTO getUserSummary(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UserCumulateResponseDTO getUserCumulate(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	
	public ArticleSummaryResponseDTO getArticleSummary(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public ArticleTotalResponseDTO getArticleTotal(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	
	public UserReadResponseDTO getUserRead(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UserReadHourResponseDTO getUserReadHour(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UserShareResponseDTO getUserShare(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UserShareHourResponseDTO getUserShareHour(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgResponseDTO getUpstreamMsg(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgHourResponseDTO getUpstreamMsgHour(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgWeekResponseDTO getUpstreamMsgWeek(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgMonthResponseDTO getUpstreamMsgMonth(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgDistResponseDTO getUpstreamMsgDist(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgDistWeekResponseDTO getUpstreamMsgDistWeek(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public UpstreamMsgDistMonthResponseDTO getUpstreamMsgDistMonth(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	
	public InterfaceSummaryResponseDTO getInterfaceSummary(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
	public InterfaceSummaryHourResponseDTO getInterfaceSummaryHour(IAccessTokenCallback accessTokenCallback, DateRangeDTO dateRangeDTO) throws Exception;
}