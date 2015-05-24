package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMsgRouteDAO;
import eap.weixin.model.bo.MpMsgRouteBO;

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
@Repository("mpMsgRouteDAO")
public class MpMsgRouteDAOImpl extends BaseDAO implements IMpMsgRouteDAO {
	
	public int saveMpMsgRouteBO(MpMsgRouteBO mpMsgRouteBO) {
		return sqlExecutor.insert("mp.saveMpMsgRouteBO", mpMsgRouteBO);
	}
	
	public int deleteMpMsgRouteBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMsgRouteBOById", id);
	}
	
	public int updateMpMsgRouteBOById(MpMsgRouteBO mpMsgRouteBO) {
		return sqlExecutor.update("mp.updateMpMsgRouteBOById", mpMsgRouteBO);
	}
	
	public MpMsgRouteBO findMpMsgRouteBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMsgRouteBOById", id);
	}
}