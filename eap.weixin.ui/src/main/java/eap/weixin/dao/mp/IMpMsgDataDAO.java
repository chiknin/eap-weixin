package eap.weixin.dao.mp;

import eap.weixin.model.bo.MpMsgDataBO;

/**
 * <p> 标题: </p>
 * <p> 描述: </p>
 * @作者 fuumining
 * @创建时间 2015-05-24 12:14:14
 * @版本 1.00
 * @修改记录
 * <pre>
 * 版本       修改人         修改时间         修改内容描述
 * ----------------------------------------
 * 
 * ----------------------------------------
 * </pre>
 */
public interface IMpMsgDataDAO {
	int saveMpMsgDataBO(MpMsgDataBO mpMsgDataBO);
	int deleteMpMsgDataBOById(Long id);
	int updateMpMsgDataBOById(MpMsgDataBO mpMsgDataBO);
	MpMsgDataBO findMpMsgDataBOById(Long id);
}