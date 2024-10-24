import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
public class CartServlet extends HttpServlet {
    private static final String CART_SESSION_ATTR = "cart";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String item = request.getParameter("item");
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute(CART_SESSION_ATTR);
        if (cart == null) {
            cart = new ArrayList<>();
        }
        if ("add".equals(action)) {
            cart.add(item);
        } else if ("remove".equals(action)) {
            cart.remove(item);
        }
        session.setAttribute(CART_SESSION_ATTR, cart);
        response.sendRedirect("cart");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute(CART_SESSION_ATTR);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Your Cart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Your Cart</h1>");
        if (cart != null && !cart.isEmpty()) {
            out.println("<ul>");
            for (String item : cart) {
                out.println("<li>" + item + 
                    "<form action='cart' method='post' style='display:inline;'>"
                    + "<input type='hidden' name='item' value='" + item + "'>"
                    + "<input type='hidden' name='action' value='remove'>"
                    + "<button type='submit'>Remove</button></form></li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>Your cart is empty.</p>");
        }
        out.println("<form action='profile' method='get'>");
        out.println("<button type='submit'>Back to Profile</button>");
        out.println("</form>");
        out.println("<form action='payment.html'>");
        out.println("<button type='submit'>Proceed to Payment</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
