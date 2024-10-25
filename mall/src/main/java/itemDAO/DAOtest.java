package itemDAO;

import java.util.List;

import itemDAOimpl.ItemDAOimpl;
import javaBean.Item;

public class DAOtest {
    public static void main(String[] args) {
	ItemDAO itemDAo = new ItemDAOimpl();
	
	List<Item> list = itemDAo.ListAllItem();
    		
    for (Item l  : list) {
        System.out.println(l.toString());
    }
	
    }
}
