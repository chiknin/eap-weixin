package eap.weixin.sdk.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eap.util.JsonUtil;
import eap.weixin.sdk.WeixinBaseTest;
import eap.weixin.sdk.api.IMessageAPI;
import eap.weixin.sdk.dto.MassMessageBaseDTO;
import eap.weixin.sdk.dto.ResponseDTO;
import eap.weixin.sdk.dto.massmessage.MassImageMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassMpnewsMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassMpvideoMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassTextMessageDTO;
import eap.weixin.sdk.dto.massmessage.MassVoiceMessageDTO;
import eap.weixin.sdk.dto.message.ReplyImageMessageDTO;
import eap.weixin.sdk.dto.message.ReplyMusicMessageDTO;
import eap.weixin.sdk.dto.message.ReplyNewsMessageDTO;
import eap.weixin.sdk.dto.message.ReplyTextMessageDTO;
import eap.weixin.sdk.dto.message.ReplyVideoMessageDTO;
import eap.weixin.sdk.dto.message.ReplyVoiceMessageDTO;
import eap.weixin.sdk.dto.templatemessage.TemplateMessageDTO;

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
public class MessageAPIImplTest extends WeixinBaseTest {
	
	private IMessageAPI messageAPI;

	@BeforeClass
	public void beforeClass() {
		super.init();
		
		messageAPI = new MessageAPIImpl();
		((MessageAPIImpl) messageAPI).setWeixinClient(weixinClient);
	}
	
	@Test
	public void sendTextMessage() throws Exception {
		ReplyTextMessageDTO textMessageDTO = new ReplyTextMessageDTO();
		textMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		textMessageDTO.setTextDTO(new ReplyTextMessageDTO.TextDTO("hello world"));
		
		ResponseDTO rspDTO = messageAPI.sendTextMessage(accessTokenCallback, textMessageDTO);
		System.out.println("[Output] sendTextMessage -> " + JsonUtil.toJson(rspDTO));
		// [Output] sendTextMessage -> {"errcode":"0","errmsg":"ok"}
	}
	
	@Test
	public void sendImageMessage() throws Exception {
		ReplyImageMessageDTO imageMessageDTO = new ReplyImageMessageDTO();
		imageMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		imageMessageDTO.setImageDTO(new ReplyImageMessageDTO.ImageDTO("P8vzi8sKrAhKNHGHeAEWDEV9_RWpVuuVi9IJWIA6eePs-PEwYAuAQBpQ_xGPhRh1"));
		
		ResponseDTO rspDTO = messageAPI.sendImageMessage(accessTokenCallback, imageMessageDTO);
		System.out.println("[Output] sendImageMessage -> " + JsonUtil.toJson(rspDTO));
		// [Output] sendImageMessage -> {"errcode":"0","errmsg":"ok"}
	}
	
