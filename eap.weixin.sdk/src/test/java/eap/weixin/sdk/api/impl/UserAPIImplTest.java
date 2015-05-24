package eap.weixin.sdk.api.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.api.IUserAPI;
import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.user.FansListResponseDTO;
import eap.weixin.sdk.dto.user.GroupResponseDTO;
import eap.weixin.sdk.dto.user.GroupsResponseDTO;
import eap.weixin.sdk.dto.user.UserGroupResponseDTO;
import eap.weixin.sdk.dto.user.UserInfoResponseDTO;

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
public class UserAPIImplTest extends WeixinBaseTest {
	
	private IUserAPI userAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		userAPI = new UserAPIImpl();
		((UserAPIImpl) userAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void getUserInfo() throws Exception {
//		String user = "oO7yRjtD8g2Q5_HXAjmfpY5V23nk";
		String user = "o4JIws8d3FPhU6CyG1Z9h0f9ei1E";
		String lang = WeixinConst.LANG.ZH_CN;
		UserInfoResponseDTO rspDTO = userAPI.getUserInfo(accessTokenCallback, user, lang);
		System.out.println("[Output] getUserInfo -> " + JsonUtil.toJson(rspDTO));
		// [Output] getUserInfo -> {"sex":"1","city":"西城","country":"中国","province":"北京","language":"zh_CN","subscribe":"1","openid":"oO7yRjtD8g2Q5_HXAjmfpY5V23nk","nickname":"chiknin","headimgurl":"http://wx.qlogo.cn/mmopen/I1OPdTuWhE8VJu4O9QeU6GuJ8rdWR6iacDmQvcWCOUtvtdxWphPYiaFUo9XYkdUWEFkY3pfXaLG8UYtTTEfh73GmeJqKciaM1fP/0","subscribe_time":1416994629}
	}
	
	@Test
	public void updateUserRemark() throws Exception {
		String user = "oO7yRjtD8g2Q5_HXAjmfpY5V23nk";
		String remark = "chiknin_gmail";
		ResponseDTO rspDTO = userAPI.updateUserRemark(accessTokenCallback, user, remark);
		System.out.println("[Output] updateUserRemark -> " + JsonUtil.toJson(rspDTO));
		// [Output] updateUserRemark -> {"errcode":"0","errmsg":"ok"}
	}
	
	@Test
	public void getFansList() throws Exception {
		String nextFansId = "";
		FansListResponseDTO rspDTO = userAPI.getFansList(accessTokenCallback, nextFansId);
		System.out.println("[Output] getFansList -> " + JsonUtil.toJson(rspDTO));
		// [Output] getFollowerList -> {"total":1,"count":1,"data":{"openid":["oO7yRjtD8g2Q5_HXAjmfpY5V23nk"]},"next_openid":"oO7yRjtD8g2Q5_HXAjmfpY5V23nk"}
	}
	
	@Test
	public void createGroup() throws Exception {
		String name = "VIP3";
		GroupResponseDTO rspDTO = userAPI.createGroup(accessTokenCallback, name);
		System.out.println("[Output] createGroup -> " + JsonUtil.toJson(rspDTO));
		// [Output] createGroup -> {"group":{"id":"101","name":"VIP3"}}
	}
	
	@Test
	public void getGroups() throws Exception {
		GroupsResponseDTO rspDTO = userAPI.getGroups(accessTokenCallback);
		System.out.println("[Output] getGroups -> " + JsonUtil.toJson(rspDTO));
		// [Output] getGroups -> {"groups":[{"id":"0","name":"未分组","count":0},{"id":"1","name":"黑名单","count":0},{"id":"2","name":"星标组","count":0},{"id":"100","name":"金牌粉丝","count":1},{"id":"101","name":"VIP3","count":0}]}
	}
	
	@Test
	public void getUserGroup() throws Exception {
		String user = "oO7yRjtD8g2Q5_HXAjmfpY5V23nk";
		UserGroupResponseDTO rspDTO = userAPI.getUserGroup(accessTokenCallback, user);
		System.out.println("[Output] getUserGroup -> " + JsonUtil.toJson(rspDTO));
		// [Output] getUserGroup -> {"groupid":"0"}
	}
	
	@Test
	public void updateGroupName() throws Exception {
		String groupId = "100";
		String newGroupName = "VIP4";
		ResponseDTO rspDTO = userAPI.updateGroupName(accessTokenCallback, groupId, newGroupName);
		System.out.println("[Output] updateGroupName -> " + JsonUtil.toJson(rspDTO));
		// [Output] updateGroupName -> {"errcode":"0","errmsg":"ok"}
	}
	
	@Test
	public void updateUserGroup() throws Exception {
		String user = "oO7yRjtD8g2Q5_HXAjmfpY5V23nk";
		String toGroupId = "0";
		ResponseDTO rspDTO = userAPI.updateUserGroup(accessTokenCallback, user, toGroupId);
		System.out.println("[Output] updateUserGroup -> " + JsonUtil.toJson(rspDTO));
		// [Output] updateUserGroup -> {"errcode":"0","errmsg":"ok"}
	}
}
