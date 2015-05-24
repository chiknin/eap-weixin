package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMsgDataDAO;
import eap.weixin.model.bo.MpMsgDataBO;

import eap.comps.orm.mybatis.BaseDAO;

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
@Repository("mpMsgDataDAO")
public class MpMsgDataDAOImpl extends BaseDAO implements IMpMsgDataDAO {
	
	public int saveMpMsgDataBO(MpMsgDataBO mpMsgDataBO) {
		return sqlExecutor.insert("mp.saveMpMsgDataBO", mpMsgDataBO);
	}
	
	public int deleteMpMsgDataBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMsgDataBOById", id);
	}
	
	public int updateMpMsgDataBOById(MpMsgDataBO mpMsgDataBO) {
		return sqlExecutor.update("mp.updateMpMsgDataBOById", mpMsgDataBO);
	}
	
	public MpMsgDataBO findMpMsgDataBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMsgDataBOById", id);
	}
}