package itemDAO;

import java.util.List;

import javaBean.Item;

public interface ItemDAO {
	
	Item findItemById(int id);
	List<Item> ListAllItem();
	Item findItemByName(String name);
	
	boolean insertItem(Item item);
    //u
    boolean updateItem(Item item);
    //d
    boolean deleItemById(int id);
	
	
}
