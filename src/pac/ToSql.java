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
			String url= "jdbc:mysql://hvntursioeqe.mysql.sae.sina.com.cn:10671/bookdb5739"; //���ݿ�ip��ַ���˿ںš����ݿ����� 
			String user = "cjq5739";    //�û��� 
			String psw= "pooh510cx77ace";   //���� 
			conn = DriverManager.getConnection(url, user, psw);   //�������� 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}