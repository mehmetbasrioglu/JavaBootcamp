package oop;

public class ProductManager implements IProduct {
	
	//Ürün Yönetimi

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Sepete Eklendi:"+product.getProductName());
		
		
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getProductName(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
