package kodlamaio.hrms.core.utilites.results;

import kodlamaio.hrms.services.FakeMernis;

public class IdentityValidation {
	public static boolean isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		return FakeMernis.validate(tcno);
	}
}
