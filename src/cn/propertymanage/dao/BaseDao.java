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
 * ���ݿ�������رչ����ࡣ
 * �������е�
 */
public class BaseDao {
	private String driver = 
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";// ���ݿ������ַ���
	private String url = 
		"jdbc:sqlserver://localhost:1433;DatabaseName=propertymanage";// ����URL�ַ���
	private  String user = "mytest"; // ���ݿ��û���
	private  String password = "1234"; // �û�����
	Connection conn = null;// �������Ӷ���
	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public Connection getConnection() {
		if(conn==null){
			// ��ȡ���Ӳ������쳣
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();// �쳣����
			}
		}	
		return conn;// �������Ӷ���
	}
	/**
	 * �ر����ݿ����ӡ�
	 * @param conn ���ݿ�����
	 * @param stmt Statement����
	 * @param rs �����
	 */
	public void closeAll(Connection conn, Statement stmt, 
					ResultSet rs) {
		// �����������Ϊ�գ���ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��Statement����Ϊ�գ���ر�
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ����ɾ���ĵĲ���
	 * @param sql Ԥ����� SQL ���          
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int executeUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn =  getConnection(); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
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
	 * Admin��Ĳ����
	 * @param preparedSql Ԥ����� SQL ���  
	 * @param param Ԥ����� SQL ����еġ������������ַ�������       
	 * @return Admin����
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
	 * Man��Ĳ����
	 * @param preparedSql Ԥ����� SQL ���  
	 * @param param Ԥ����� SQL ����еġ������������ַ�������       
	 * @return Man����
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
	 * ���Man������Ԫ��
	 */
	public void ShowMan(){
		PreparedStatement pstmt = null;
		conn=getConnection();
		try{			
			ResultSet rs=null;
			pstmt=conn.prepareStatement("select * from man");
			rs=pstmt.executeQuery();
			System.out.println("���\t����\tְ��\t��ע");
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
	 * Property��Ĳ����
	 * @param preparedSql Ԥ����� SQL ���  
	 * @param param Ԥ����� SQL ����еġ������������ַ�������       
	 * @return Property����
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
	 * ���Property�������Ԫ��
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
	 * �����鷵��Property��List
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
