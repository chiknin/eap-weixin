package eap.weixin.sdk;

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
public interface WeixinConst {
	
	interface MsgType {
		String TEXT = "text";
		String IMAGE = "image";
		String VOICE = "voice";
		String VIDEO = "video";
		String LOCATION = "location";
		String LINK = "link";
		String EVENT = "event";
		
		String MUSIC = "music";
		String NEWS = "news";
		String TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
		
		String MPNEWS = "mpnews";
		String MPVIDEO = "mpvideo";
	}
	
	interface Event {
		String CLICK = "click";
		String LOCATION = "location";
		String VIEW = "view";
		String SUBSCRIBE = "subscribe";
		String UNSUBSCRIBE = "unsubscribe";
		String SCAN = "scan";
		String TEMPLATE_SEND_JOB_FINISH = "TEMPLATESENDJOBFINISH";
		String MASS_SEND_JOB_FINISH = "MASSSENDJOBFINISH";
		
		String SCANCODE_PUSH = "scancode_push";
		String SCANCODE_WAITMSG = "scancode_waitmsg";
		String PIC_SYSPHOTO = "pic_sysphoto";
		String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
		String PIC_WEIXIN = "pic_weixin";
		String LOCATION_SELECT = "location_select";
	}
	
	interface LANG {
		String ZH_CN = "zh_CN";
		String ZH_TW = "zh_TW";
		String EN = "en";
	}
}
