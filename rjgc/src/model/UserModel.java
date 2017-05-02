package model;

public class UserModel {
	private int Buyerid;
	private String Buyername;
	private String Buyertel;
	private String Buyeraddress;
	private String Realname;
//	private String Buyerregion;
    private String BuyerPassword;
    
    public int getId() {
        return Buyerid;
    }
    public void setId(int Buyerid) {
        this.Buyerid = Buyerid;
    }
    
	public String getName() {
        return Buyername;
    }
    public void setName(String Buyername) {
        this.Buyername = Buyername;
    }
    
    public String getTel() {
        return Buyertel;
    }
    public void setTel(String Buyertel) {
        this.Buyertel = Buyertel;
    }
    
    public String getAddress() {
        return Buyeraddress;
    }
    public void setAddress(String Buyeraddress) {
        this.Buyeraddress = Buyeraddress;
    }
    
    public String getRealName() {
        return Realname;
    }
    public void setRealName(String Realname) {
        this.Realname = Realname;
    }
    
  /*  public String getRegion() {
        return Buyerregion;
    }
    public void setRegion(String Buyerregion) {
        this.Buyerregion = Buyerregion;
    }
    */
    public String getPassword() {
        return BuyerPassword;
    }
    public void setPassword(String BuyerPassword) {
        this.BuyerPassword = BuyerPassword;
    }
}