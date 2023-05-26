

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class cartDisplay
 */
public class Display_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	        if (cookies == null || username == null || userType == null || userType.equals("shopkeeper")) {
	            request.setAttribute("error", "Please Login as Buyer");
	            RequestDispatcher view = request.getRequestDispatcher("error.jsp");
	            view.forward(request, response);
	        } else {
	            Cart_M dao = new Cart_M();
	            List<Add_to_cart> list = dao.viewAllItems(username);
	            request.setAttribute("cartList", list);
	            RequestDispatcher view = request.getRequestDispatcher("Addtocarts.jsp");
	            view.forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
