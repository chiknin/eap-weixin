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
public class ClientException extends RuntimeException {
	
	private String httpStatusCode;
	
	public ClientException(String httpStatusCode, String message) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}
	
	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}
}