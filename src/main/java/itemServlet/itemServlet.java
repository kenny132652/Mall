package itemServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaBean.Item;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import itemDAO.ItemDAO;
import itemDAOimpl.ItemDAOimpl;

/**
 * Servlet implementation class itemServlet
 */
@WebServlet("/itemServlet.do")
public class itemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDAO;

    public void init() {
    	itemDAO = new ItemDAOimpl();
    	
    	
    	
    	
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getServletPath();
		
		switch(action) {
		
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			insertNewItem(request,response);
			break;
		case "/delete":
			break;
		case "/edit":
			break;
		case "/update":
			break;
		default:
			listItem(request,response);
			break;
		
		
		}	
	}
	private void listItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Item> listitem = itemDAO.ListAllItem();
		request.setAttribute("listItem", listitem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-list.jsp");
		dispatcher.forward(request, response);
		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-form.jsp");
		dispatcher.forward(request, response);
		
	}
	private void insertNewItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		byte[] itemPhoto = null;
		double itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		Timestamp itemDate = null;
		String itemLocation = request.getParameter("itemLocation");
		int itemBrand = Integer.parseInt(request.getParameter("itemBrand"));
		int itemCategory = Integer.parseInt(request.getParameter("itemCategory"));
		String itemInfo = request.getParameter("itemInfo");
		int itemCoupon = Integer.parseInt(request.getParameter("itemCoupon"));
		int itemAd = Integer.parseInt(request.getParameter("itemAd"));
		
		Item newitem = new Item(itemId,itemName,itemPhoto,itemPrice,itemDate,itemLocation,itemBrand,itemCategory,itemInfo,itemCoupon,itemAd);
		itemDAO.insertItem(newitem);
		response.sendRedirect("list");
		
		
		
	}


}
