package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMsgDAO;
import eap.weixin.model.bo.MpMsgBO;

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
@Repository("mpMsgDAO")
public class MpMsgDAOImpl extends BaseDAO implements IMpMsgDAO {
	
	public int saveMpMsgBO(MpMsgBO mpMsgBO) {
		return sqlExecutor.insert("mp.saveMpMsgBO", mpMsgBO);
	}
	
	public int deleteMpMsgBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMsgBOById", id);
	}
	
	public int updateMpMsgBOById(MpMsgBO mpMsgBO) {
		return sqlExecutor.update("mp.updateMpMsgBOById", mpMsgBO);
	}
	
	public MpMsgBO findMpMsgBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMsgBOById", id);
	}
}