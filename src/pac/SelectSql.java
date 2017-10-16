package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SelectSql extends ActionSupport{
	private List<Book> list=new ArrayList<Book>();
	private int i;
	private String isbn;
	public List<Book> getList(){
		return list;
	}
	public String execute(){
		try{
			ToSql newl=new ToSql();	
			Connection conn=newl.connection();
		    Statement stmt = conn.createStatement();
		    String sql = "select * from book";
		    ResultSet res = stmt.executeQuery(sql);
		    list.clear();
		    try{
			    while(res.next()) {    
			    	Book b=new Book();
			    	b.AuthorID=res.getString("AuthorID"); 
			    	b.ISBN=res.getString("isbn");
			    	b.PublishDate=res.getString("publishdate");
			    	b.Publisher=res.getString("publisher");
			    	b.Title=res.getString("title");
			    	b.Price=res.getDouble("price");
			    	list.add(b);
			    }
			    sql = "select count(*) from book";
			    res = stmt.executeQuery(sql);
			    if (res.next())
			    	setI(res.getInt(1));
		    }		    
		    catch(Exception e){
		    	return ERROR;
		    }
		    res.close();  
		    stmt.close();  
		    conn.close();		
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;			
		}
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String delete(){
		try{
			ToSql newl=new ToSql();			  
			Connection conn=newl.connection();    //获取表达式SQL
		    Statement stmt = conn.createStatement();  
		    String sql = "DELETE FROM book WHERE ISBN='" + isbn + "';";     //执行SQL  
		    stmt.execute(sql);
		    sql = "select * from book";
		    ResultSet res = stmt.executeQuery(sql);
		    //打印结果集里的数
		    try{
			    while(res.next()) {    
			    	Book b=new Book();
			    	b.AuthorID=res.getString("AuthorID"); 
			    	b.ISBN=res.getString("isbn");
			    	b.PublishDate=res.getString("publishdate");
			    	b.Publisher=res.getString("publisher");
			    	b.Title=res.getString("title");
			    	b.Price=res.getDouble("price");
			    	list.add(b);
			    }
			    sql = "select count(*) from book";
			    res = stmt.executeQuery(sql);
			    if (res.next())
			    	setI(res.getInt(1));
		    }		    
		    catch(Exception e){
		    	return ERROR;
		    }
		    res.close();  
		    stmt.close();  
		    conn.close();		
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;			
		}
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}

}
