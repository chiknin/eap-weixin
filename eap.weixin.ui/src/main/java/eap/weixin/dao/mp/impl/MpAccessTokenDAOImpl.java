package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpAccessTokenDAO;
import eap.weixin.model.bo.MpAccessTokenBO;

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
@Repository("mpAccessTokenDAO")
public class MpAccessTokenDAOImpl extends BaseDAO implements IMpAccessTokenDAO {
	
	public int saveMpAccessTokenBO(MpAccessTokenBO mpAccessTokenBO) {
		return sqlExecutor.insert("mp.saveMpAccessTokenBO", mpAccessTokenBO);
	}
	
	public int deleteMpAccessTokenBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpAccessTokenBOById", id);
	}
	
	public int updateMpAccessTokenBOById(MpAccessTokenBO mpAccessTokenBO) {
		return sqlExecutor.update("mp.updateMpAccessTokenBOById", mpAccessTokenBO);
	}
	
	public MpAccessTokenBO findMpAccessTokenBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpAccessTokenBOById", id);
	}
}