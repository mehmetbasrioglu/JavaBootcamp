package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilites.GenerateRandomCode;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailVerificationManager  implements EmailVerificationService{
	private EmailVerificationDao emailVerificationDao;
	
    @Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;
	}

    @Override
	public void generateCode(EmailVerification code,Integer id) {
		// TODO Auto-generated method stub
				EmailVerification code_ = code;
				code.setCode(null);
				code.setVerified(false);
				if(code.isVerified() == false) {
					GenerateRandomCode generator = new GenerateRandomCode();
					String code_create = generator.create();
					code.setCode(code_create);
					code.setUserId(id);
			
					emailVerificationDao.save(code);
					
				}
				return ;
	}
	
	@Override
	public Result verify(String verificationCode,Integer id) {
		// TODO Auto-generated method stub
		EmailVerification ref = emailVerificationDao.getOne(id);
		if(ref.getCode().equals(verificationCode)) {
			ref.setVerified(true);
			return  new SuccessDataResult<EmailVerification>(this.emailVerificationDao.save(ref),"Başarılı");
		}
		return  new ErrorDataResult<EmailVerification>(null,"Doğrulama Kodu Geçersiz");
		
		
		
		
		
		
	}


	

}