	@Test
	public void sendVoiceMessage() throws Exception {
		ReplyVoiceMessageDTO voiceMessageDTO = new ReplyVoiceMessageDTO();
		voiceMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		voiceMessageDTO.setVoiceDTO(new ReplyVoiceMessageDTO.VoiceDTO("1"));
		
		ResponseDTO rspDTO = messageAPI.sendVoiceMessage(accessTokenCallback, voiceMessageDTO);
		System.out.println("[Output] sendVoiceMessage -> " + JsonUtil.toJson(rspDTO));
		// [Output] sendVoiceMessage -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void sendVideoMessage() throws Exception {
		ReplyVideoMessageDTO videoMessageDTO = new ReplyVideoMessageDTO();
		videoMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		
		ReplyVideoMessageDTO.VideoDTO videoDTO = new ReplyVideoMessageDTO.VideoDTO();
		videoDTO.setMediaId("1");
		videoDTO.setThumbMediaId("2");
		videoDTO.setTitle("title");
		videoDTO.setDescription("description");
		videoMessageDTO.setVideoDTO(videoDTO);
		
		ResponseDTO rspDTO = messageAPI.sendVideoMessage(accessTokenCallback, videoMessageDTO);
		System.out.println("[Output] sendVideoMessage -> " + JsonUtil.toJson(rspDTO));
		// [Output] sendVideoMessage -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void sendMusicMessage() throws Exception {
		ReplyMusicMessageDTO musicMessageDTO = new ReplyMusicMessageDTO();
		musicMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		
		ReplyMusicMessageDTO.MusicDTO musicDTO = new ReplyMusicMessageDTO.MusicDTO();
		musicDTO.setTitle("title");
		musicDTO.setDescription("description");
		musicDTO.setMusicUrl("musicurl");
		musicDTO.setHqMusicUrl("hqmusicurl");
		musicDTO.setThumbMediaId("thumbMediaId");
		musicMessageDTO.setMusicDTO(musicDTO);
		
		ResponseDTO rspDTO = messageAPI.sendMusicMessage(accessTokenCallback, musicMessageDTO);
		System.out.println("[Output] sendMusicMessage -> " + JsonUtil.toJson(rspDTO));
		// [Output] sendMusicMessage -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void sendNewsMessage() throws Exception {
		ReplyNewsMessageDTO newsMessageDTO = new ReplyNewsMessageDTO();
		newsMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		
		ReplyNewsMessageDTO.NewsDTO newsDTO = new ReplyNewsMessageDTO.NewsDTO();
		ReplyNewsMessageDTO.ArticleDTO articleDTO = new ReplyNewsMessageDTO.ArticleDTO();
		articleDTO.setTitle("title");
		articleDTO.setDescription("description");
		articleDTO.setPicUrl("picUrl");
		articleDTO.setUrl("url");
		newsDTO.setArticleDTOList(Arrays.asList(articleDTO));
		newsMessageDTO.setNewsDTO(newsDTO);
		
		ResponseDTO rspDTO = messageAPI.sendNewsMessage(accessTokenCallback, newsMessageDTO);
		System.out.println("[Output] sendNewsMessage -> " + JsonUtil.toJson(rspDTO));
		// [Output] sendNewsMessage -> {"errcode":"0","errmsg":"ok"}
	}
	
	@Test
	public void sendMassTextMessage() throws Exception {
		MassTextMessageDTO massTextMessageDTO = new MassTextMessageDTO();
		massTextMessageDTO.setFilterDTO(new MassMessageBaseDTO.FilterDTO("100"));
		massTextMessageDTO.setTextDTO(new MassTextMessageDTO.TextDTO("hello world world"));
		
		ResponseDTO responseDTO = messageAPI.sendMassTextMessage(accessTokenCallback, massTextMessageDTO);
		System.out.println("[Output] sendMassTextMessage -> " + JsonUtil.toJson(responseDTO));
		// {"errcode":"0","errmsg":"send job submission success"}
	}
	
	@Test
	public void sendMassImageMessage() throws Exception {
		MassImageMessageDTO massImageMessageDTO = new MassImageMessageDTO();
		massImageMessageDTO.setFilterDTO(new MassMessageBaseDTO.FilterDTO("100"));
		massImageMessageDTO.setImageDTO(new MassImageMessageDTO.ImageDTO("P8vzi8sKrAhKNHGHeAEWDEV9_RWpVuuVi9IJWIA6eePs-PEwYAuAQBpQ_xGPhRh1"));
		
		ResponseDTO responseDTO = messageAPI.sendMassImageMessage(accessTokenCallback, massImageMessageDTO);
		System.out.println("[Output] sendMassImageMessage -> " + JsonUtil.toJson(responseDTO));
		// [Output] sendMassImageMessage -> {"errcode":"0","errmsg":"send job submission success"}
	}
	
