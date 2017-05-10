package Util;

import java.sql.*;

import Entity.Guitar;
import Service.GuitarService;

public class addGuitar {
	private GuitarService guitarService;
	
	  public GuitarService getGuitarService() {
		return guitarService;
	}

	public void setGuitarService(GuitarService guitarService) {
		this.guitarService = guitarService;
	}

	public static void main( String args[] )
	  {		  
        // TODO Auto-generated method stub
        try {
            // 0 连接SQLite的JDBC
            String sql="jdbc:sqlite:db/work.db";
            Class.forName("org.sqlite.JDBC");

            // 1 建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之
            Connection conn = DriverManager.getConnection(sql);
            Statement stat = conn.createStatement();
            
            // 2 创建一个表tbl1，录入数据
//            stat.executeUpdate("insert into Guitar values(1,'后面1','1厂','a模型',100.00,'前面1','a类型')"); 

            ResultSet rs = stat.executeQuery("select * from Guitar;"); // 查询数据
            while (rs.next()) {  
                System.out.println(rs.getString("backWood") + rs.getDouble("price"));  
            }  
            rs.close();

            conn.close(); // 结束数据库的连接
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	  }

