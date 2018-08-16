package com.config;

import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.product.ProductDAO;
import com.model.amanity.AmanityEntity;
import com.model.amanity.AmanityTypeEntity;
import com.model.image.ImageEntity;
import com.model.product.ProductDTO;
import com.model.product.ProductEntity;
import com.model.product.ProductMapper;
import com.model.product.ProductTypeEntity;
import com.model.productdetail.ProductDetailEntity;
import com.model.review.RatingTypeEntity;
import com.model.review.ReviewEntity;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductMapper productMapper;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

//		User n = new User();
//		n.setName(name);
//		n.setEmail(email);
//		userRepository.save(n);
		ReviewEntity review = new ReviewEntity();
		review.setDate(Calendar.getInstance().getTime());
		review.setName("test review name");
		review.setRating(RatingTypeEntity.FOUR);
		review.setText("test review text");
		
		AmanityEntity amanity = new AmanityEntity();
		amanity.setName(AmanityTypeEntity.COFFEE_MAKER);
		
		ImageEntity image = new ImageEntity();
		byte[] bytes = new byte[3];
		new Random().nextBytes(bytes);
		image.setPicture(bytes);
		
		ProductDetailEntity productDetail = new ProductDetailEntity();
		productDetail.setAddress("test address");
		productDetail.setDescription("test description");
		productDetail.setRating(new Double(3));
		productDetail.setSleeps(3);
		productDetail.setBathrooms(3);
		productDetail.setBedrooms(3);
		productDetail.addReview(review);
		productDetail.addAmanity(amanity);
		productDetail.addImages(image);
		
		ProductEntity product = new ProductEntity();
		product.setArea(2);
		product.setLocation("test product location");
		product.setName("test product name");
		product.setPrice(2L);
		product.setType(ProductTypeEntity.APARTAMENT);
		product.setImage(bytes);
		product.setProductDetail(productDetail);
		
		productDAO.save(product);
		
		return "Product Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<ProductDTO> getAllUsers() {
		return productMapper.mapEntitiesToDto(productDAO.findAll());
	}
}
