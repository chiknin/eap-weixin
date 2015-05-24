package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpUserDAO;
import eap.weixin.model.bo.MpUserBO;

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
@Repository("mpUserDAO")
public class MpUserDAOImpl extends BaseDAO implements IMpUserDAO {
	
	public int saveMpUserBO(MpUserBO mpUserBO) {
		return sqlExecutor.insert("mp.saveMpUserBO", mpUserBO);
	}
	
	public int deleteMpUserBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpUserBOById", id);
	}
	
	public int updateMpUserBOById(MpUserBO mpUserBO) {
		return sqlExecutor.update("mp.updateMpUserBOById", mpUserBO);
	}
	
	public MpUserBO findMpUserBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpUserBOById", id);
	}
}