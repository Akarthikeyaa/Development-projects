
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Use_Login_shopkeeper extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Use_Login_shopkeeper() {
        super();
        // TODO Auto-generated constructor stub
    }
    String url = "jdbc:mysql://localhost:3306/online_store";
    String user = "root";
    String password = "Abcdefg@12";
    String userType="shopkeeper";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 Connection con = DriverManager.getConnection(url, user, password);
             String email = request.getParameter("email");
             String pass = request.getParameter("password");
             Statement st = con.createStatement();
             if (checkpassword(email,pass)) {
                 Cookie cookie1=new Cookie("userType",userType);
                 Cookie cookie2=new Cookie("username",email);
                 cookie1.setMaxAge(60*60*24);
                 cookie2.setMaxAge(60*60*24);
                 response.addCookie(cookie1);
                 response.addCookie(cookie2);
                 response.sendRedirect("Product_ser");
             } else {
                 request.setAttribute("error", "Enter Valid Username or Password");
                 RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                 view.forward(request, response);
             }
             
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public boolean checkpassword(String email,String pass)
	{
		String query = "select count(*) from sign_shopkeeper where Password=\"" + pass +"\" and Email =\""+email+"\";";
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
