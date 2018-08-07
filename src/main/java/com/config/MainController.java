package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.product.ProductDAO;
import com.model.product.ProductDTO;
import com.model.product.ProductEntity;
import com.model.product.ProductMapper;
import com.model.product.ProductTypeDTO;

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
		ProductDTO x = new ProductDTO();
		x.setName("TestName");
		x.setPrice(200L);
		x.setType(ProductTypeDTO.HOUSE);
		x.setArea(300);
		x.setLocation("TestLocation");
		
		productDAO.save(productMapper.mapDtoToEntity(x));
		
		return "Product Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<ProductEntity> getAllUsers() {
		return productDAO.findAll();
	}
}
