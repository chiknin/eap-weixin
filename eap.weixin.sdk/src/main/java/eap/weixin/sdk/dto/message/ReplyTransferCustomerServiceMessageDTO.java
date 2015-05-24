package eap.weixin.sdk.dto.message;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eap.weixin.sdk.WeixinConst;
import eap.weixin.sdk.dto.MessageBaseDTO;

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
@XmlRootElement(name="xml")
public class ReplyTransferCustomerServiceMessageDTO extends MessageBaseDTO {
	
	@XmlElement(name="TransInfo")
	private List<TransInfoDTO> transInfoDTOList;
	
	public ReplyTransferCustomerServiceMessageDTO() {
		setMsgType(WeixinConst.MsgType.TRANSFER_CUSTOMER_SERVICE);
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class TransInfoDTO implements Serializable {
		
		@XmlElement(name="KfAccount")
		private String kfAccount;
		
		public TransInfoDTO() {
		}
		public TransInfoDTO(String kfAccount) {
			this.kfAccount = kfAccount;
		}

		public String getKfAccount() {
			return kfAccount;
		}

		public void setKfAccount(String kfAccount) {
			this.kfAccount = kfAccount;
		}
	}
}