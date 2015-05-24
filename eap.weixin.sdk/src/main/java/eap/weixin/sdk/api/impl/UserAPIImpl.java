package eap.weixin.sdk.api.impl;

import java.util.HashMap;
import java.util.Map;

import eap.weixin.sdk.api.IAccessTokenCallback;
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
public class UserAPIImpl extends AbstractAPI implements IUserAPI {

	public UserInfoResponseDTO getUserInfo(IAccessTokenCallback accessTokenCallback, final String user, final String lang) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserInfoResponseDTO>() {
			public UserInfoResponseDTO execute(String accessToken) {
				String rspData = weixinClient.getUserInfo(accessToken, user, lang);
				return parseJson(rspData, UserInfoResponseDTO.class);
			}
		});
	}

	public ResponseDTO updateUserRemark(IAccessTokenCallback accessTokenCallback, final String user, final String remark) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("openid", user);
				reqMap.put("remark", remark);
				
				String reqData = toJson(reqMap);
				String rspData = weixinClient.postUserInfoUpdateRemark(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public FansListResponseDTO getFansList(IAccessTokenCallback accessTokenCallback, final String nextFansId) throws Exception{
		return request(accessTokenCallback, new IRequestCallback<FansListResponseDTO>() {
			public FansListResponseDTO execute(String accessToken) {
				String rspData = weixinClient.getUserList(accessToken, nextFansId);
				return parseJson(rspData, FansListResponseDTO.class);
			}
		});
	}

	public GroupResponseDTO createGroup(IAccessTokenCallback accessTokenCallback, final String name) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<GroupResponseDTO>() {
			public GroupResponseDTO execute(String accessToken) {
				Map<String, Object> reqMap = new HashMap<String, Object>();
				Map<String, Object> reqGroupMap = new HashMap<String, Object>();
				reqGroupMap.put("name", name);
				reqMap.put("group", reqGroupMap);
				
				String reqData = toJson(reqMap);
				String rspData = weixinClient.postGroupsCreate(accessToken, reqData);
				return parseJson(rspData, GroupResponseDTO.class);
			}
		});
	}

	public GroupsResponseDTO getGroups(IAccessTokenCallback accessTokenCallback) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<GroupsResponseDTO>() {
			public GroupsResponseDTO execute(String accessToken) {
				String rspData = weixinClient.getGropus(accessToken);
				return parseJson(rspData, GroupsResponseDTO.class);
			}
		});
	}

	public UserGroupResponseDTO getUserGroup(IAccessTokenCallback accessTokenCallback, final String user) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<UserGroupResponseDTO>() {
			public UserGroupResponseDTO execute(String accessToken) {
				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("openid", user);
				
				String reqData = toJson(reqMap);
				String rspData = weixinClient.postGroupsGetId(accessToken, reqData);
				return parseJson(rspData, UserGroupResponseDTO.class);
			}
		});
	}

	public ResponseDTO updateGroupName(IAccessTokenCallback accessTokenCallback, final String groupId, final String newGroupName) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				Map<String, Object> reqMap = new HashMap<String, Object>();
				Map<String, Object> reqGroupMap = new HashMap<String, Object>();
				reqGroupMap.put("id", groupId);
				reqGroupMap.put("name", newGroupName);
				reqMap.put("group", reqGroupMap);
				
				String reqData = toJson(reqMap);
				String rspData = weixinClient.postGroupsUpdate(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}

	public ResponseDTO updateUserGroup(IAccessTokenCallback accessTokenCallback, final String user, final String toGroupId) throws Exception {
		return request(accessTokenCallback, new IRequestCallback<ResponseDTO>() {
			public ResponseDTO execute(String accessToken) {
				Map<String, Object> reqMap = new HashMap<String, Object>();
				reqMap.put("openid", user);
				reqMap.put("to_groupid", toGroupId);
				
				String reqData = toJson(reqMap);
				String rspData = weixinClient.postGroupsMembersUpdate(accessToken, reqData);
				return parseJson(rspData, ResponseDTO.class);
			}
		});
	}
}