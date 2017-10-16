package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAuthor extends ActionSupport{
	private List<Search> list=new ArrayList<Search>();
	private String Name;
	private String Title;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getTitle() {
		return Title;
	}
	public String execute(){
		try{
		ToSql newl=new ToSql();
		//获取表达式SQL  
		Connection conn=newl.connection();
        Statement stmt = conn.createStatement();  
        //执行SQL  
        String sql = "select AuthorID from author where Name='" + Name + "';";
        ResultSet res = stmt.executeQuery(sql);
        //打印结果集里的数据
        String author_id = new String();
        while(res.next()) {    
        	author_id=res.getString("AuthorID");   
        }
        sql = "select Title,ISBN from book where AuthorID=" + author_id;
        res = stmt.executeQuery(sql);
        list.clear();
        while(res.next()) {   
        	Search s=new Search();
        	s.Title=res.getString(1);
        	s.ISBN=res.getString(2);
        	list.add(s);
        }   
        res.close();  
        stmt.close();  
        conn.close();		
		return SUCCESS;}
		catch(Exception e){
			return ERROR;			
		}
	}
	public List<Search> getList() {
		return list;
	}
	public void setList(List<Search> list) {
		this.list = list;
	}
}
