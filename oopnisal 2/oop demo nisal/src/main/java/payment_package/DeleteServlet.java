package payment_package;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

//Servlet to handle deleting payment details
@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet { 
	// Method to handle GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
    	// Retrieve the ID of the payment to be deleted from the request parameter
        String pid=request.getParameter("id");  
     // Convert the ID to integer
        int id=Integer.parseInt(pid);  
     // Call the delete method in payDao to delete the payment with the given ID
        payDao.delete(id);  
     // Redirect the user to the ViewServlet to view the updated payment list
        response.sendRedirect("ViewServlet");  
    }  
}
