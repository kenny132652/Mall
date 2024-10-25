package itemServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javaBean.Item;
import itemDAO.ItemDAO;
import itemDAOimpl.ItemDAOimpl;

/**
 * Servlet implementation class itemServlet
 */
@WebServlet("/")
public class itemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDAO;

    public void init() throws UnavailableException {
    	itemDAO = new ItemDAOimpl();
    	
    	try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new UnavailableException("Failed to load SQLServer JDBC Driver.");
        }
    	
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
			deleteUser(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateItem(request, response);
			break;
		default:
			listItem(request,response);
			break;
		
		
		}	
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
		itemDAO.deleItemById(itemId);
		response.sendRedirect("list");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        Item existingItem = itemDAO.findItemById(itemId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("item-form.jsp");
        request.setAttribute("item", existingItem);
        dispatcher.forward(request, response);
	}
	private void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		byte[] itemPhoto = null;
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		Timestamp itemDate = new Timestamp(System.currentTimeMillis());
		String itemLocation = request.getParameter("itemLocation");
		int itemBrand = Integer.parseInt(request.getParameter("itemBrand"));
		int itemCategory = Integer.parseInt(request.getParameter("itemCategory"));
		String itemInfo = request.getParameter("itemInfo");
		int itemCoupon = Integer.parseInt(request.getParameter("itemCoupon"));
		int itemAd = Integer.parseInt(request.getParameter("itemAd"));
		
        Item editItem = new Item(itemId,itemName,itemPhoto,itemPrice,itemDate,itemLocation,itemBrand,itemCategory,itemInfo,itemCoupon,itemAd);
        itemDAO.updateItem(editItem);
        response.sendRedirect("list");
	}
	private void listItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Item> listItem = itemDAO.ListAllItem();
		request.setAttribute("Items", listItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-list.jsp");
		dispatcher.forward(request, response);
		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-form.jsp");
		dispatcher.forward(request, response);
		
	}
	private void insertNewItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String itemName = request.getParameter("itemName");
		byte[] itemPhoto = null;
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		Timestamp itemDate = new Timestamp(System.currentTimeMillis());
		String itemLocation = request.getParameter("itemLocation");
		int itemBrand = Integer.parseInt(request.getParameter("itemBrand"));
		int itemCategory = Integer.parseInt(request.getParameter("itemCategory"));
		String itemInfo = request.getParameter("itemInfo");
		int itemCoupon = Integer.parseInt(request.getParameter("itemCoupon"));
		int itemAd = Integer.parseInt(request.getParameter("itemAd"));
		
		Item newitem = new Item(itemName,itemPhoto,itemPrice,itemDate,itemLocation,itemBrand,itemCategory,itemInfo,itemCoupon,itemAd);
		itemDAO.insertItem(newitem);
		response.sendRedirect("list");
		
		
		
	}


}
