package model;

public class SupplierModel {
	//列出类中的成员变量
	//参照UserModel类，为类的每个成员变量定义get和set方法
	private int Supplierid ;
	private String Suppliername;
	private String Suppliertel;
	private String Supplieraddress;
	private String Supplierintroduction;
	private String SupplierPassword;
	public int getSupplierid() {
		return Supplierid;
	}
	public void setSupplierid(int supplierid) {
		Supplierid = supplierid;
	}
	public String getSuppliername() {
		return Suppliername;
	}
	public void setSuppliername(String suppliername) {
		Suppliername = suppliername;
	}
	public String getSuppliertel() {
		return Suppliertel;
	}
	public void setSuppliertel(String suppliertel) {
		Suppliertel = suppliertel;
	}
	public String getSupplieraddress() {
		return Supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		Supplieraddress = supplieraddress;
	}
	public String getSupplierintroduction() {
		return Supplierintroduction;
	}
	public void setSupplierintroduction(String supplierintroduction) {
		Supplierintroduction = supplierintroduction;
	}
	public String getSupplierPassword() {
		return SupplierPassword;
	}
	public void setSupplierPassword(String supplierPassword) {
		SupplierPassword = supplierPassword;
	}

}
