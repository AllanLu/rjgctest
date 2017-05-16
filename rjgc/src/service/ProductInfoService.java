package service;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import dao.*;

public class ProductInfoService {
	java.sql.Connection conn0;
	/**
	 * 鍚戞暟鎹簱涓坊鍔犲晢鍝佷俊鎭�
	 * @param pModel
	 * @return
	 */
	public int addProductToProduct(ProductModel pModel){
		java.sql.Connection conn =null;
		conn=GetConnection.getConnection();
		String productName=pModel.getProductname();
		String origin=pModel.getProductorigin();
		String pdate=pModel.getProductdate();
		String life=pModel.getProductlife();
		float price=pModel.getProductprice();
		String introduction=pModel.getProductintroduction();
		int storedid=Integer.parseInt(pModel.getStoredid());
		int stockNum=pModel.getStocknum();
		int sid=Integer.parseInt(pModel.getSupplierid());
		String image=pModel.getImagepath();
		String sql="insert into product(Productname,Productorigin,Productdate,Productlife,Productintrodution,Productprice,Supplierid,Stocknum,Storedid,image)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,productName);
			ps.setString(2, origin);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date=sdf.parse(pdate);
			java.util.Date lifedate=sdf.parse(life);
			Timestamp tdate=new Timestamp(date.getTime());
			Timestamp tlife=new Timestamp(lifedate.getTime());
			ps.setTimestamp(3, tdate);
			ps.setTimestamp(4, tlife);
			ps.setString(5, introduction);
			ps.setFloat(6, price);
			ps.setInt(7, sid);
			ps.setInt(8, stockNum);
			ps.setString(9,storedid+"");
			ps.setString(10, image);
			ps.execute();
			conn.close();
			ps.close();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public ProductModel modifyProduct(ProductModel pModel){
		java.sql.Connection conn =null;
		//鑾峰緱鏁版嵁搴撹繛鎺�
		conn=GetConnection.getConnection();
		//鎻愬彇sid
		int pid=pModel.getProductid();
		String pname=null;
		String orgin=null;
		String date=null;
		String life=null;
		float price=0;
		int stockNum=0;
		String intro=null;
		String storeid=null;
		String image=null;
		String sql="select * from product where Productid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rst=ps.executeQuery();
			if(!rst.next()){
				return null;
			}else{
				pname=rst.getString(2);
				orgin=rst.getString(3);
				date=rst.getString(4);
				life=rst.getString(5);
				intro=rst.getString(6);
				price=rst.getFloat(7);
				stockNum=rst.getInt(9);
				storeid=rst.getString(10);
				image=rst.getString(11);
			}
			if(pModel.getProductname()!=""){
				pname=pModel.getProductname();
			}
			if(pModel.getImagepath()!=null){
				image=pModel.getImagepath();
			}
			orgin=pModel.getProductorigin();
			date=pModel.getProductdate();
			life=pModel.getProductlife();
			intro=pModel.getProductintroduction();
			price=pModel.getProductprice();
			stockNum=pModel.getStocknum();
			storeid=pModel.getStoredid();
			
			sql="update product set Productname=?,Productorgin=?,Productdate=?,Productlife=?,Productintroduction=?,Productprice=?,Stocknum=?,Storedid=?,Imagepath=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,pname);
			ps.setString(2,orgin);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date pdate=sdf.parse(date);
			java.util.Date lifedate=sdf.parse(life);
			Timestamp tdate=new Timestamp(pdate.getTime());
			Timestamp tlife=new Timestamp(lifedate.getTime());
			ps.setTimestamp(3, tdate);
			ps.setTimestamp(4, tlife);
			ps.setString(5, intro);
			ps.setFloat(6, price);
			ps.setInt(7, stockNum);
			ps.setString(8,storeid);
			ps.setString(9, image);
			ps.execute();
			conn.close();
			ps.close();
			
			pModel.setProductname(pname);
			pModel.setImagepath(image);
			
			return pModel;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ProductModel getProduct(int Productid) throws SQLException{
		ProductModel product = new ProductModel();	
		ProductDao pd=new ProductDao();
		product.setProductid(Productid);
		product=pd.getProductByProductid(Productid);
		//灏哖roductid鍐欏埌product涓紝骞惰皟鐢╣etProductByProductid(ProductModel product)鏂规硶鑾峰彇瀹屾暣浜у搧淇℃伅
		return product;
	}

	//根据username  查询购物车
	public List<ShoppingcartModel> getProductList(int Userid){

		String sql="";
		List<ShoppingcartModel> shoppingcartlist = new ArrayList<ShoppingcartModel>();
		conn0=GetConnection.getConnection();
		try{
			sql="select * from Shoppingcart where Buyerid=?";
			PreparedStatement pstmt=conn0.prepareStatement(sql);
			pstmt.setInt(1, Userid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ShoppingcartModel shopping=new ShoppingcartModel();
				shopping.setBuyerid(rs.getInt("Buyerid"));
				shopping.setProductid(rs.getInt("Productid"));
				shopping.setProductnum(rs.getInt("Productnum"));
				shopping.setProductprice(rs.getFloat("Productprice"));
				shopping.setShoppingcartid(rs.getInt("Shoppingcartid"));
				shoppingcartlist.add(shopping);
				
			}
			if(!shoppingcartlist.isEmpty()){
				return shoppingcartlist;
				//request.getSession().setAttribute("productList",productList);
				//response.sendRedirect("/rjgc/jsp/index.jsp");
			}
			rs.close();
			pstmt.close();
			conn0.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
		}
	
	public ArrayList<ShoppingcartModel> Getall(){
		String sql="";
		conn0=GetConnection.getConnection();
		ArrayList<ShoppingcartModel> shoppingcartList=null;
		shoppingcartList=new ArrayList<ShoppingcartModel>();
		try{
			sql="select * from Shoppingcart";
			PreparedStatement pstmt=conn0.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ShoppingcartModel shopping=new ShoppingcartModel();
				shopping.setBuyerid(rs.getInt("Buyerid"));
				shopping.setProductid(rs.getInt("Productid"));
				shopping.setProductnum(rs.getInt("Productnum"));
				shopping.setShoppingcartid(rs.getInt("Shoppingcartid"));
				shoppingcartList.add(shopping);
			}
			if(!shoppingcartList.isEmpty()){
				return shoppingcartList;
				//request.getSession().setAttribute("productList",productList);
				//response.sendRedirect("/rjgc/jsp/index.jsp");
			} 
			//else {return shoppingcartList;}
			rs.close();
			pstmt.close();
			conn0.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
		}


		//获取购物车列表
		
	public  void Dropshoppingcart(int Shoppingcartid){
		String sql="";
		//List<ShoppingcartModel> shoppingcartlist = new ArrayList<ShoppingcartModel>();
		conn0=GetConnection.getConnection();
		try{
			sql="delete from rjgc.Shoppingcart where Shoppingcartid = 1";
			PreparedStatement pstmt=conn0.prepareStatement(sql);
			//pstmt.setInt(1,Shoppingcartid);
			pstmt.executeUpdate(sql);
			//rs.close();
			pstmt.close();
			conn0.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		}

}
