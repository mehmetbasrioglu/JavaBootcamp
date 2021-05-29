package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Product;

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
	
    

}
