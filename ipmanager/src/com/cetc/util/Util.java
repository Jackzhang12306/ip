package com.cetc.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cetc.bean.IpBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.sun.org.glassfish.gmbal.Description;

public class Util {
	
	private static Connection conn=null;
	private static PreparedStatement pstmt=null;
	private static ResultSet rs=null;
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
        String driverName = "com.mysql.jdbc.Driver";
        try {
            Driver d = (Driver) Class.forName(driverName).newInstance();
					 conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.153:3306/ipmanager?characterEncoding=utf-8",
			        "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;
    }
	
	public static boolean addIp(IpBean ipBean)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException {
		  conn = getConnection();
		 String sql="insert into iptable(ip,username,used,description) value(?,?,?,?)";  
	        try {  
	            pstmt=(PreparedStatement) conn.prepareStatement(sql);  
	            pstmt.setString(1,ipBean.getIp());  
	            pstmt.setString(2,ipBean.getUsername());
	            pstmt.setString(3,Integer.toString(ipBean.getUsed()));  
	            pstmt.setString(4,ipBean.getDecription());  
	            pstmt.executeUpdate();  
	        } catch (SQLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        finally {  
	            close(); 
	        }  
	        return true;
    }

    public static List<IpBean> getIpList(String username)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException {
         conn = getConnection();
        String sql = "select * from iptable where username = " + "'"+username+"'"; 
        List<IpBean> list = new ArrayList();
        try {
           	pstmt =  (PreparedStatement) conn.prepareStatement(sql);
             rs = (ResultSet) pstmt.executeQuery(sql);
            list = convertList(rs);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<IpBean> getIpList()
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException {
         conn = getConnection();
        String sql = "select * from iptable "; 
        List<IpBean> list = new ArrayList();
        try {
           	pstmt =  (PreparedStatement) conn.prepareStatement(sql);
             rs = (ResultSet) pstmt.executeQuery(sql);
            list = convertList(rs);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return list;
    }
    public static List<IpBean> query(String sql)
            throws SQLException {

    	  			try {
						conn = getConnection();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
          List<IpBean> list = new ArrayList();
          try {
        	  			pstmt =  (PreparedStatement) conn.prepareStatement(sql);
               rs = (ResultSet) pstmt.executeQuery(sql);
               list = convertList(rs);
          } catch (SQLException e) {
              System.out.println("数据库连接失败");
              e.printStackTrace();
          }
          return list;
    }
    

    
    
    
    private static List<IpBean> convertList(ResultSet rs)
            throws SQLException {

    		 List<IpBean> list = new ArrayList();
        
        while (rs.next()) { 
        	IpBean ipBean = new IpBean();
        		ipBean.setIp(rs.getString(2));
        		ipBean.setUsername(rs.getString(3));
        		ipBean.setUsed(Integer.parseInt((rs.getString(4))));
        		ipBean.setDecription(rs.getString(5));
        		list.add(ipBean);
        }
        return list;
    }
    
    public static void close() throws SQLException {  
        if(null != rs) {  
                rs.close();  
              }
       if(null != pstmt) {  
         pstmt.close();  
            }  
      if(null != conn) {  
        conn.close();  
          }
    }
    
    public static List<IpBean> queryPageForList() {
		int offset = 0;//起始行
		int limit = 10;//
    String sql = "select * from iptable ";
   	StringBuffer sb = new StringBuffer();
   	sb.append(sql);
   	sb.append(" LIMIT " + limit + " OFFSET  " + offset);
    List<IpBean> list = new ArrayList();
			try {
			conn = getConnection();
			pstmt =  (PreparedStatement) conn.prepareStatement(sb.toString());
			rs = (ResultSet) pstmt.executeQuery(sql);
	   list = convertList(rs);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


return list;
		

	}
    
    
    
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
    	 
		for(int i =0 ;i<50;i++){
			IpBean ipBean =new IpBean();
			ipBean.setIp("192.168.1.150");
			ipBean.setUsername("张三"+i);
			ipBean.setUsed(1);
			ipBean.setDecription("张三使用该ip上网");
			addIp(ipBean);
			
			
		}
		
		
		
		List<IpBean> list = new ArrayList();
    	 list=	getIpList("zhang");
    	 for(IpBean ip:list){
    		 System.out.println(ip.getIp()+ " \t"+ip.getDecription());
    	 }
    	
		
	}

}






