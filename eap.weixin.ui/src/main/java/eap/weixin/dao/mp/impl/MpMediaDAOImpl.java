package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMediaDAO;
import eap.weixin.model.bo.MpMediaBO;

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
@Repository("mpMediaDAO")
public class MpMediaDAOImpl extends BaseDAO implements IMpMediaDAO {
	
	public int saveMpMediaBO(MpMediaBO mpMediaBO) {
		return sqlExecutor.insert("mp.saveMpMediaBO", mpMediaBO);
	}
	
	public int deleteMpMediaBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMediaBOById", id);
	}
	
	public int updateMpMediaBOById(MpMediaBO mpMediaBO) {
		return sqlExecutor.update("mp.updateMpMediaBOById", mpMediaBO);
	}
	
	public MpMediaBO findMpMediaBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMediaBOById", id);
	}
}