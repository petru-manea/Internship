package com.controller.product;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.config.ResponseWrapper;
import com.model.product.ProductDTO;
import com.model.product.ProductTypeDTO;
import com.service.product.ProductService;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

	public static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> addProduct(@RequestParam String name, @RequestParam Long price,
			@RequestParam ProductTypeDTO type, @RequestParam Integer area, @RequestParam String location, byte[] image,
			HttpServletRequest httpRequest) {

		String urlParams = "/add?" + "name=" + name + "&price=" + price + "&type=" + type.getName() + "&area=" + area
				+ "&location=" + location + "&image=" + image;

		ProductDTO product = constructProductFromParams(name, price, type, area, location, image);

		productService.addProduct(product);

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();

		responseWrapper.setData(product);
		responseWrapper.setStatus(HttpStatus.OK);
		responseWrapper.setUrlParams(urlParams);

		LOGGER.info("Succesfully created product : " + product.toString());

		return responseWrapper;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> getProductById(@PathVariable(value = "id") Integer id) {

		String urlParams = "/" + id;

		ProductDTO product = productService.getProductById(id);

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();
		responseWrapper.setUrlParams(urlParams);

		if (product != null) {
			responseWrapper.setData(product);
			responseWrapper.setStatus(HttpStatus.OK);
			LOGGER.info("Product retrieved : " + product.toString());
		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	@RequestMapping(path = "/{id}/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> updateProduct(@PathVariable(value = "id") String id, String name, Long price,
			ProductTypeDTO type, Integer area, String location, byte[] image, HttpServletRequest httpRequest) {

		String urlParams = "/" + id + "?" + "name=" + name + "&price=" + price + "&type=" + type.getName() + "&area="
				+ area + "&location=" + location + "&image=" + image;

		ProductDTO product = productService.getProductById(id);

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();
		responseWrapper.setUrlParams(urlParams);

		if (product != null) {

			updateProductByParams(name, price, type, area, location, image, product);

			productService.updateProduct(product);

			responseWrapper.setData(product);
			responseWrapper.setStatus(HttpStatus.OK);
			LOGGER.info("Product updated : " + product.toString());
		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	@RequestMapping(path = "/{id}/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> deleteProduct(@PathVariable(value = "id") String id) {

		String urlParams = "/" + id + "/delete";

		ProductDTO product = productService.getProductById(id);

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();
		responseWrapper.setUrlParams(urlParams);

		if (product != null) {

			productService.deleteProduct(product);

			responseWrapper.setStatus(HttpStatus.OK);
			LOGGER.info("Product deleted : " + product.toString());
		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	private ProductDTO constructProductFromParams(String name, Long price, ProductTypeDTO type, Integer area,
			String location, byte[] image) {
		ProductDTO product = new ProductDTO();
		product.setName(name);
		product.setPrice(price);
		product.setType(type);
		product.setArea(area);
		product.setLocation(location);
		product.setImage(image);
		return product;
	}

	private void updateProductByParams(String name, Long price, ProductTypeDTO type, Integer area, String location,
			byte[] image, ProductDTO product) {
		if (name != null) {
			product.setName(name);
		}
		if (price != null) {
			product.setPrice(price);
		}
		if (type != null) {
			product.setType(type);
		}
		if (area != null) {
			product.setArea(area);
		}
		if (location != null) {
			product.setLocation(location);
		}
		if (image != null) {
			product.setImage(image);
		}
	}
}
