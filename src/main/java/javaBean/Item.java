package javaBean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Item {
	private int itemId;
	private String itemName;
	private byte[] itemPhoto;
	private double itemPrice;
	private Timestamp itemDate;
	private String itemLocation;
	private int itemBrand;
	private int itemCategory;
	private String itemInfo;
	private int itemCoupon;
	private int itemAd;
	
	
	
	public Item(int itemId, String itemName, byte[] itemPhoto, double itemPrice, Timestamp itemDate,
			String itemLocation, int itemBrand, int itemCategory, String itemInfo, int itemCoupon, int itemAd) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPhoto = itemPhoto;
		this.itemPrice = itemPrice;
		this.itemDate = itemDate;
		this.itemLocation = itemLocation;
		this.itemBrand = itemBrand;
		this.itemCategory = itemCategory;
		this.itemInfo = itemInfo;
		this.itemCoupon = itemCoupon;
		this.itemAd = itemAd;
	}
	
	public Item(String itemName, byte[] itemPhoto, double itemPrice, Timestamp itemDate, String itemLocation,
			int itemBrand, int itemCategory, String itemInfo, int itemCoupon, int itemAd) {
		super();
		this.itemName = itemName;
		this.itemPhoto = itemPhoto;
		this.itemPrice = itemPrice;
		this.itemDate = itemDate;
		this.itemLocation = itemLocation;
		this.itemBrand = itemBrand;
		this.itemCategory = itemCategory;
		this.itemInfo = itemInfo;
		this.itemCoupon = itemCoupon;
		this.itemAd = itemAd;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public byte[] getItemPhoto() {
		return itemPhoto;
	}
	public void setItemPhoto(byte[] itemPhoto) {
		this.itemPhoto = itemPhoto;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Timestamp getItemDate() {
		return itemDate;
	}
	public void setItemDate(Timestamp itemDate) {
		this.itemDate = itemDate;
	}
	public String getItemLocation() {
		return itemLocation;
	}
	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}
	public int getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(int itemBrand) {
		this.itemBrand = itemBrand;
	}
	public int getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	public int getItemCoupon() {
		return itemCoupon;
	}
	public void setItemCoupon(int itemCoupon) {
		this.itemCoupon = itemCoupon;
	}
	public int getItemAd() {
		return itemAd;
	}
	public void setItemAd(int itemAd) {
		this.itemAd = itemAd;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPhoto=" + Arrays.toString(itemPhoto)
				+ ", itemPrice=" + itemPrice + ", itemDate=" + itemDate + ", itemLocation=" + itemLocation
				+ ", itemBrand=" + itemBrand + ", itemCategory=" + itemCategory + ", itemInfo=" + itemInfo
				+ ", itemCoupon=" + itemCoupon + ", itemAd=" + itemAd + "]";
	}
	
	
	
	
	
	
}
