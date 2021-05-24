package kodlamaio.hrms.core.utilites.results;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result{
	private T data;
	
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}
	
	public DataResult(T data,boolean success) {
		super(success);
		// TODO Auto-generated constructor stub
	}
	
	
}
