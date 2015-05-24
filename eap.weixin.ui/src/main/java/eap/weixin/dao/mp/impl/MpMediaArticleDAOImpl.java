package eap.weixin.dao.mp.impl;

import org.springframework.stereotype.Repository;

import eap.weixin.dao.mp.IMpMediaArticleDAO;
import eap.weixin.model.bo.MpMediaArticleBO;

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
@Repository("mpMediaArticleDAO")
public class MpMediaArticleDAOImpl extends BaseDAO implements IMpMediaArticleDAO {
	
	public int saveMpMediaArticleBO(MpMediaArticleBO mpMediaArticleBO) {
		return sqlExecutor.insert("mp.saveMpMediaArticleBO", mpMediaArticleBO);
	}
	
	public int deleteMpMediaArticleBOById(Long id) {
		return sqlExecutor.delete("mp.deleteMpMediaArticleBOById", id);
	}
	
	public int updateMpMediaArticleBOById(MpMediaArticleBO mpMediaArticleBO) {
		return sqlExecutor.update("mp.updateMpMediaArticleBOById", mpMediaArticleBO);
	}
	
	public MpMediaArticleBO findMpMediaArticleBOById(Long id) {
		return sqlExecutor.selectOne("mp.findMpMediaArticleBOById", id);
	}
}