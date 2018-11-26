import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add")
public class Add extends HttpServlet
{
	public void service(HttpServletRequest request,
				HttpServletResponse response)
				throws IOException,ServletException


	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String sum_;
		
		int x=0;
		int y=0;
		int sum=0;
		
		if( x_!=null && !x_.equals("") ) 
			x = Integer.parseInt(x_);
		if( y_!=null && !y_.equals("") )
			y = Integer.parseInt(y_);
		
		sum= x+y;
		if(sum==0) 
		{
			
		}
		else if(sum!=0) 
		{
			out.println(sum);
		}
		
		
	}

}