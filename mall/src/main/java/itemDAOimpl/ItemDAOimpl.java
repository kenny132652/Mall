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
        String sql = "select * from item where itemId = ?";
        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
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
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String sql = "select * from item where itemName like '%?%'";
        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
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
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public boolean insertItem(Item item) {
        String sql="insert into item (itemName, itemPhoto, itemPrice, itemDate, itemLocation, itemBrand, itemCategory, itemInfo, itemCoupon, itemAd)values(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);



            pstmt.setString(1, item.getItemName());
            pstmt.setBytes(2, item.getItemPhoto());
            pstmt.setInt(3, item.getItemPrice());
            pstmt.setTimestamp(4, item.getItemDate());
            pstmt.setString(5, item.getItemLocation());
            pstmt.setInt(6, item.getItemBrand());
            pstmt.setInt(7,item.getItemCategory());
            pstmt.setString(8,item.getItemInfo());
            pstmt.setInt(9,item.getItemCoupon());
            pstmt.setInt(10,item.getItemAd());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateItem(Item item) {
        String sql = "update item set itemName = ?,itemPhoto = ? ,itemPrice = ?, itemDate = ?,itemLocation = ?,itemBrand = ? ,itemCategory = ? ,itemInfo = ?,itemCoupon = ?,itemAd = ? where itemId = ?";
        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getItemName());
            pstmt.setBytes(2, item.getItemPhoto());
            pstmt.setInt(3, item.getItemPrice());
            pstmt.setTimestamp(4, item.getItemDate());
            pstmt.setString(5, item.getItemLocation());
            pstmt.setInt(6, item.getItemBrand());
            pstmt.setInt(7,item.getItemCategory());
            pstmt.setString(8,item.getItemInfo());
            pstmt.setInt(9,item.getItemCoupon());
            pstmt.setInt(10,item.getItemAd());
            pstmt.setInt(11, item.getItemId());
            pstmt.executeUpdate();
            return true;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean deleItemById(int id) {
		String sql = "delete from item where itemId = ?";
        try (Connection conn = ConnUtil.getconnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
		return false;
		
	}
	
}
