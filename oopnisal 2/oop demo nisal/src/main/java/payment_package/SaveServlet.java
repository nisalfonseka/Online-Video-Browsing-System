package payment_package;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//Servlet to handle saving payment details
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {
	// Method to handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");
     // Create PrintWriter object to send response to client
        PrintWriter out=response.getWriter();  
        
     // Retrieve parameters from the request
        String name=request.getParameter("name");   
        String email=request.getParameter("email");  
        String amount=request.getParameter("amount"); 
        String cardname=request.getParameter("cardname");  
        String cardnumber=request.getParameter("cardnumber");  
        String expmonth=request.getParameter("expmonth");  
        String expyear=request.getParameter("expyear");  
        String cvv=request.getParameter("cvv");  
         
     // Create a new payment object and set its attributes
        pay e=new pay();  
         
        e.setName(name);  
        e.setEmail(email);  
        e.setAmount(amount);  
        e.setCardname(cardname);   
        e.setCardnumber(cardnumber);  
        e.setExpmonth(expmonth);  
        e.setExpyear(expyear); 
        e.setCvv(cvv); 
        
     // Call the save method in payDao to save the payment details
        int status=payDao.save(e);  
        if(status>0){  
        	// If payment details are saved successfully, display success message
            out.print("<p>Record saved successfully!</p>");  
         // Redirect the user back to the payment.html page
           request.getRequestDispatcher("payment.html").include(request, response);  
       }else{  
    	// If unable to save payment details, display error message
            out.println("Sorry! unable to save record");  
        } 
        //Close printwritter
        out.close();  
    }  
  
}
