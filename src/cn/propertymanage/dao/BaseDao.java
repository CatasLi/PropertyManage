package cn.propertymanage.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.propertymanage.entity.*;
/**
 * 数据库连接与关闭工具类。
 * 借用已有的
 */
public class BaseDao {
	private String driver = 
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动字符串
	private String url = 
		"jdbc:sqlserver://localhost:1433;DatabaseName=propertymanage";// 连接URL字符串
	private  String user = "mytest"; // 数据库用户名
	private  String password = "1234"; // 用户密码
	Connection conn = null;// 数据连接对象
	/**
	 * 获取数据库连接对象。
	 */
	public Connection getConnection() {
		if(conn==null){
			// 获取连接并捕获异常
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();// 异常处理
			}
		}	
		return conn;// 返回连接对象
	}
	/**
	 * 关闭数据库连接。
	 * @param conn 数据库连接
	 * @param stmt Statement对象
	 * @param rs 结果集
	 */
	public void closeAll(Connection conn, Statement stmt, 
					ResultSet rs) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增、删、改的操作
	 * @param sql 预编译的 SQL 语句          
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int executeUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn =  getConnection(); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return num;
	}
	/**
	 * Admin类的查操作
	 * @param preparedSql 预编译的 SQL 语句  
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组       
	 * @return Admin对象
	 */
	public Admin executeAd(String preparedSql,Object[] param){
		PreparedStatement pstmt = null;
		Admin ad=new Admin();
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); 
				}
			rs=pstmt.executeQuery();
			if(rs.next()){
			  ad.setName(rs.getString(1));
			  ad.setPassword(rs.getString(2));
			}
		    }		
	    }catch (SQLException e) {
		    e.printStackTrace();
	    } finally{
	 	    closeAll(conn, pstmt, null);
	    }
		return ad;
     }
	/**
	 * Man类的查操作
	 * @param preparedSql 预编译的 SQL 语句  
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组       
	 * @return Man对象
	 */
	public Man executeMan(String preparedSql,Object[] param){
		PreparedStatement pstmt = null;
		Man man=new Man();
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); 
				}
			rs=pstmt.executeQuery();
			if(rs.next()){
			  man.setId(rs.getInt(1));
			  man.setName(rs.getString(2));
			  man.setPosition(rs.getString(3));
			  man.setOthers(rs.getString(4));
			}
		    }		
	    }catch (SQLException e) {
		    e.printStackTrace();
	    } finally{
	 	    closeAll(conn, pstmt, null);
	    }
		return man;
     }
	/**
	 * 输出Man表所有元素
	 */
	public void ShowMan(){
		PreparedStatement pstmt = null;
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement("select * from man");
			rs=pstmt.executeQuery();
			System.out.println("编号\t姓名\t职务\t备注");
			if(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}		    		
	    }catch (SQLException e) {
		    e.printStackTrace();
	    } finally{
	 	    closeAll(conn, pstmt, null);
	    }
	}
	/**
	 * Property类的查操作
	 * @param preparedSql 预编译的 SQL 语句  
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组       
	 * @return Property对象
	 */
	public Property executePro(String preparedSql,Object[] param){
		PreparedStatement pstmt = null;
		Property pro=new Property();
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); 
				}
			rs=pstmt.executeQuery();
			if(rs.next()){
			  pro.setId(rs.getInt(1));
			  pro.setName(rs.getString(2));
			  pro.setClassify(rs.getString(3));
			  pro.setModel(rs.getString(4));
			  pro.setValue(rs.getInt(5));
			  pro.setBuyDate(rs.getString(6));
			  pro.setStatus(rs.getString(7));
			  pro.setIuser(rs.getString(8));
			  pro.setOthers(rs.getString(9));
			}
		    }		
	    }catch (SQLException e) {
		    e.printStackTrace();
	    } finally{
	 	    closeAll(conn, pstmt, null);
	    }
		return pro;
     }
	/**
	 * 输出Property表的所有元素
	 */
	public void ShowPro(){
		PreparedStatement pstmt = null;
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement("select * from property");
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
			}		    		
	    }catch (SQLException e) {
		    e.printStackTrace();
	    } finally{
	 	    closeAll(conn, pstmt, null);
	    }
	}
	/**
	 * 按所查返回Property的List
	 */
	public List<Property> FindbyClass(String preparedSql,Object[] param){
		PreparedStatement pstmt = null;
		List<Property> l=new ArrayList<Property>();
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); 
				}
			rs=pstmt.executeQuery();
			while(rs.next()){
				Property pro=new Property();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setClassify(rs.getString(3));
				pro.setModel(rs.getString(4));
				pro.setValue(rs.getInt(5));
				pro.setBuyDate(rs.getString(6));
				pro.setStatus(rs.getString(7));
				pro.setIuser(rs.getString(8));
				pro.setOthers(rs.getString(9));
			    l.add(pro);
			}
		    }		
	    }catch (SQLException e) {
		    e.printStackTrace();
	    } finally{
	 	    closeAll(conn, pstmt, null);
	    }
		return l;
	}
}
