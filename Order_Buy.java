
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class displayOrders
 */
public class Order_Buy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = null;
        Cookie cookie = null;
        cookies = request.getCookies();
        String username = null;
        String userType = null;
        if (cookies != null) {
            String cookieName1 = "userType";
            String cookieName2 = "username";
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals(cookieName1)) {
                    userType = cookie.getValue();
                } else if (cookie.getName().equals(cookieName2)) {
                    username = cookie.getValue();
                }
            }
        }

        if (cookies == null || username == null || userType == null ) {
            response.sendRedirect("Login_customer.jsp?msg=please Login as Buyer");
        } else if(userType.equals("customer")){
            Cart_M dao = new Cart_M();
            List<Table_Order> list = dao.viewUserOrders(username);
            if (list == null) {
                RequestDispatcher view = request.getRequestDispatcher("Orders.jsp?msg=No Orders Found");
                view.forward(request, response);
            } else {
                request.setAttribute("ordersList", list);
                RequestDispatcher view = request.getRequestDispatcher("Orders.jsp");
                view.forward(request, response);
            }
        }else if(userType.equals("shopkeeper")) {
        	Cart_M dao = new Cart_M();
            List<Table_Order> list = dao.viewAllOrders();
            if (list == null) {
                RequestDispatcher view = request.getRequestDispatcher("Orders.jsp?msg=No Orders Found");
                view.forward(request, response);
            } else {
                request.setAttribute("ordersList", list);
                RequestDispatcher view = request.getRequestDispatcher("Orders.jsp?username="+username+"&userType="+userType);
                view.forward(request, response);
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
