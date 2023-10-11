package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.ProductModel;
import hcmute.services.*;

@WebServlet(urlPatterns = {"/listproduct"})
public class ProductController extends HttpServlet {
	IProductService productService = new ProductServiceImpl();
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		
		if (url.contains("listproduct")) {
			String categoryID = req.getParameter("categoryId");
			if (categoryID != null) {
				findAllByCategory(req, resp);
			} else {
				findAll(req, resp);
			}
		}
		
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		// Get the list of products from the ProductService
	    List<ProductModel> productList = productService.findAll();

	    // Prepare a StringBuilder to manually create JSON
	    StringBuilder jsonBuilder = new StringBuilder();
	    jsonBuilder.append("[");
	    
	    // Loop through the product list and append each product as a JSON object
	    for (ProductModel product : productList) {
	    	jsonBuilder.append("{");
	        jsonBuilder.append("\"productId\":\"").append(product.getProductID()).append("\",");
	        jsonBuilder.append("\"productName\":\"").append(product.getProductName()).append("\",");
	        jsonBuilder.append("\"description\":\"").append(product.getDescription()).append("\",");
	        jsonBuilder.append("\"price\":").append(product.getPrice()).append(",");
	        jsonBuilder.append("\"imageLink\":\"").append(product.getImageLink()).append("\",");
	        jsonBuilder.append("\"categoryID\":").append(product.getCategoryID()).append(",");
	        jsonBuilder.append("\"sellerID\":").append(product.getSellerID()).append(",");
	        jsonBuilder.append("\"amount\":").append(product.getAmount()).append(",");
	        jsonBuilder.append("\"stoke\":").append(product.getStoke());
	        // Add other fields as needed
	        jsonBuilder.append("},");
	    }

	    // Remove the trailing comma if there are products in the list
	    if (!productList.isEmpty()) {
	        jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
	    }

	    jsonBuilder.append("]");

	    // Set the response content type to JSON
	    resp.setContentType("application/json");

	    // Write the JSON data to the response output stream
	    resp.getWriter().write(jsonBuilder.toString());*/
		List<ProductModel> listproduct = productService.findAll();

		// day du lieu ra view
		req.setAttribute("list", listproduct);

		// view nhận dữ liệu

		RequestDispatcher rd = req.getRequestDispatcher("/views/listProduct.jsp");
		rd.forward(req, resp);
	}
	private void findAllByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryID = req.getParameter("categoryId");
		List<ProductModel> listproduct = productService.findProductsByCategory(categoryID);

		// day du lieu ra view
		req.setAttribute("list", listproduct);

		// view nhận dữ liệu

		RequestDispatcher rd = req.getRequestDispatcher("/views/listProduct.jsp");
		rd.forward(req, resp);
	}
}
