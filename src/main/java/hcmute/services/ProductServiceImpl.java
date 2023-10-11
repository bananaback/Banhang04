package hcmute.services;

import java.util.List;

import hcmute.models.ProductModel;

import hcmute.DAO.*;

public class ProductServiceImpl implements IProductService{

	IProductDAO productDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}
	@Override
	public List<ProductModel> findProductsByCategory(String categoryId) {
		return productDAO.findProductsByCategory(categoryId);
	}

}
