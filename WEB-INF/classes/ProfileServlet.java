import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userId = (session != null) ? (String) session.getAttribute("userId") : null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (userId != null) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Profile Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + userId + "!</h1>");
            out.println("<img src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png' alt='profile'>");
            out.println("<p>Your user ID is: " + userId + "</p>");
            out.println("<form action='cart' method='post'>");
            out.println("<input type='text' name='item' placeholder='Add to cart' required>");
            out.println("<input type='hidden' name='action' value='add'>");
            out.println("<button type='submit'>Add to Cart</button>");
            out.println("</form>");
            out.println("<a href='cart'>View Cart</a>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<h2>You are not logged in!</h2>");
            out.println("<a href='login.html'>Login Here</a>");
        }
    }
}
