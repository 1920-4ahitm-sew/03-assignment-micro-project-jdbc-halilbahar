package at.htl.hotel.servlet;

import at.htl.hotel.database.Database;
import at.htl.hotel.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("hotel-servlet")
public class HotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter output = resp.getWriter();
        output.println("<table>");
        output.println("<tr>" +
                "<th>ID</th>" +
                "<th>First Name</th>" +
                "<th>Last Name</th>" +
                "</tr>"
        );
        List<Customer> customerList = Database.getInstance().selectAllCustomer();
        for (Customer customer : customerList) {
            output.println("<tr>" +
                    "<th>" + customer.getId() + "</th>" +
                    "<th>" + customer.getFirstName() + "</th>" +
                    "<th>" + customer.getLastName() + "</th>" +
                    "</tr>");
        }
        output.println("</table>");
    }
}
