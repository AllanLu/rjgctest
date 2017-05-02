package model;

public class WarehouseModel {
	//列出类中的成员变量
	//参照UserModel类，为类的每个成员变量定义get和set方法
	private int Storedid ;
	private String Productid ;
	private int Productnum;
	private String Storename;
	private String Storeaddress;
	public int getStoredid() {
		return Storedid;
	}
	public void setStoredid(int storedid) {
		Storedid = storedid;
	}
	public String getProductid() {
		return Productid;
	}
	public void setProductid(String productid) {
		Productid = productid;
	}
	public int getProductnum() {
		return Productnum;
	}
	public void setProductnum(int productnum) {
		Productnum = productnum;
	}
	public String getStorename() {
		return Storename;
	}
	public void setStorename(String storename) {
		Storename = storename;
	}
	public String getStoreaddress() {
		return Storeaddress;
	}
	public void setStoreaddress(String storeaddress) {
		Storeaddress = storeaddress;
	}
}
