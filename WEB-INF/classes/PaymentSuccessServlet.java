import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class PaymentSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Payment Success</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Payment Successful!</h1>");
        out.println("<p>Thank you for your payment. Your transaction was successful.</p>");
        out.println("<a href='profile'>Go to Profile</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
