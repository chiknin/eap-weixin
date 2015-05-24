package eap.weixin.sdk.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.util.UrlUtil;
import eap.weixin.sdk.WeixinBaseTest;
import eap.weixin.sdk.api.IMenuAPI;
import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.menu.ButtonDTO;
import eap.weixin.sdk.dto.menu.MenuDTO;
import eap.weixin.sdk.dto.menu.MenuResponseDTO;

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
public class MenuAPIImplTest extends WeixinBaseTest {
	
	private IMenuAPI menuAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		menuAPI = new MenuAPIImpl();
		((MenuAPIImpl) menuAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void createMenu() throws Exception {
		List<ButtonDTO> buttonList = new ArrayList<ButtonDTO>();
		
		ButtonDTO buttonDTO_1 = new ButtonDTO();
		buttonDTO_1.setName("闪电贷款");
		List<ButtonDTO> subButtonList_1 = new ArrayList<ButtonDTO>();
		ButtonDTO buttonDTO_1_1 = new ButtonDTO();
		buttonDTO_1_1.setType("view");
		buttonDTO_1_1.setName("首页");
		buttonDTO_1_1.setUrl("http://10.110.2.133:8080/login.htm?redirectUri=/"); // 10.110.2.133:8080    http://10.110.2.173:8080/
		subButtonList_1.add(buttonDTO_1_1);
		ButtonDTO buttonDTO_1_2 = new ButtonDTO();
		buttonDTO_1_2.setType("view");
		buttonDTO_1_2.setName("劲爆活动");
		buttonDTO_1_2.setUrl("http://10.110.2.133:8080/login.htm?redirectUri=/ln/loanIn/calc.htm");
		subButtonList_1.add(buttonDTO_1_2);
		buttonDTO_1.setSubButtonDTOList(subButtonList_1);
		buttonList.add(buttonDTO_1);
		
		ButtonDTO buttonDTO_2 = new ButtonDTO();
		buttonDTO_2.setName("个人中心");
		List<ButtonDTO> subButtonList_2 = new ArrayList<ButtonDTO>();
		ButtonDTO buttonDTO_2_1 = new ButtonDTO();
		buttonDTO_2_1.setType("view");
		buttonDTO_2_1.setName("我的账户");
		buttonDTO_2_1.setUrl("http://10.110.2.133:8080/login.htm?redirectUri=/my/index.htm");
		subButtonList_2.add(buttonDTO_2_1);
		ButtonDTO buttonDTO_2_2 = new ButtonDTO();
		buttonDTO_2_2.setType("view");
		buttonDTO_2_2.setName("邀请好友");
		buttonDTO_2_2.setUrl("http://10.110.2.133:8080/login.htm?redirectUri=/invite/invite.htm");
		subButtonList_2.add(buttonDTO_2_2);
		ButtonDTO buttonDTO_2_3 = new ButtonDTO();
		buttonDTO_2_3.setType("view");
		buttonDTO_2_3.setName("我的消息");
		buttonDTO_2_3.setUrl("http://10.110.2.133:8080/login.htm?redirectUri=/");
		subButtonList_2.add(buttonDTO_2_3);
		buttonDTO_2.setSubButtonDTOList(subButtonList_2);
		buttonList.add(buttonDTO_2);
		
		ButtonDTO buttonDTO_3 = new ButtonDTO();
		buttonDTO_3.setName("好助手");
		List<ButtonDTO> subButtonList_3 = new ArrayList<ButtonDTO>();
		ButtonDTO buttonDTO_3_1 = new ButtonDTO();
		buttonDTO_3_1.setType("view");
		buttonDTO_3_1.setName("帮助中心");
		buttonDTO_3_1.setUrl("http://10.110.2.133:8080/login.htm?redirectUri=/");
		subButtonList_3.add(buttonDTO_3_1);
		buttonDTO_3.setSubButtonDTOList(subButtonList_3);
		buttonList.add(buttonDTO_3);
		
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setButtonDTOList(buttonList);
		
		ResponseDTO rspDTO = menuAPI.createMenu(accessTokenCallback, menuDTO);
		System.out.println("[Output] createMenu -> " + JsonUtil.toJson(rspDTO));
		// [Output] createMenu -> {"errcode":"0","errmsg":"ok"}
	}
	
	@Test
	public void getMenu() throws Exception {
		MenuResponseDTO rspDTO = menuAPI.getMenu(accessTokenCallback);
		System.out.println("[Output] getMenu -> " + JsonUtil.toJson(rspDTO));
		// [Output] getMenu -> {"menu":{"button":[{"name":"今日歌曲","type":"click","key":"V1001_TODAY_MUSIC","sub_button":[]},{"name":"菜单","sub_button":[{"name":"搜索","type":"view","url":"http://www.soso.com/","sub_button":[]},{"name":"赞一下我们","type":"click","key":"V1001_GOOD","sub_button":[]}]}]}}
	}
	
	@Test
	public void deleteMenu() throws Exception {
		ResponseDTO rspDTO = menuAPI.deleteMenu(accessTokenCallback);
		System.out.println("[Output] deleteMenu -> " + JsonUtil.toJson(rspDTO));
		// [Output] deleteMenu -> {"errcode":"0","errmsg":"ok"}
	}
}