package com.controller.productdetail;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.config.ResponseWrapper;
import com.controller.product.ProductController;
import com.model.product.ProductDTO;
import com.model.productdetail.ProductDetailDTO;
import com.service.product.ProductService;
import com.service.productdetail.ProductDetailService;

@Controller
@RequestMapping(path = "/product")
public class ProductDetailController {

	public static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDetailService productDetailService;

	// TODO Create ProductDetailRequest
	@RequestMapping(path = "/{id}/detail/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> addProductDetail(@PathVariable(value = "id") String id,
			@RequestBody ProductDetailDTO productDetail, HttpServletRequest httpRequest) {

		String urlParams = "/{id}" + "/detail" + "/add?" + "address=" + productDetail.getAddress() + "&rating="
				+ productDetail.getRating() + "&sleeps=" + productDetail.getSleeps() + "&bedrooms="
				+ productDetail.getBedrooms() + "&barthrooms=" + productDetail.getBathrooms() + "&description="
				+ productDetail.getDescription() + "&amanities=" + productDetail.getAmanities() + "&reviews="
				+ productDetail.getReviews() + "&images=" + productDetail.getImages();

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();
		responseWrapper.setUrlParams(urlParams);

		ProductDTO product = productService.getProductById(id);

		if (product != null) {
			if (product.getProductDetail() == null) {
				product.setProductDetail(productDetail);
				productService.updateProduct(product);

				responseWrapper.setData(product);
				responseWrapper.setStatus(HttpStatus.OK);
				LOGGER.info("Product retrieved : " + product.toString());
			} else {
				responseWrapper.setData(product);
				responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
				responseWrapper.setError("Product already contains details for id: " + id);
				LOGGER.info("Product Detail already exists! Product retrieved : " + product.toString());
			}

		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	@GetMapping(path = "/{id}/detail", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDetailDTO> getProductDetailByProductId(
			@PathVariable(value = "id") String id) {

		String urlParams = "/" + id + "/detail";

		ProductDTO product = productService.getProductById(id);

		ResponseWrapper<ProductDetailDTO> responseWrapper = new ResponseWrapper<ProductDetailDTO>();
		responseWrapper.setUrlParams(urlParams);

		if (product != null) {
			if (product.getProductDetail() != null) {
				responseWrapper.setData(product.getProductDetail());
				responseWrapper.setStatus(HttpStatus.OK);
				LOGGER.info("Product detail retrieved : " + product.getProductDetail().toString());
			} else {
				responseWrapper.setData(null);
				responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
				responseWrapper.setError("Product detail not found for product with id: " + id);
				LOGGER.info("Product Detail not found! Product retrieved : " + product.toString());
			}
		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	@RequestMapping(path = "/{id}/detail/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> deleteProductDetail(@PathVariable(value = "id") String id) {

		String urlParams = "/" + id + "/detail" + "/delete";

		ProductDTO product = productService.getProductById(id);

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();
		responseWrapper.setUrlParams(urlParams);

		if (product != null) {
			if (product.getProductDetail() != null) {
				productDetailService.deleteProductDetail(product.getProductDetail());
				product.setProductDetail(null);
				productService.updateProduct(product);

				responseWrapper.setData(product);
				responseWrapper.setStatus(HttpStatus.OK);
				LOGGER.info("Product detail removed : " + product.toString());
			} else {
				responseWrapper.setData(product);
				responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
				responseWrapper.setError("Product detail not found for product with id: " + id);
				LOGGER.info("Product Detail not found! Product retrieved : " + product.toString());
			}
		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	@RequestMapping(path = "/{id}/detail/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper<ProductDTO> updateProductDetail(@PathVariable(value = "id") String id,
			@RequestBody ProductDetailDTO productDetail, HttpServletRequest httpRequest) {

		String urlParams = "/" + id + "/detail" + "?" + "address=" + productDetail.getAddress() + "&rating="
				+ productDetail.getRating() + "&sleeps=" + productDetail.getSleeps() + "&bedrooms="
				+ productDetail.getBedrooms() + "&barthrooms=" + productDetail.getBathrooms() + "&description="
				+ productDetail.getDescription() + "&amanities=" + productDetail.getAmanities() + "&reviews="
				+ productDetail.getReviews() + "&images=" + productDetail.getImages();

		ProductDTO product = productService.getProductById(id);

		ResponseWrapper<ProductDTO> responseWrapper = new ResponseWrapper<ProductDTO>();
		responseWrapper.setUrlParams(urlParams);

		if (product != null) {
			if (product.getProductDetail() != null) {
				ProductDetailDTO existingProductDetail = updateProductDetailFromParams(productDetail, product);
				product.setProductDetail(existingProductDetail);
				productService.updateProduct(product);

				responseWrapper.setData(product);
				responseWrapper.setStatus(HttpStatus.OK);
				LOGGER.info("Product detail updated : " + product.toString());
			} else {
				responseWrapper.setData(product);
				responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
				responseWrapper.setError("Product detail not found for product with id: " + id);
				LOGGER.info("Product Detail not found! Product retrieved : " + product.toString());
			}
		} else {
			responseWrapper.setData(null);
			responseWrapper.setStatus(HttpStatus.BAD_REQUEST);
			responseWrapper.setError("Product not found for id: " + id);
			LOGGER.info("Product not found for id: " + id);
		}

		return responseWrapper;
	}

	private ProductDetailDTO updateProductDetailFromParams(ProductDetailDTO productDetail, ProductDTO product) {
		ProductDetailDTO existingProductDetail = product.getProductDetail();
		if (productDetail.getAddress() != null) {
			existingProductDetail.setAddress(productDetail.getAddress());
		}
		if (productDetail.getRating() != null) {
			existingProductDetail.setRating(productDetail.getRating());
		}
		if (productDetail.getSleeps() != null) {
			existingProductDetail.setSleeps(productDetail.getSleeps());
		}
		if (productDetail.getBedrooms() != null) {
			existingProductDetail.setBedrooms(productDetail.getBedrooms());
		}
		if (productDetail.getBathrooms() != null) {
			existingProductDetail.setBathrooms(productDetail.getBathrooms());
		}
		if (productDetail.getDescription() != null) {
			existingProductDetail.setDescription(productDetail.getDescription());
		}
		if (productDetail.getAmanities() != null) {
			existingProductDetail.setAmanities(productDetail.getAmanities());
		}
		if (productDetail.getReviews() != null) {
			existingProductDetail.setReviews(productDetail.getReviews());
		}
		if (productDetail.getImages() != null) {
			existingProductDetail.setImages(productDetail.getImages());
		}
		return existingProductDetail;
	}
}
