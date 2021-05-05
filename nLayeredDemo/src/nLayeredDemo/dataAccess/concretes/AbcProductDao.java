package nLayeredDemo.dataAccess.concretes;

import java.util.List;

import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class AbcProductDao implements ProductDao{

	@Override
	public void productAdd(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Abc ile eklendi " + product.getProductName());
		
	}

	@Override
	public void productUpdate(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void productDelete(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
