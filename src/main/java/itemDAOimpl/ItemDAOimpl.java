package itemDAOimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import itemDAO.ItemDAO;
import javaBean.Item;
import util.ConnUtil;

public class ItemDAOimpl implements ItemDAO{

	@Override
	public Item findItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> ListAllItem() {
        String sql="select * from item ";
        List<Item> list = new ArrayList<>();
        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { 
            	Item item = new Item();
            	item.setItemId(rs.getInt("itemId"));
            	item.setItemName(rs.getString("itemName"));
            	item.setItemPhoto(rs.getBytes("itemPhoto"));
            	item.setItemPrice(rs.getInt("itemPrice"));
            	item.setItemDate(rs.getTimestamp("itemDate"));
            	item.setItemLocation(rs.getString("itemLocation"));
                item.setItemBrand(rs.getInt("itemBrand"));
                item.setItemCategory(rs.getInt("itemCategory"));
                item.setItemInfo(rs.getString("itemInfo"));
                item.setItemCoupon(rs.getInt("itemCoupon"));
                item.setItemAd(rs.getInt("itemAd"));
            	list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public Item findItemByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertItem(Item item) {
        String sql="insert into item values(?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, item.getItemId());
            pstmt.setString(2, item.getItemName());
            pstmt.setBytes(3, item.getItemPhoto());
            pstmt.setDouble(4, item.getItemPrice());
            pstmt.setTimestamp(5, item.getItemDate());
            pstmt.setString(6, item.getItemLocation());
            pstmt.setInt(7, item.getItemBrand());
            pstmt.setInt(8,item.getItemCategory());
            pstmt.setString(9,item.getItemInfo());
            pstmt.setInt(10,item.getItemCoupon());
            pstmt.setInt(11,item.getItemAd());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
