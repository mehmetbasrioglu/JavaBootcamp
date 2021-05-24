package kodlamaio.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
	Optional<Product> findById(Integer id);
	Optional<Product> findByCategoryId(Integer id);
	
}
