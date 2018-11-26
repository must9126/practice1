package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		
			int id = Integer.parseInt(request.getParameter("id"));
		   
		   
		   String sql = "SELECT * FROM NOTICE WHERE ID ="+id;
		   
		   String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		   try 
		   {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			   Connection con = DriverManager.getConnection(url,"c##sist","dclass"); // 괄호안은  아이디/ 비밀번호/ 서버 주소 / 
			   Statement st = con.createStatement();  // select * from notices
			   // 한줄은 레코드 라 표현
			   ResultSet rs =st.executeQuery(sql);  
			    
			   rs.next();
			   
//			   String title = rs.getString("TITLE");
//			   String content = rs.getString("CONTENT");
//			   String writerId = rs.getString("WRITER_ID");
			   
			   
			   Notice n = new Notice
						(
				
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer_Id"),
						rs.getDate("regDate"),
						rs.getInt("hit")
						);
			   
			   rs.close();
			   st.close();
			   con.close();
			   
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp");
//			   request.setAttribute("title", title);
//			   request.setAttribute("content", content);
//			   request.setAttribute("writerId", writerId);
			   
			   request.setAttribute("n", n);

			   
			   
			   dispatcher.forward(request, response);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   

	}
}
