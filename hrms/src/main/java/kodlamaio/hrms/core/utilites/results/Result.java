package kodlamaio.hrms.core.utilites.results;

public class Result {
	private boolean success;
	private String message;
	
	//Bool type constructor
	public Result(boolean success) {
		super();
		this.success = success;
	}

	//All Args Constructor
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}


	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
