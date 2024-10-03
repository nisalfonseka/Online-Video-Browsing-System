package payment_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet to handle updating payment details
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	// Method to handle POST requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set content type of the response
		response.setContentType("text/html");
		// Create PrintWriter object to send response to client
		PrintWriter out = response.getWriter();
		
		// Retrieve parameters from the request
		String pid = request.getParameter("id");
		int id = Integer.parseInt(pid);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String amount = request.getParameter("amount");
		String cardname = request.getParameter("cardname");
		String cardnumber = request.getParameter("cardnumber");
		String expmonth = request.getParameter("expmonth");
		String expyear = request.getParameter("expyear");
		String cvv = request.getParameter("cvv");
		
		// Create a new payment object and set its attributes
		pay e = new pay();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setAmount(amount);
		e.setCardname(cardname);
		e.setCardnumber(cardnumber);
		e.setExpmonth(expmonth);
		e.setExpyear(expyear);
		e.setCvv(cvv);
		
		// Call the update method in payDao to update the payment details
		int status = payDao.update(e);
		if (status > 0) {
			// If payment details are updated successfully, redirect to ViewServlet to view updated list
			response.sendRedirect("ViewServlet");
		} else {
			// If unable to update payment details, display error message
			out.println("Sorry! unable to update record");
		}
		
		// Close PrintWriter
		out.close();
	}

}
