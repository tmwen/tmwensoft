/**
 * @author 唐懋文
 * @since 2009-11-6上午09:22:45
 */
package com.tangmaowen.mis.sys.domain;

import java.util.ArrayList;
import java.util.List;

import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-6 上午09:22:45
 * 
 */
public class PageingBO {
	private int start = 0;
	private int limit = 0;
	private List<Object[]> conditions = new ArrayList<Object[]>();
	private List<String[]> orders = new ArrayList<String[]>();

	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            记录开始数
	 */
	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            最大记录数, -1时不进行分页
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Object[]> getConditions() {
		return conditions;
	}

	/**
	 * @param conditions 查询条件
	 *		 自定义查询 {"condition", "border", "table", "column", "logic", "value"}
	 *					condition为and、or；border为(或)；logic为=、>=、like、not等；
	 *		 普通查询 {"column", "value"} 字符用like匹配，其它用=匹配
	 * select * from table a where a.a='1' and a.b='2' or (a.c='3' and a.d='4' or a.e='5')
	 * 
	 */
	public void setConditions(List<Object[]> conditions) {
		this.conditions = conditions;
	}

	public void setConditionExceptNull(Object column, Object value) {
		setConditionExceptNull("and", "", "", column, "like", value);
	}

	public void setCondition(Object column, Object value) {
		setCondition("and", "", "", column, "like", value);
	}

	public void setConditionExceptNull(Object condition, Object border, Object table, Object column, Object logic, Object value) {
		if (Tools.isEmpty(value)) return;
		setCondition(condition, border, table, column, logic, value);
	}

	public void setCondition(Object condition, Object border, Object table, Object column, Object logic, Object value) {
		this.conditions.add(new Object[] { condition, border, table, column, logic, value });
	}

	public List<String[]> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            排序条件 自定义查询 ["column", "order"]
	 *            column为要排序的列名；order为排序方式，分为asc和desc
	 */
	public void setOrders(List<String[]> orders) {
		this.orders = orders;
	}

	public void setOrder(String column, String order) {
		this.orders.add(new String[] { column, order });
	}
}
