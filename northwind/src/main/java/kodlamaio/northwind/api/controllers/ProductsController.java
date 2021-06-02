package kodlamaio.northwind.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

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
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	
	@GetMapping("/getproductwithcategorydetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	
	@GetMapping("/getallbypage")
	public 	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getallbydesc")
	public 	DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	 @PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	 @GetMapping("/getByProductName")
		public DataResult<Product> getByProductName(@RequestParam String productName){
			return this.productService.getByProductName(productName);
		}
	 
	 @GetMapping("/getByProductAndCategory")
		public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
			return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
		}
	 
	 @GetMapping("/getByProductNameContains")
		public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
			return this.productService.getByProductNameContains(productName);
		}
	 
	 
		



}
