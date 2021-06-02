package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	

	
	
	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    List<Product> getByProductNameOrCategory(String productName,int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    @Query(" from Product u where lower(u.productName) like lower(concat('%', :productName,'%'))")
    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    //@Query("select u from JobTitle u where lower(u.title) like lower(concat('%', :title,'%'))")
    List<Product> getByProductAndCategory(String productName,int categoryId);
	//​select p.product_id,p.product_name, c.category_name,p.unit_price from products p inner join categories c on p.category_id =c.category_id
    //select p.productId,p.productName, c.categoryName from Category c inner join Product p
    // on c.categoryId = p.categoryId
    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    

}
