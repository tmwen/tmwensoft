package com.tangmaowen.mis.common.dao.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.tangmaowen.mis.common.MisException;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.utils.Tools;

/**
 * 分页工具类
 * @author 唐懋文
 * @since 2009-10-29 上午11:25:13
 *
 */
public class HibernatePageingSupport {

	private static final Logger logger = Logger.getLogger(HibernatePageingSupport.class);

	/**
	 * 得到分页结果集
	 * @param PageingBO 分页条件
	 * @param poClass 数据实体类型
	 * @param boClass 业务实体类型
	 * @param session hibernate会话
	 * @return 形如{count:总记录数, boList:结果集}的map
	 */
	public static Map<String, Object> getPageing(PageingBO page, Class<?> poClass, Class<?> boClass, Session session) {
		Criteria criteria = session.createCriteria(poClass);
		// 初始化查询条件
		Criterion expre = initLogicExpres(page.getConditions().listIterator());
		if(!Tools.isEmpty(expre)) criteria.add(expre);
		// 设置分页参数
		int rowCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setFirstResult(page.getStart());
		if(page.getLimit() != -1) criteria.setMaxResults(page.getLimit());
		// 排序
		initOrder(page.getOrders(), criteria);
		// 转换bean
		return getResults(boClass, criteria, rowCount);
	}
	
	private static Criterion initLogicExpres(ListIterator<Object[]> listIter) {
		Criterion expre = null;
		Object[] conditionArray = null;
		while (listIter.hasNext()) {
			conditionArray = listIter.next();
			Object value = conditionArray[5];
			String condition = String.valueOf(conditionArray[0]);
			String border = String.valueOf(conditionArray[1]);
			String column = String.valueOf(conditionArray[3]);
			String logic = String.valueOf(conditionArray[4]);
			if(border.equals("(") && !Tools.isEmpty(expre)) {
				listIter.previous();
				Criterion subExpre = initLogicExpres(listIter);
				expre = setCondition(expre, subExpre, condition);
			} else {
				if(logic.equals("!=")) {
					if(null == value) {
						expre = setCondition(expre, Restrictions.isNotNull(column), condition);
					} else {
						expre = setCondition(expre, Restrictions.ne(column, value), condition);
					}
				} else if(logic.equals("=")) {
					if(null == value) {
						expre = setCondition(expre, Restrictions.isNull(column), condition);
					} else {
						expre = setCondition(expre, Restrictions.eq(column, value), condition);
					}
				} else if(logic.equals("<=")) {
					expre = setCondition(expre, Restrictions.le(column, value), condition);
				} else if(logic.equals(">=")) {
					expre = setCondition(expre, Restrictions.ge(column, value), condition);
				} else if(logic.equals("like")) {
					String type = value.getClass().getName();
					if (type.equals("java.lang.String")) {
						expre = setCondition(expre, Restrictions.like(column, "%" + value + "%"), condition);
					} else {
						expre = setCondition(expre, Restrictions.eq(column, value), condition);
					}
				}
				if(border.equals(")"))  return expre;
			}
		}
		return expre;
	}
	
	private static Criterion setCondition(Criterion expre, Criterion subExpre, String condition) {
		if(Tools.isEmpty(expre)) {
			expre = subExpre;
		} else {
			if(condition.equals("or")) {
				expre = Restrictions.or(expre, subExpre);
			} else {
				expre = Restrictions.and(expre, subExpre);
			}
		}
		return expre;
	}
	
	private static void initOrder(List<String[]> orders, Criteria criteria) {
		if (Tools.isEmpty(orders)) return;
		Iterator<String[]> iter = orders.iterator();
		while(iter.hasNext()) {
			String[] orderArray = iter.next();
			if(orderArray[1].equals("desc")) {
				criteria.addOrder(Order.desc(orderArray[0]));
			} else {
				criteria.addOrder(Order.asc(orderArray[0]));
			}
		}
	}
	
	private static Map<String, Object> getResults(Class<?> boClass, Criteria criteria, int rowCount){
		List<?> polist = criteria.list();
		List<Object> boList = new ArrayList<Object>(polist.size());
		for (int i = 0; i < polist.size(); i++) {
			Object bo = null;
			try {
				bo = boClass.newInstance();
				BeanUtils.copyProperties(polist.get(i), bo);
				boList.add(bo);
			} catch (Exception e) {
				logger.error(boClass.getName() + "实例化失败", e);
				throw new MisException(boClass.getName() + "实例化失败", e);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", rowCount);
		map.put("boList", boList);
		return map;
	}
}
