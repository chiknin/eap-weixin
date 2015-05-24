package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpReplyKeywordDAO;
import eap.weixin.model.bo.MpReplyKeywordBO;

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
@Repository("mpReplyKeywordDAO")
public class MpReplyKeywordDAOImpl extends BaseDAO implements IMpReplyKeywordDAO {
	
	public int saveMpReplyKeywordBO(MpReplyKeywordBO mpReplyKeywordBO) {
		return sqlExecutor.insert("mp.saveMpReplyKeywordBO", mpReplyKeywordBO);
	}
	
	public int deleteMpReplyKeywordBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpReplyKeywordBOById", id);
	}
	
	public int updateMpReplyKeywordBOById(MpReplyKeywordBO mpReplyKeywordBO) {
		return sqlExecutor.update("mp.updateMpReplyKeywordBOById", mpReplyKeywordBO);
	}
	
	public MpReplyKeywordBO findMpReplyKeywordBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpReplyKeywordBOById", id);
	}
}