package eap.weixin.dao.mp;

import eap.weixin.model.bo.MpReplyEventBO;

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
public interface IMpReplyEventDAO {
	int saveMpReplyEventBO(MpReplyEventBO mpReplyEventBO);
	int deleteMpReplyEventBOById(Long id);
	int updateMpReplyEventBOById(MpReplyEventBO mpReplyEventBO);
	MpReplyEventBO findMpReplyEventBOById(Long id);
}