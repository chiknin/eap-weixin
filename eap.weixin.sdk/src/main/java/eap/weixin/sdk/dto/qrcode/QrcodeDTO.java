package eap.weixin.sdk.dto.qrcode;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

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
public class QrcodeDTO implements Serializable {
	
	@JsonProperty("expire_seconds")
	private Integer expireSeconds;
	
	@JsonProperty("action_name")
	private String actionName;
	
	@JsonProperty("action_info")
	private ActionInfoDTO actionInfoDTO;
	
	public Integer getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public ActionInfoDTO getActionInfoDTO() {
		return actionInfoDTO;
	}
	public void setActionInfoDTO(ActionInfoDTO actionInfoDTO) {
		this.actionInfoDTO = actionInfoDTO;
	}

	public static class ActionInfoDTO implements Serializable {
		
		@JsonProperty("scene")
		private SceneDTO sceneDTO;
		
		public ActionInfoDTO() {
		}
		public ActionInfoDTO(SceneDTO sceneDTO) {
			this.sceneDTO = sceneDTO;
		}

		public SceneDTO getSceneDTO() {
			return sceneDTO;
		}
		public void setSceneDTO(SceneDTO sceneDTO) {
			this.sceneDTO = sceneDTO;
		}
	}
	
	public static class SceneDTO implements Serializable {
		
		@JsonProperty("scene_id")
		private String sceneId;
		
		public SceneDTO() {
		}
		public SceneDTO(String sceneId) {
			this.sceneId = sceneId;
		}

		public String getSceneId() {
			return sceneId;
		}
		public void setSceneId(String sceneId) {
			this.sceneId = sceneId;
		}
	}
}