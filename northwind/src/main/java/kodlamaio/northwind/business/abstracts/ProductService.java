package kodlamaio.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
	Optional<Product> findById(Integer id);
	Optional<Product> findByCategoryId(Integer id);
}
