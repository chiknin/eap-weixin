package eap.weixin.sdk.api;

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
public interface IUserAPI {
	
	public UserInfoResponseDTO getUserInfo(IAccessTokenCallback accessTokenCallback, String user, String lang) throws Exception;
	public ResponseDTO updateUserRemark(IAccessTokenCallback accessTokenCallback, String user, String remark) throws Exception;
	public FansListResponseDTO getFansList(IAccessTokenCallback accessTokenCallback, String nextFansId) throws Exception;
	
	public GroupResponseDTO createGroup(IAccessTokenCallback accessTokenCallback, String name) throws Exception;
	public GroupsResponseDTO getGroups(IAccessTokenCallback accessTokenCallback) throws Exception;
	public UserGroupResponseDTO getUserGroup(IAccessTokenCallback accessTokenCallback, String user) throws Exception;
	public ResponseDTO updateGroupName(IAccessTokenCallback accessTokenCallback, String groupId, String newGroupName) throws Exception;
	public ResponseDTO updateUserGroup(IAccessTokenCallback accessTokenCallback, String user, String toGroupId) throws Exception;
	
}