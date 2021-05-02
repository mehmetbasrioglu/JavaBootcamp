package oop;

public class Main {
	
	public static void main(String[] args) {
		
		Product urun1 = new Product();
		urun1.setId(1);
		urun1.setProductName("Lenovo V15");
		urun1.setDetails("16 GB RAM");
		urun1.setDiscount(10);
		urun1.setUnitPrice(160000.000);
		
		System.out.println(urun1.getUnitPriceAfterDiscount());
		
		Category kategori1 = new Category();
		
		kategori1.setId(1);
		kategori1.setName("Ýçeçek");
		
		Category kategori2 = new Category();
		kategori2.setId(2);
		kategori2.setName("Yiyecek");
		System.out.println(kategori1.getCategoryName());
		
		
	}

}
