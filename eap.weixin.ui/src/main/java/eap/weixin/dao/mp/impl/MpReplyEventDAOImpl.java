package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpReplyEventDAO;
import eap.weixin.model.bo.MpReplyEventBO;

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
@Repository("mpReplyEventDAO")
public class MpReplyEventDAOImpl extends BaseDAO implements IMpReplyEventDAO {
	
	public int saveMpReplyEventBO(MpReplyEventBO mpReplyEventBO) {
		return sqlExecutor.insert("mp.saveMpReplyEventBO", mpReplyEventBO);
	}
	
	public int deleteMpReplyEventBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpReplyEventBOById", id);
	}
	
	public int updateMpReplyEventBOById(MpReplyEventBO mpReplyEventBO) {
		return sqlExecutor.update("mp.updateMpReplyEventBOById", mpReplyEventBO);
	}
	
	public MpReplyEventBO findMpReplyEventBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpReplyEventBOById", id);
	}
}