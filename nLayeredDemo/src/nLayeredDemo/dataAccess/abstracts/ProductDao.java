package nLayeredDemo.dataAccess.abstracts;

import java.util.List;

import nLayeredDemo.entities.concretes.Product;

public interface ProductDao {
	void productAdd(Product product);
	void productUpdate(Product product);
	void productDelete(Product product);
	Product get(int id);
	List<Product> getAll();
}
