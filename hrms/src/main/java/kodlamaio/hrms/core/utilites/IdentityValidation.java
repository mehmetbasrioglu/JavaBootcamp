package kodlamaio.hrms.core.utilites;

import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.services.FakeMernis;

public class IdentityValidation {
	public static Result isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		if(FakeMernis.validate(tcno) == true) {
			return new SuccessResult();
		}
		return new ErrorResult("Türkiye cumhuriyeti kimliği olmak zorunda.");
	}
}
