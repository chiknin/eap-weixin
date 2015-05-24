package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpUserGroupDAO;
import eap.weixin.model.bo.MpUserGroupBO;

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
@Repository("mpUserGroupDAO")
public class MpUserGroupDAOImpl extends BaseDAO implements IMpUserGroupDAO {
	
	public int saveMpUserGroupBO(MpUserGroupBO mpUserGroupBO) {
		return sqlExecutor.insert("mp.saveMpUserGroupBO", mpUserGroupBO);
	}
	
	public int deleteMpUserGroupBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpUserGroupBOById", id);
	}
	
	public int updateMpUserGroupBOById(MpUserGroupBO mpUserGroupBO) {
		return sqlExecutor.update("mp.updateMpUserGroupBOById", mpUserGroupBO);
	}
	
	public MpUserGroupBO findMpUserGroupBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpUserGroupBOById", id);
	}
}