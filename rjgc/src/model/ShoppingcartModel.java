package model;

public class ShoppingcartModel {
    private int Buyerid;
    private int Productid;
    private int Productnum;
    private float Productprice;
    private String Buyername;
    public int getBuyerid() {
		return Buyerid;
	}
	public void setBuyerid(int buyerid) {
		Buyerid = buyerid;
	}
    
    
    public int getProductid() {
		return Productid;
	}
	public void setProductid(int productid) {
		Productid = productid;
	}
	
	public int getProductnum() {
		return Productnum;
	}
	public void setProductnum(int productnum) {
		Productnum = productnum;
	}
    
	public float getProductprice() {
		return Productprice;
	}
	public void setProductprice(float productprice) {
		Productprice = productprice;
	}
	
	public String getBuyername(){
		return Buyername;
		
	}
	public void setBuyername(String buyername) {
		Buyername = buyername;
	}
	
	
}
