package eap.weixin.sdk.client;

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
public enum MediaType {
	
	IMAGE_JPG("image", "jpg", "image/jpeg"),
	VOICE_AMR("voice", "amr", "audio/amr"),
	VOICE_MP3("voice", "mp3", "audio/mpeg"),
	VIDEO_MP4("video", "mp4", "video/mp4"),
	THUMB_JPG("thumb", "jpg", "image/jpeg");
	
	private String mediaType;
	private String fileFormat;
	private String mineType;
	
	private MediaType(String mediaType, String fileFormat, String mineType) {
		this.mediaType = mediaType;
		this.fileFormat = fileFormat;
		this.mineType = mineType;
	}

	public String getMediaType() {
		return mediaType;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public String getMineType() {
		return mineType;
	}
}