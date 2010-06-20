package com.tangmaowen.mis.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * <pre>
 * <b>数据库连接管理</b>
 * 
 * 默认使用以下方式执行数据库操作：
 * 
 * CachedRowSet crs = getCachedRowSet(sql, params);
 * int i = update(sql, params);
 * int[] i = executeBatch(sqls);
 * 
 * 客户端可以显示获取数据库连接，调用完毕应负责关闭该连接：
 * Connection conn = null;
 * CachedRowSet crs = null;
 * String sql = "select * from dual where id = ?";
 * Hashtable params = new Hashtable();
 * params.put("0", "123");
 * try{
 * 	conn = SQLHandle.getConnection();
 * 	crs = getCachedRowSet(conn, sql, params);
 * 	...
 * } finally {
 * 	SQLHandle.closeCachedRowSet(crs);
 * 	SQLHandle.closeConnection(conn);
 * }
 * </pre>
 * @author 唐懋文, 金信工程研发组
 * @version 1.0 2008-2-16
 */

public class SQLHandle {

	/**
	 * 获取默认数据库连接
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws Exception {
		return getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/xhzysms?useUnicode=true&characterEncoding=GBK", "root", "19831203");
	}

	/**
	 * 通过驱动类名和url获取数据库连接
	 * @param driver 需要注册的驱动程序类名。
	 * @param url jdbc:subprotocol:subname 形式的数据库 url。
	 * 
	 * @throws Exception
	 */
	public static Connection getConnection(String driver, String url)
			throws Exception {
		return getConnection(driver, url, null, null);
	}

	/**
	 * 通过驱动类名、url、用户名和密码获取数据库连接
	 * @param driver 需要注册的驱动程序类名。
	 * @param url url jdbc:subprotocol:subname 形式的数据库 url。
	 * @param user 数据库用户，连接是为该用户建立的。
	 * @param password 用户密码。
	 * 
	 * @throws Exception
	 */
	public static Connection getConnection(String driver, String url,
			String user, String password) throws Exception {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			printStackTrace(e);
			throw e;
		}
		return conn;
	}

	/**
	 * 执行给定的 SQL SELECT 语句，该语句返回单个 CachedRowSet 对象；使用默认数据连接。
	 * （建议使用此方法）
	 * @param sql 通常为静态 SQL SELECT 语句。
	 * @param params 查询参数，与sql的?一一对应，可以为空。
	 * @return 包含给定查询所生成数据的 CachedRowSet 对象。
	 * @throws Exception 
	 */
	public static CachedRowSet getCachedRowSet(String sql, Hashtable params) throws Exception {
		Connection conn = null;
		CachedRowSet crs = null;
		try {
			conn = getConnection();
			crs = getCachedRowSet(conn, sql, params);
		} finally {
			closeConnection(conn);
		}
		return crs;
	}
	/**
	 * 执行给定的 SQL SELECT 语句，该语句返回单个 CachedRowSet 对象；需要客户端提供数据库连接，并负责关闭。
	 * @param conn 数据库或池连接。
	 * @param sql 通常为静态 SQL SELECT 语句。
	 * @param params 查询参数，与sql的?一一对应，可以为空。
	 * @return 包含给定查询所生成数据的 CachedRowSet 对象。
	 * @throws Exception 
	 */
	public static CachedRowSet getCachedRowSet(Connection conn, String sql,
			Hashtable params) throws Exception {
		PreparedStatement pst = null;
		ResultSet rs = null;
		CachedRowSet crs = null;
		try {
			pst = conn.prepareStatement(sql);
			if (null != params) {
				for (int i = 0; i < params.size(); i++) {
					pst.setObject(i + 1, params.get(String.valueOf(i)));
				}
			}
			rs = pst.executeQuery();
			crs = new CachedRowSetImpl();
			crs.populate(rs);
		} catch (Exception e) {
			printStackTrace(e);
			throw e;
		} finally {
			closeResultSet(rs);
			closePreparedStatement(pst);
		}
		return crs;
	}

	/**
	 * 更新、插入或删除数据；使用默认数据连接。
	 * （建议使用此方法）
	 * @param sql 该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）。
	 * @param params 查询参数，与sql的?一一对应，可以为空。
	 * @return INSERT、UPDATE 或 DELETE 语句的行计数；或者 0，表示不返回任何内容的 SQL 语句。
	 * @throws Exception 
	 */
	public static int update(String sql, Hashtable params) throws Exception {
		Connection conn = null;
		int count = 0;
		try {
			conn = getConnection();
			count = update(conn, sql, params);
		} finally {
			closeConnection(conn);
		}
		return count;
	}

	/**
	 * 更新、插入或删除数据；需要客户端提供数据库连接，并负责关闭。
	 * @param conn 数据库或池连接。
	 * @param sql 该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）。
	 * @param params 查询参数，与sql的?一一对应，可以为空。
	 * @return INSERT、UPDATE 或 DELETE 语句的行计数；或者 0，表示不返回任何内容的 SQL 语句。
	 * @throws Exception 
	 */
	public static int update(Connection conn, String sql, Hashtable params) throws Exception {
		PreparedStatement pst = null;
		int count = 0;
		try {
			pst = conn.prepareStatement(sql);
			if (null != params) {
				for (int i = 0; i < params.size(); i++) {
					pst.setObject(i + 1, params.get(String.valueOf(i)));
				}
			}
			count = pst.executeUpdate();
		} catch (Exception e) {
			printStackTrace(e);
			throw e;
		} finally {
			closePreparedStatement(pst);
		}
		return count;
	}

	/**
	 * 批量更新或插入数据；使用默认数据连接。
	 * （建议使用此方法）
	 * @param sqls 通常包含为静态的 SQL INSERT 或 UPDATE 语句的数组。
	 * @return 如果全部命令执行成功，则返回更新计数组成的数组。
	 * @throws Exception 
	 */
	public static int[] executeBatch(ArrayList sqls) throws Exception {
		Connection conn = null;
		int counts[] = null;
		try {
			conn = getConnection();
			counts = executeBatch(conn, sqls);
		} finally {
			closeConnection(conn);
		}
		return counts;
	}

	/**
	 * 批量更新或插入数据；需要客户端提供数据库连接，并负责关闭。
	 * @param conn 数据库或池连接。
	 * @param sqls 通常包含为静态的 SQL INSERT 或 UPDATE 语句的数组。
	 * @return 如果全部命令执行成功，则返回更新计数组成的数组。
	 * @throws Exception 
	 */
	public static int[] executeBatch(Connection conn, ArrayList sqls) throws Exception {
		Statement stmt = null;
		int counts[] = null;
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for (int i = sqls.size() - 1; i >= 0; i--) {
				stmt.addBatch((String) sqls.get(i));
			}
			counts = stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (Exception e) {
			printStackTrace(e);
			throw e;
		} finally {
			closeStatement(stmt);
		}
		return counts;
	}

	// ------------------------资源管理---------------------------

	public static void closeCachedRowSet(CachedRowSet crs) {
		if (null != crs) {
			try {
				crs.close();
			} catch (SQLException e) {
				printStackTrace(e);
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				printStackTrace(e);
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement pst) {
		if (null != pst) {
			try {
				pst.close();
			} catch (SQLException e) {
				printStackTrace(e);
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				printStackTrace(e);
			}
		}
	}

	public static void closeConnection(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				printStackTrace(e);
			}
		}
	}

	private static void printStackTrace(Exception e) {
		e.printStackTrace();
	}

}
