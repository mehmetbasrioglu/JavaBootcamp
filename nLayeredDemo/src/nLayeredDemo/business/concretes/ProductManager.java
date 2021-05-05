package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService{
	
	private ProductDao productDuo;
	private LoggerService loggerService;

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		// ÝÞ KODLARI YAZILIR
		if(product.getCategoryId() == 1) {
			System.out.println("Bu kategori kabul edilemiyor");
			return;
		}
		this.productDuo.productAdd(product);
		this.loggerService.logToSystem("Ürün Eklendi : "+ product.getProductName());
		
		
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param productDuo
	 * @param loggerService
	 */
	public ProductManager(ProductDao productDuo, LoggerService loggerService) {
		super();
		this.productDuo = productDuo;
		this.loggerService = loggerService;
	}


}
