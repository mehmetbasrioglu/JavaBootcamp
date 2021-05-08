package kodlamaio.northwind.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	@GetMapping("/getall")
	public List<Product> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/findbyid/{id}")
	@ResponseBody
	public Optional<Product> findById(@PathVariable Integer id) {
	    return this.productService.findById(id);
		
	}
	
	@GetMapping("/getbycategoryid/{id}")
	@ResponseBody
	public Optional<Product> findByCategoryId(@PathVariable Integer id) {
	    return this.productService.findByCategoryId(id);
		
	}



}
