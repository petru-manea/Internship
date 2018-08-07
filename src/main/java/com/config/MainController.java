package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.product.ProductDAO;
import com.model.product.ProductEntity;
import com.model.product.ProductTypeEntity;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	
	@Autowired
	private ProductDAO productDAO;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

//		User n = new User();
//		n.setName(name);
//		n.setEmail(email);
//		userRepository.save(n);
		ProductEntity entity = new ProductEntity();
		entity.setName("TestName");
		entity.setPrice(200L);
		entity.setType(ProductTypeEntity.HOUSE);
		entity.setArea(300);
		entity.setLocation("TestLocation");
		
		productDAO.save(entity);
		
		return "Product Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<ProductEntity> getAllUsers() {
		return productDAO.findAll();
	}
}
