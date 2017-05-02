package model;

public class ProductModel {
	//列出类中的成员变量
	//参照UserModel类，为类的每个成员变量定义get和set方法
	private int Productid;
	private String Productname ;
	private String Productorigin ;
	private String Productdate ;
	private String Productlife;
	private String Productintroduction ;
	private float Productprice ;
	private String Supplierid;
	private int Stocknum ;
	private String Storedid ;
	private String Image;
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getProductid() {
		return Productid;
	}
	public void setProductid(int productid) {
		Productid = productid;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getProductorigin() {
		return Productorigin;
	}
	public void setProductorigin(String productorigin) {
		Productorigin = productorigin;
	}
	public String getProductdate() {
		return Productdate;
	}
	public void setProductdate(String productdate) {
		Productdate = productdate;
	}
	public String getProductlife() {
		return Productlife;
	}
	public void setProductlife(String productlife) {
		Productlife = productlife;
	}
	public String getProductintroduction() {
		return Productintroduction;
	}
	public void setProductintroduction(String productintroduction) {
		Productintroduction = productintroduction;
	}
	public float getProductprice() {
		return Productprice;
	}
	public void setProductprice(float productprice) {
		Productprice = productprice;
	}
	public String getSupplierid() {
		return Supplierid;
	}
	public void setSupplierid(String supplierid) {
		Supplierid = supplierid;
	}
	public int getStocknum() {
		return Stocknum;
	}
	public void setStocknum(int stocknum) {
		Stocknum = stocknum;
	}
	public String getStoredid() {
		return Storedid;
	}
	public void setStoredid(String storedid) {
		Storedid = storedid;
	}
}