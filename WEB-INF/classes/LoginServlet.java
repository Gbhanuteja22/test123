import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userid");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (RegistrationServlet.isUserValid(userId, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("profile");
        } else {
            out.println("<h2>Invalid User ID or Password</h2>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
