package oop;

public class Product {
	// Properties Özellikler

	//Encapsulation 
	
	
	private  Integer id;
	private String productName;
	private Integer productCategory;
	private Double unitPrice;
	private String details;
	private Integer discount;
	private Double unitPriceAfterDiscount;
	
	public Product() {
		// Default Constructor
	}

	public Product(Integer id, String productName, Integer productCategory, Double unitPrice, String details,
			Integer discount, Double unitPriceAfterDiscount) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.unitPrice = unitPrice;
		this.details = details;
		this.discount = discount;
		this.unitPriceAfterDiscount = unitPriceAfterDiscount;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Integer productCategory) {
		this.productCategory = productCategory;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double d) {
		this.unitPrice = d;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(int  discounti) {
		this.discount = discounti;
	}

	public Double getUnitPriceAfterDiscount() {
		return  this.unitPrice - (unitPrice *  this.discount / 100);
	}


	


}
