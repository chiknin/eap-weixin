package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMenuDAO;
import eap.weixin.model.bo.MpMenuBO;

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
@Repository("mpMenuDAO")
public class MpMenuDAOImpl extends BaseDAO implements IMpMenuDAO {
	
	public int saveMpMenuBO(MpMenuBO mpMenuBO) {
		return sqlExecutor.insert("mp.saveMpMenuBO", mpMenuBO);
	}
	
	public int deleteMpMenuBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMenuBOById", id);
	}
	
	public int updateMpMenuBOById(MpMenuBO mpMenuBO) {
		return sqlExecutor.update("mp.updateMpMenuBOById", mpMenuBO);
	}
	
	public MpMenuBO findMpMenuBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMenuBOById", id);
	}
}