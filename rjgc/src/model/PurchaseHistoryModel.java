package model;

public class PurchaseHistoryModel {
	//列出类中的成员变量
	//参照UserModel类，为类的每个成员变量定义get和set方法
	private int Orderid;
	public int getOrderid() {
		return Orderid;
	}
	public void setOrderid(int orderid) {
		Orderid = orderid;
	}
	public String getBuyerid() {
		return Buyerid;
	}
	public void setBuyerid(String buyerid) {
		Buyerid = buyerid;
	}
	public String getBuyername() {
		return Buyername;
	}
	public void setBuyername(String buyername) {
		Buyername = buyername;
	}
	public String getProductid() {
		return Productid;
	}
	public void setProductid(String productid) {
		Productid = productid;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getPurchasedate() {
		return Purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		Purchasedate = purchasedate;
	}
	public String getServicedate() {
		return Servicedate;
	}
	public void setServicedate(String servicedate) {
		Servicedate = servicedate;
	}
	public int getPurchasenum() {
		return Purchasenum;
	}
	public void setPurchasenum(int purchasenum) {
		Purchasenum = purchasenum;
	}
	public String getDeliveryaddress() {
		return Deliveryaddress;
	}
	public void setDeliveryaddress(String deliveryaddress) {
		Deliveryaddress = deliveryaddress;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	private String Buyerid ;
	private String Buyername ;
	private String Productid ;
	private String Productname ;
	private String Purchasedate ;
	private String Servicedate ;
	private int Purchasenum ;
	private String Deliveryaddress ;
	private float Price ;

}
