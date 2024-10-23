import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PaymentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Payment Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Payment Page</h1>");
        out.println("<form action='paymentSuccess' method='post'>");
        out.println("<input type='text' name='cardNumber' placeholder='Card Number' required><br>");
        out.println("<input type='text' name='expiryDate' placeholder='Expiry Date (MM/YY)' required><br>");
        out.println("<input type='text' name='cvv' placeholder='CVV' required><br>");
        out.println("<button type='submit'>Pay Now</button>");
        out.println("</form>");
        out.println("<a href='cart'>Back to Cart</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
