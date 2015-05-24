package eap.weixin.sdk;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eap.util.EDcodeUtil;
import eap.weixin.sdk.client.IWeixinClient;
import eap.weixin.sdk.client.impl.DefaultWeixinClientImpl;

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
public class WeixinTestUtil {
	
	public static final Logger LOG = LoggerFactory.getLogger(WeixinTestUtil.class);
	
	public static IWeixinClient buildWeixinClient() {
		HttpClient httpClient = new HttpClient(); // TODO MultiThreadedHttpConnectionManager
		HttpConnectionManagerParams params = httpClient.getHttpConnectionManager().getParams();
		params.setConnectionTimeout(10000);
		params.setSoTimeout(30000);
		DefaultWeixinClientImpl weixinClient = new DefaultWeixinClientImpl();
		weixinClient.setHttpClient(httpClient);
		
		return weixinClient;
	}
	
	public static void main(String[] args) throws HttpException, IOException, InterruptedException {
		HttpClient httpClient = new HttpClient(); // TODO MultiThreadedHttpConnectionManager
		HttpConnectionManagerParams params = httpClient.getHttpConnectionManager().getParams();
		params.setConnectionTimeout(10000);
		params.setSoTimeout(30000);
		
		for (int i = 0; i < 200; i++) {
//			PostMethod post = new PostMethod("http://115.29.205.146/iphone6/help.php");
//			post.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//			post.addRequestHeader("X-Requested-With", "XMLHttpRequest");
//			post.addRequestHeader("Referer", "http://115.29.205.146/iphone6/index.php?target=97bb8d6acf605f39fddd2821a6836d90");
//			post.addRequestHeader("Accept-Language", "zh-Hans-CN");
//			post.addRequestHeader("UA-CPU", "ARM");
//			post.addRequestHeader("Accept-Encoding", "gzip, deflate");
//			post.addRequestHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Nokia 920)");
//			post.addRequestHeader("Host", "115.29.205.146");
//			post.addRequestHeader("Pragma", "no-cache");
//			post.addRequestHeader("Cookie", "iph_userid=" + EDcodeUtil.uuid().replaceAll("-", "") + "; CNZZDATA1253769962=875118738-1418463461-%7C1418463461");
//			post.addRequestHeader("Content-Length", "41");
//			post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//			
//			post.addParameter("targetid", "97bb8d6acf605f39fddd2821a6836d90");
			
			PostMethod post = new PostMethod("http://115.29.205.146/iphone6/help.php");
			post.addRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			post.addRequestHeader("X-Requested-With", "XMLHttpRequest");
			post.addRequestHeader("Referer", "http://115.29.205.146/iphone6/index.php?target=0bde5ffe2f498bcff21d7ae0b8d58a21");
			post.addRequestHeader("Accept-Language", "zh-Hans-CN");
			post.addRequestHeader("UA-CPU", "ARM");
			post.addRequestHeader("Accept-Encoding", "gzip, deflate");
			post.addRequestHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Nokia 920)");
			post.addRequestHeader("Host", "115.29.205.146");
			post.addRequestHeader("Pragma", "no-cache");
			post.addRequestHeader("Cookie", "iph_userid=" + EDcodeUtil.uuid().replaceAll("-", ""));
			post.addRequestHeader("Content-Length", "41");
			post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			post.addParameter("targetid", "0bde5ffe2f498bcff21d7ae0b8d58a21");
			
			int status = httpClient.executeMethod(post);
			LOG.info("status > " + status);
			LOG.info("response > " + post.getResponseBodyAsString());
			System.err.println("status > " + status);
			System.err.println("response > " + post.getResponseBodyAsString());
			Thread.sleep(30);
			post.releaseConnection();
		}
	}
}
