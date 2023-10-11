package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModels;
import hcmute.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {

	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	@Override
	public List<ProductModel> findAll() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product";
		try {
			// Kết nối dữ liệu
			conn = new DBConnectionSQLServer().getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				
				product.setProductID(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getInt("Price"));
				product.setImageLink(rs.getString("imageLink"));
				product.setCategoryID(rs.getInt("CategoryID"));
				product.setSellerID(rs.getInt("SellerID"));
				product.setAmount(rs.getInt("Amount"));
				product.setStoke(rs.getInt("stoke"));
				
				products.add(product);
				
				
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public List<ProductModel> findProductsByCategory(String categoryId) {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product WHERE CategoryID = '" + categoryId + "'";
		try {
			// Kết nối dữ liệu
			conn = new DBConnectionSQLServer().getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				
				product.setProductID(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getInt("Price"));
				product.setImageLink(rs.getString("imageLink"));
				product.setCategoryID(rs.getInt("CategoryID"));
				product.setSellerID(rs.getInt("SellerID"));
				product.setAmount(rs.getInt("Amount"));
				product.setStoke(rs.getInt("stoke"));
				
				products.add(product);
				
				
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

}
