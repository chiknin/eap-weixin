package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMediaGroupDAO;
import eap.weixin.model.bo.MpMediaGroupBO;

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
@Repository("mpMediaGroupDAO")
public class MpMediaGroupDAOImpl extends BaseDAO implements IMpMediaGroupDAO {
	
	public int saveMpMediaGroupBO(MpMediaGroupBO mpMediaGroupBO) {
		return sqlExecutor.insert("mp.saveMpMediaGroupBO", mpMediaGroupBO);
	}
	
	public int deleteMpMediaGroupBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMediaGroupBOById", id);
	}
	
	public int updateMpMediaGroupBOById(MpMediaGroupBO mpMediaGroupBO) {
		return sqlExecutor.update("mp.updateMpMediaGroupBOById", mpMediaGroupBO);
	}
	
	public MpMediaGroupBO findMpMediaGroupBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMediaGroupBOById", id);
	}
}