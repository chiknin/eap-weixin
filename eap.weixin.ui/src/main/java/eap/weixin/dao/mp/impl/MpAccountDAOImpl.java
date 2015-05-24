package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpAccountDAO;
import eap.weixin.model.bo.MpAccountBO;

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
@Repository("mpAccountDAO")
public class MpAccountDAOImpl extends BaseDAO implements IMpAccountDAO {
	
	public int saveMpAccountBO(MpAccountBO mpAccountBO) {
		return sqlExecutor.insert("mp.saveMpAccountBO", mpAccountBO);
	}
	
	public int deleteMpAccountBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpAccountBOById", id);
	}
	
	public int updateMpAccountBOById(MpAccountBO mpAccountBO) {
		return sqlExecutor.update("mp.updateMpAccountBOById", mpAccountBO);
	}
	
	public MpAccountBO findMpAccountBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpAccountBOById", id);
	}
}