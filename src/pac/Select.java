package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Select extends ActionSupport{
	private String isbn;
	private List<Book> booklist=new ArrayList<Book>();
	private List<Author> authorlist=new ArrayList<Author>();
	public List<Book> getBookList(){
		return booklist;
	}
	public List<Author> getAuthorList(){
		return authorlist;
	}
	public String getISBN() {
		return isbn;
	}
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	public String execute(){
		try{
			String id;
			ToSql newl=new ToSql();			
			//获取表达式SQL  
			Connection conn=newl.connection();
		    Statement stmt = conn.createStatement();  
		    //执行SQL  
		    String sql = "select * from book WHERE ISBN='" + isbn + "';";
		    ResultSet res = stmt.executeQuery(sql);
		    booklist.clear();
		    //打印结果集里的数
		    id="";
		    while(res.next()) {    
		    	Book b=new Book();
		    	b.AuthorID=res.getString("AuthorID");
		    	id=res.getString("AuthorID");
		    	b.ISBN=res.getString("ISBN");
		    	b.PublishDate=res.getString("PublishDate");
		    	b.Publisher=res.getString("Publisher");
		    	b.Title=res.getString("Title");
		    	b.Price=res.getDouble("Price");
		    	booklist.add(b);
		    }
		    sql = "select * from author WHERE AuthorID='" + id + "';";
		    res = stmt.executeQuery(sql);
		    authorlist.clear();
		    //打印结果集里的数
		    while(res.next()) {    
		    	Author a=new Author();
		    	a.AuthorID=res.getString("AuthorID");
		    	a.Name=res.getString("Name");
		    	a.Age=res.getInt("Age");
		    	a.Country=res.getString("Country");
		    	authorlist.add(a);
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
}
