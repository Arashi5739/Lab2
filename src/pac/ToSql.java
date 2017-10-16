package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ToSql extends ActionSupport{
	Connection conn = null;
	public java.sql.Connection connection() throws SQLException{
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			String url= "jdbc:mysql://hvntursioeqe.mysql.sae.sina.com.cn:10671/bookdb5739"; //数据库ip地址、端口号、数据库名称 
			String user = "cjq5739";    //用户名 
			String psw= "pooh510cx77ace";   //密码 
			conn = DriverManager.getConnection(url, user, psw);   //建立连接 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}