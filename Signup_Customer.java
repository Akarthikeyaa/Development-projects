
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Signup_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Signup_Customer() {
        super();
    }
    String url = "jdbc:mysql://localhost:3306/online_store";
    String user = "root";
    String password = "Abcdefg@12";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String type ="customer";
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            if(checkCustomername(email))
            {
            	 request.setAttribute("error", "Login with New User , UserName Already exits");
                 RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                 view.forward(request, response);
            }
            else
            {
            	Cookie ck1 = new Cookie("userType", type);
                Cookie ck2 = new Cookie("username", name);
                ck1.setMaxAge(60 * 60 * 24);
                ck2.setMaxAge(60 * 60 * 24);
                response.addCookie(ck1);
                response.addCookie(ck2);
                String itemInsertQuery = "insert into signup_customer values(?,?,?)";
                PreparedStatement Item = con.prepareStatement(itemInsertQuery);
                Item.setString(1, name);
                Item.setString(2, email);
                String pass = request.getParameter("password");
                Item.setString(3, pass);
                Item.execute();
                response.sendRedirect("Product_ser");
            	
            }
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "Homepage.jsp");
        }
        catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 public boolean checkCustomername(String Email) {
	        String query = "select count(*) from  signup_customer "  + " where Email=\"" + Email + "\";";
	        PreparedStatement ps;
	        try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection con = DriverManager.getConnection(url, user, password);
	            ps = con.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                if (rs.getInt(1) == 0) {
	                    return false;
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return true;
	    }
	
}
