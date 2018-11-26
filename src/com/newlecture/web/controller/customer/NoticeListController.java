package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/list")
public class NoticeListController extends HttpServlet
{

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			// TODO Auto-generated method stub
			
			String page_ = request.getParameter("p");
			int page = 1;
			
			if(page_!=null && page_.equals(""))
				page=Integer.parseInt(page_);
			
			
			
			String sql = "SELECT * FROM "+"(SELECT ROWNUM NUM, N.* FROM " + 
					"(" + 
					"    SELECT * FROM NOTICE ORDER BY REGDATE DESC) N " + 
					")" + 
					"WHERE NUM BETWEEN ? AND ?";

			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
			try 
			{
				
				int start = (page-1)*10+1;
				int end = page*10;
//				int start = (page/10)*10+1;
//				int end = (page/10)*10+10;
				
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,"c##sist","dclass");

				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, start);
				st.setInt(2, end);
				
				ResultSet rs =st.executeQuery();  

				
				List<Notice> list = new ArrayList<>();
				
				while(rs.next()) 
				{
					Notice n = new Notice
							(
					
							rs.getInt("id"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("writer_Id"),
							rs.getDate("regDate"),
							rs.getInt("hit")
							);
//					n.setId(rs.getString("id"));
//					n.setTitle(rs.getString("title"));
					//...
					
					list.add(n);
					
				}

				 // 사용했으면 끊어줘야한다.
					rs.close();
					st.close();
					con.close();
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp");
				    request.setAttribute("list", list);
				    dispatcher.forward(request, response);
					
				
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
		}
	
	
}
