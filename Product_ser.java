import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

  
public class Product_ser extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    public Product_ser() { super(); }
  
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException
    {
        int page = 1;
        int recordsPerPage;
        if(request.getParameter("noOfItems")==null) {
            recordsPerPage=10; 
        }else
        {
        	recordsPerPage=Integer.parseInt(request.getParameter("noOfItems"));
        }
        if (request.getParameter("page") != null)
        {
            page = Integer.parseInt(request.getParameter("page"));
        }
        Method dao = new Method();
        List<Card_9> list = dao.viewAllCards(
            (page - 1) * recordsPerPage,
            recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0
                                       / recordsPerPage);
        request.setAttribute("CardList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        String msg = request.getParameter("error");
        RequestDispatcher view
            = request.getRequestDispatcher("shop_display.jsp");
        view.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}