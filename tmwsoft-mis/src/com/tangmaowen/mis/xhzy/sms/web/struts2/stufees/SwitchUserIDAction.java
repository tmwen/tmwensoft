package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.CachedRowSet;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.common.SQLHandle;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;

public class SwitchUserIDAction extends MisXhzySmsBaseAction {

	@Override
	public String execute() {
		setAjax(false);
		setLog(false);
		setVerifyRequest("no");
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		Connection conn = null;
		try {
			conn = SQLHandle.getConnection();
			boolean ac = conn.getAutoCommit();
			conn.setAutoCommit(false);
			CachedRowSet u = SQLHandle.getCachedRowSet(conn,"SELECT u.userid,u.username FROM users u", null);
			Map mu = new HashMap(u.size());
			while(u.next()) {
				mu.put(u.getString(1), u.getString(2));
			}
			CachedRowSet s = SQLHandle.getCachedRowSet(conn,"SELECT s.stuid,s.yjfskr FROM student_baseinfo s where s.yjfskr REGEXP '^[0-9]'", null);
			while(s.next()) {
				s.updateString(2, (String)mu.get(s.getString(2)));
				s.updateRow();
			}
			//s.setTableName("student_baseinfo");
			s.acceptChanges(conn);
			conn.setAutoCommit(ac);
			System.out.println("success..................................................................................");
		} catch (Exception e) {
			System.out.println("error..................................................................................");
			e.printStackTrace();
		} finally {
			SQLHandle.closeConnection(conn);
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return null;
	}
}