package calculater;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cal")
public class CalculationController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String total ="";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.jsp");
		request.setAttribute("total", total);
		
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		String cmd =request.getParameter("cmd");
		
		String total="";
		
		switch(cmd) 
		{
		
			case "0":
			{
				total=request.getParameter("total");
				total+=0;
				
				break;
			}
			
			case "1":
			{
				total=request.getParameter("total");
				total+=1;
				break;
				
			}
			
			case "2":
			{
				total=request.getParameter("total");
				total+=2;
				break;
			}
			
			case "3":
			{
				total=request.getParameter("total");
				total+="3";
				break;
			}
			case "4":
			{
				total=request.getParameter("total");
				total+="4";
				break;
			}
			
			case "5":
			{
				total=request.getParameter("total");
				total+="5";
				break;
			}
			
			case "6":
			{
				total=request.getParameter("total");
				total+="6";
				break;
			}
			
			case "7":
			{
				total=request.getParameter("total");
				total+="7";
				break;
			}
			
			case "8":
			{
				total=request.getParameter("total");
				total+="8";
				break;
			}
			
			case "9":
			{
				total=request.getParameter("total");
				total+="9";
				break;
			}
			
			case "+":
			{
				total=request.getParameter("total");
				total+="+";
				break;
			}
			
			case "-":
			{	
				total=request.getParameter("total");
				total+="-";
				break;
			}
			case "*":
			{
				total=request.getParameter("total");
				total+="*";
				break;
			}
			
			case "/":
			{
				total=request.getParameter("total");
				total+="/";
				break;
			}
			case "c":
			{
				total="";
				break;
			}
			
			case "<-":
			{
				String aa = request.getParameter("total");
				total=aa.substring(0,aa.length()-1);
				break;
			}
			
			case "=":
			{
				total = request.getParameter("total");
				if(total.contains("+")) 
				{
					total=(Integer.parseInt(total.split("\\+")[0])+Integer.parseInt(total.split("\\+")[1]))+"";
				}
				else if(total.contains("-")) 
				{
					total=(Integer.parseInt(total.split("-")[0])-Integer.parseInt(total.split("-")[1]))+"";

				}
				else if(total.contains("*")) 
				{
					total=(Integer.parseInt(total.split("*")[0])*Integer.parseInt(total.split("*")[1]))+"";

				}
				else if(total.contains("/")) 
				{
					total=(Integer.parseInt(total.split("/")[0])/Integer.parseInt(total.split("/")[1]))+"";

				}
				break;
			}
		
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.jsp");
		request.setAttribute("total", total);
		dispatcher.forward(request, response);
		
	//	response.sendRedirect("cal?t="+total); 
	}
	
	
	
	
	
	
	
	
}
