package kodlamaio.pinterestclonebackend.core;

public class ErrorResult extends Result{
	public ErrorResult() {
		super(false);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResult(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

}
