package eap.weixin.model.bo;

import java.util.Date;

import eap.base.BaseBO;


/**
 * <p> 标题: </p>
 * <p> 描述: </p>
 * @作者 fuumining
 * @创建时间 2015-05-24 12:07:56
 * @版本 1.00
 * @修改记录
 * <pre>
 * 版本       修改人         修改时间         修改内容描述
 * ----------------------------------------
 * 
 * ----------------------------------------
 * </pre>
 */
public class MpMsgBO extends BaseBO {
	
	/** 消息方向：1-接收，2-回复 */
	private String msgDirection;
	/** 粉丝openid */
	private String fansOpenId;
	/** 公众号openid */
	private String mpOpenId;
	/** 创建时间（微信平台） */
	private Date mpCreatedTime;
	/** 消息类型 */
	private String msgType;
	/** 信息ID（微信平台） */
	private String mpMsgId;
	/** 事件 */
	private String event;
	/** 事件key */
	private String eventKey;
	/** 文本消息内容 */
	private String content;
	/** 图片链接
图片链接 */
	private String picUrl;
	/** 图片消息媒体id */
	private String mpMediaId;
	/** 多媒体格式 */
	private String format;
	/** 缩略图的媒体id（微信平台） */
	private String mpThumbMediaId;
	/** 消息标题 */
	private String title;
	/** 消息描述 */
	private String description;
	/** 消息链接 */
	private String url;
	/** 二维码的ticket */
	private String ticket;
	/** 地理位置纬度 */
	private Integer posLatitude;
	/** 地理位置经度 */
	private Integer posLongitude;
	/** 地理位置精度 */
	private Integer posPrecision;
	/** 地图缩放大小 */
	private Integer posScale;
	/** 地理位置信息 */
	private String label;
	/** 语音识别结 */
	private String recognition;
	/** 消息回复类型 */
	private String replyType;
	/** 回复素材ID */
	private Long replyMediaId;
	/**  */
	private Long originMsgId;
	
	public String getMsgDirection() {
		return this.msgDirection;
	}
	public void setMsgDirection(String msgDirection) {
		this.msgDirection = msgDirection;
	}
	public String getFansOpenId() {
		return this.fansOpenId;
	}
	public void setFansOpenId(String fansOpenId) {
		this.fansOpenId = fansOpenId;
	}
	public String getMpOpenId() {
		return this.mpOpenId;
	}
	public void setMpOpenId(String mpOpenId) {
		this.mpOpenId = mpOpenId;
	}
	public Date getMpCreatedTime() {
		return this.mpCreatedTime;
	}
	public void setMpCreatedTime(Date mpCreatedTime) {
		this.mpCreatedTime = mpCreatedTime;
	}
	public String getMsgType() {
		return this.msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMpMsgId() {
		return this.mpMsgId;
	}
	public void setMpMsgId(String mpMsgId) {
		this.mpMsgId = mpMsgId;
	}
	public String getEvent() {
		return this.event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventKey() {
		return this.eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicUrl() {
		return this.picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getMpMediaId() {
		return this.mpMediaId;
	}
	public void setMpMediaId(String mpMediaId) {
		this.mpMediaId = mpMediaId;
	}
	public String getFormat() {
		return this.format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getMpThumbMediaId() {
		return this.mpThumbMediaId;
	}
	public void setMpThumbMediaId(String mpThumbMediaId) {
		this.mpThumbMediaId = mpThumbMediaId;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTicket() {
		return this.ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getPosLatitude() {
		return this.posLatitude;
	}
	public void setPosLatitude(Integer posLatitude) {
		this.posLatitude = posLatitude;
	}
	public Integer getPosLongitude() {
		return this.posLongitude;
	}
	public void setPosLongitude(Integer posLongitude) {
		this.posLongitude = posLongitude;
	}
	public Integer getPosPrecision() {
		return this.posPrecision;
	}
	public void setPosPrecision(Integer posPrecision) {
		this.posPrecision = posPrecision;
	}
	public Integer getPosScale() {
		return this.posScale;
	}
	public void setPosScale(Integer posScale) {
		this.posScale = posScale;
	}
	public String getLabel() {
		return this.label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRecognition() {
		return this.recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	public String getReplyType() {
		return this.replyType;
	}
	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}
	public Long getReplyMediaId() {
		return this.replyMediaId;
	}
	public void setReplyMediaId(Long replyMediaId) {
		this.replyMediaId = replyMediaId;
	}
	public Long getOriginMsgId() {
		return this.originMsgId;
	}
	public void setOriginMsgId(Long originMsgId) {
		this.originMsgId = originMsgId;
	}
}