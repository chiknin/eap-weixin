package eap.weixin.dao.mp;

import eap.weixin.model.bo.MpMediaGroupBO;

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
public interface IMpMediaGroupDAO {
	int saveMpMediaGroupBO(MpMediaGroupBO mpMediaGroupBO);
	int deleteMpMediaGroupBOById(Long id);
	int updateMpMediaGroupBOById(MpMediaGroupBO mpMediaGroupBO);
	MpMediaGroupBO findMpMediaGroupBOById(Long id);
}