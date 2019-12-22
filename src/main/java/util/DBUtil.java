package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Function;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * @author 11623
 *
 */
public class DBUtil {
	private static DataSource dataSource;
	private static Properties p = new Properties();
	static {
		// 加载配置文件
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			// 创建一个对象并返回
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int executeUpdate(String sql, Object... args) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i + 1, args[i]);
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// exception: roll back
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			close(pstmt, conn);
		}
		return num;
	}

	public static void close(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(pstmt, conn);
	}


	/**
	 * @param sql
	 * @param Function<ResultSet, Object> parseResultSet 解析ResultSet的函数
	 * @param args
	 */
//	public static Object executeQuery(String sql, Function<ResultSet, Object> parseResultSet, Object... args) {
//		Connection conn = DBUtil.getConnection();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Object parse = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			for (int i = 0; i < args.length; i++) {
//				pstmt.setObject(i + 1, args[i]);
//			}
//			rs = pstmt.executeQuery();
//			parse = parseResultSet.apply(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DBUtil.closeAll(rs, pstmt, conn);
//		return parse;
//	}
	
	/**
	 * @param sql
	 * @param Function<ResultSet, Object> parseResultSet 解析ResultSet的函数
	 * @param args
	 */
	public static<T> T executeQuery(String sql, Function<ResultSet, T> parseResultSet, Object... args) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T parse = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i + 1, args[i]);
			}
			rs = pstmt.executeQuery();
			parse = parseResultSet.apply(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(rs, pstmt, conn);
		return parse;
	}

	public static void main(String[] args) {
		System.out.println(dataSource);
//		System.out.println(MyDBUtil.dataSource.getInitialSize());
//		System.out.println(MyDBUtil.dataSource.getMaxActive());
	}

}
