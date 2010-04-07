package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.common.DictConstants;
import com.tangmaowen.mis.sys.dao.DictionaryDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.DictionaryPO;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-30 上午09:53:49
 *
 */
public class DictionaryDaoImpl extends HibernateDaoSupport implements DictionaryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DictionaryBO> getDictionaryList() {
		List<DictionaryPO> dics = getHibernateTemplate().find("from DictionaryPO");
		return getDicBOList(dics);
	}

	@Override
	public List<DictionaryBO> getDicRootCodeList() {
		return getEntryList(DictConstants.DICROOTITEM);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DictionaryBO> getEntryList(String parentcode) {
		if(Tools.isNull(parentcode)) return null;
		List<DictionaryPO> dics = getHibernateTemplate().find("from DictionaryPO a where a.parentcode=? order by a.levelseq asc", parentcode);
		return getDicBOList(dics);
	}

	@Override
	public DictionaryBO getEntry(Integer id) {
		DictionaryPO po = (DictionaryPO)getHibernateTemplate().get(DictionaryPO.class, id);
		DictionaryBO bo = new DictionaryBO();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	@Override
	public DictionaryBO insertEntry(DictionaryBO bo) {
		DictionaryPO po = new DictionaryPO();
		BeanUtils.copyProperties(bo, po);
		Integer id = (Integer)getHibernateTemplate().save(po);
		return getEntry(id);
	}

	@Override
	public DictionaryBO updateEntry(DictionaryBO bo) {
		DictionaryPO po = (DictionaryPO)getHibernateTemplate().get(DictionaryPO.class, bo.getDictid());
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().update(po);
		return getEntry(po.getDictid());
	}

	@Override
	public DictionaryBO deleteEntry(Integer id) {
		DictionaryPO po = (DictionaryPO)getHibernateTemplate().get(DictionaryPO.class, id);
		DictionaryBO bo = new DictionaryBO();
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().delete(po);
		return bo;
	}
	
	private List<DictionaryBO> getDicBOList(List<DictionaryPO> dics) {
		if(Tools.isEmpty(dics)) return null;
		List<DictionaryBO> bolist = new ArrayList<DictionaryBO>();
		for (int i = 0; i < dics.size(); i++) {
			DictionaryBO bo = new DictionaryBO();
			BeanUtils.copyProperties(dics.get(i), bo);
			bolist.add(bo);
		}
		return bolist;
	}

}