	@Test
	public void sendMassVoiceMessage() throws Exception {
		MassVoiceMessageDTO massVoiceMessageDTO = new MassVoiceMessageDTO();
		massVoiceMessageDTO.setFilterDTO(new MassMessageBaseDTO.FilterDTO("100"));
		massVoiceMessageDTO.setVoiceDTO(new MassVoiceMessageDTO.VoiceDTO("1"));
		
		ResponseDTO responseDTO = messageAPI.sendMassVoiceMessage(accessTokenCallback, massVoiceMessageDTO);
		System.out.println("[Output] sendMassVoiceMessage -> " + JsonUtil.toJson(responseDTO));
		// [Output] sendMassVoiceMessage -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void sendMassMpnewMessage() throws Exception {
		MassMpnewsMessageDTO massMpnewsMessageDTO = new MassMpnewsMessageDTO();
//		massMpnewsMessageDTO.setFilterDTO(new MassMessageBaseDTO.FilterDTO("100"));
		massMpnewsMessageDTO.setToUserList(Arrays.asList("oO7yRjtD8g2Q5_HXAjmfpY5V23nk"));
		massMpnewsMessageDTO.setMpnewsDTO(new MassMpnewsMessageDTO.MpnewsDTO("1"));
		
		ResponseDTO responseDTO = messageAPI.sendMassMpnewMessage(accessTokenCallback, massMpnewsMessageDTO);
		System.out.println("[Output] sendMassMpnewMessage -> " + JsonUtil.toJson(responseDTO));
		// [Output] sendMassMpnewMessage -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void sendMassMpvideoMessage() throws Exception {
		MassMpvideoMessageDTO massMpvideoMessageDTO = new MassMpvideoMessageDTO();
		massMpvideoMessageDTO.setToUserList(Arrays.asList("oO7yRjtD8g2Q5_HXAjmfpY5V23nk"));
		massMpvideoMessageDTO.setVideoDTO(new MassMpvideoMessageDTO.VideoDTO("1"));
		
		ResponseDTO responseDTO = messageAPI.sendMassMpvideoMessage(accessTokenCallback, massMpvideoMessageDTO);
		System.out.println("[Output] sendMassMpvideoMessage -> " + JsonUtil.toJson(responseDTO));
		// [Output] sendMassMpvideoMessage -> {"errcode":"40007","errmsg":"invalid media_id"}
	}
	
	@Test
	public void sendTemplateMessage() throws Exception {
		TemplateMessageDTO templateMessageDTO = new TemplateMessageDTO();
		templateMessageDTO.setToUser("oO7yRjtD8g2Q5_HXAjmfpY5V23nk");
		templateMessageDTO.setTemplateId("ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY");
		templateMessageDTO.setUrl("http://weixin.qq.com/download");
		templateMessageDTO.setTopColor("#FF0000");
		
		List<TemplateMessageDTO.DataItemDTO> dataList = new ArrayList<TemplateMessageDTO.DataItemDTO>();
		dataList.add(new TemplateMessageDTO.DataItemDTO("first", "您好，您已成功消费。", "#0A0A0A"));
		dataList.add(new TemplateMessageDTO.DataItemDTO("keynote1", "巧克力", "#CCCCCC"));
		dataList.add(new TemplateMessageDTO.DataItemDTO("keynote2", "39.8元", "#CCCCCC"));
		dataList.add(new TemplateMessageDTO.DataItemDTO("keynote3", "2014年9月16日", "#CCCCCC"));
		dataList.add(new TemplateMessageDTO.DataItemDTO("remark", "欢迎再次购买。", "#173177"));
		
		templateMessageDTO.setDataList(dataList);
		
		ResponseDTO responseDTO = messageAPI.sendTemplateMessage(accessTokenCallback, templateMessageDTO);
		System.out.println("[Output] sendTemplateMessage -> " + JsonUtil.toJson(responseDTO));
		// [Output] sendTemplateMessage -> {"errcode":"-1","errmsg":"system error"}
	}
}
