import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add2")
public class Add2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	//	super.doGet(req, resp);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		int x=0;
		int y=0;
		int sum=0;
		
		String sum_ = request.getParameter("s");
		
		if(sum_!=null)
			sum = Integer.parseInt(sum_);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add2.jsp");
		request.setAttribute("sum", sum);
		
		dispatcher.forward(request, response);
		
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("   <form action=\"add2\" method=\"post\">");
//		out.write("       <div>");
//		out.write("           <label>x :  </label>");
//		out.write("         <input type=\"text\" name=\"x\" value=\""+x+"\" / >");
//		out.write("       </div>");
//		out.write("       <div>");
//		out.write("           <label>y : </label>");
//		out.write("           <input type=\"text\" name=\"y\" value=\""+y+"\" />");
//		out.write("       </div>");
//		out.write("       <div>");
//		out.println("           <label>sum : "+sum+"</label> ");
//		out.write("					<span></span>");
//		out.write("       </div>");
//		out.write("       <div>");
//		out.write("           <input type=\"submit\" value=\"����\" />");
//		out.write("       </div>");
//		out.write("   </form>");
//		out.write("   <a href=\"mypage\">����������</a>");
//		out.write("</body>");
//		out.write("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	//	super.doPost(req, resp);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String cmd =request.getParameter("cmd");
		
		int x=0;
		int y=0;
		int sum=0;
		
		switch(cmd) 
		{
		
			case "����":
			{
				String x_ = request.getParameter("x");
				String y_ = request.getParameter("y");
					
				if( x_!=null && !x_.equals("") ) 
					x = Integer.parseInt(x_);
				if( y_!=null && !y_.equals("") )
					y = Integer.parseInt(y_);
				
				sum= x+y;
				break;
			}
			
			case "session":
			{	
				String sum1 = request.getParameter("sum");
				HttpSession session = request.getSession();
				session.setAttribute("sum", sum1);
				break;
			}
			case "application":
			{
				String sum1 = request.getParameter("sum");
				ServletContext application = request.getServletContext();
				application.setAttribute("sum", sum1);
				break;
			}
	//		RequestDispatcher dispatcher = request.getRequestDispatcher("/add2");
	//		request.setAttribute("sum", sum);
	//		dispatcher.forward(request, response);
		}
		
		response.sendRedirect("add2?s="+sum); //GET ��û�� ����
		
		
		
	}
	
//	public void service(HttpServletRequest request,
//				HttpServletResponse response)
//				throws IOException,ServletException
////�������� �̷� ������� ����ߴ�
//
//	
//				
//	{
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		
//		
//		
//		
//		int x=0;
//		int y=0;
//		int sum=0;
//		
//		if(request.getMethod().endsWith("POST"))   // POST �� ���� �����ϰڴ�.
//		{
//			String x_ = request.getParameter("x");
//			String y_ = request.getParameter("y");
//			
//			if( x_!=null && !x_.equals("") ) 
//				x = Integer.parseInt(x_);
//			if( y_!=null && !y_.equals("") )
//				y = Integer.parseInt(y_);
//		}
//		sum= x+y;
//		
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("   <form action=\"add2\" method=\"post\">");
//		out.write("       <div>");
//		out.write("           <label>x :  </label>");
//		out.write("         <input type=\"text\" name=\"x\" value=\""+x+"\" / >");
//		out.write("       </div>");
//		out.write("       <div>");
//		out.write("           <label>y : </label>");
//		out.write("           <input type=\"text\" name=\"y\" value=\""+y+"\" />");
//		out.write("       </div>");
//		out.write("       <div>");
//		out.println("           <label>sum : "+sum+"</label> ");
//		out.write("					<span></span>");
//		out.write("       </div>");
//		out.write("       <div>");
//		out.write("           <input type=\"submit\" value=\"����\" />");
//		out.write("       </div>");
//		out.write("   </form>");
//		out.write("</body>");
//		out.write("</html>");
//		
////		if(sum==0) 
////		{
////			
////		}
////		else if(sum!=0) 
////		{
////			out.println(sum);
////		}
//		
//		
//	}

}