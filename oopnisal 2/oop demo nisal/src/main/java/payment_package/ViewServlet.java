package payment_package;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

//Servlet to view payment data
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	// Method to handle GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	// Set content type of the response
    	response.setContentType("text/html");
    	
    	 //CSS link tag
        String cssTag="<link rel='stylesheet' type='text/css' href='NewFile.css'>";
     // Create PrintWriter object to send response to client
        PrintWriter out=response.getWriter();
        
        //Html content to create tables and print data
        out.println("<!DOCTYPE html>");
        
        out.println("<html>");
	    out.println("<head><title>Payment Data</title>"+cssTag+"</head>");
	    out.println("<body>");
        out.println("<body>");
        
        out.println("<a href='payment.html' class='button'>Add New Payment</a>");
        out.println("<h1>Payment List</h1>");
        
       
     // Retrieve list of payments from DAO
        List<pay> list=payDao.getAllpayment();
          
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Amount</th><th>Cardname</th><th>Cardnumber</th><th>Expmonth</th><th>Expyear</th><th>Cvv</th><th>Edit</th><th>Delete</th></tr>");
     // Loop through each payment and display its details in a row
        for(pay e:list){
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getAmount()+"</td><td>"+e.getCardname()+"</td><td>"+e.getCardnumber()+"</td><td>"+e.getExpmonth()+"</td><td>"+e.getCvv()+"</td><td>"+e.getExpyear()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
