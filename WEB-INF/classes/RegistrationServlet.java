import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
public class RegistrationServlet extends HttpServlet {
    private static HashMap<String, String> users = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userid");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!users.containsKey(userId)) {
            users.put(userId, password);
            out.println("<h2>Registration Successful!</h2>");
            out.println("<a href='login.html'>Go to Login</a>");
        } else {
            out.println("<h2>User ID already exists. Please try another one.</h2>");
            out.println("<a href='registration.html'>Go Back to Registration</a>");
        }
    }

    public static boolean isUserValid(String userId, String password) {
        return users.containsKey(userId) && users.get(userId).equals(password);
    }
}
