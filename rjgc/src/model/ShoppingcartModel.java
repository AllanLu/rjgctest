package model;

public class ShoppingcartModel {
    private int Buyerid;
    private int Productid;
    private int Productnum;
    private float Productprice;
    
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
}
