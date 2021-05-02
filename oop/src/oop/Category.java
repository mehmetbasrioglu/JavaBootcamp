package oop;

public class Category {
	
	// Properties
	
	//Constructor Blok
	private Integer id;
	private String categoryName;
	
	public Category() {
		super();
	}

	public Category(Integer id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCategoryName() {
		return this.categoryName;
	}
	
	public void setName(String name) {
		this.categoryName = name;
	}
	
}
