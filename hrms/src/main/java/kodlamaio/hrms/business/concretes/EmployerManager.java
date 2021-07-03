package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilites.IdentityValidation;
import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.business.ImageService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;
	private ImageService imageService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			UserService userService,ImageService imageService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;
		this.imageService = imageService;
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		// TODO Auto-generated method stub
		Result engine = BusinessEngine.run(
				companyNameChecker(employer),webSiteChecker(employer),
				passwordNullChecker(employer),
				isRealEmployer(employer),
				isRealPhoneNumber(employer),
				isEmailAlreadyRegistered(employer)
				);
		if(!engine.isSuccess()) {
			return new ErrorDataResult(null,engine.getMessage());
		}
		User savedUser = this.userService.add(employer);
		this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
		employer.setAvatarUrl("https://res.cloudinary.com/drtniio0r/image/upload/v1624707367/noperson_e8gskq.png");
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş Veren Hesabı Eklendi, Doğrulama Kodu Gönderildi ID:"+employer.getId());
	}
	
	@Override
	public Result uploadEmployerPhoto(int employerId, MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub

    var result = this.imageService.upload(multipartFile);
      var url = result.getData().get("url");
      
      Employer ref = this.employerDao.getOne(employerId); 
      ref.setAvatarUrl(url.toString());
      this.employerDao.save(ref);
      
        return new SuccessResult("başarılı");
	}
	
	private Result companyNameChecker(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return new ErrorResult("Şirket Adı Doldurulmak Zorundadır");
		}
		return new SuccessResult();
	}
	
	private Result webSiteChecker(Employer employer) {
		if(employer.getWebAdress().isBlank() || employer.getWebAdress() == null) {
			return new ErrorResult("WebSite Adresi Doldurulmak Zorundadır");
		}
		return new SuccessResult();
	}
	
	private Result isRealEmployer(Employer employer) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
	     if(!matcher.matches()) {
	    	 return new ErrorResult("Geçersiz Email Adresi");
	     }
	     else if(!employer.getEmail().contains(employer.getWebAdress())) {
	    	 return new ErrorResult("Domain adresi girmek zorundasınız"); 
	     }
	 	return new SuccessResult();
	     
	}
	
	private Result isEmailAlreadyRegistered(Employer employer) {
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			 return new ErrorResult("Email zaten kayıtlı"); 
		}
	 	return new SuccessResult();
	}
	
	private Result passwordNullChecker(Employer employer) {
		if(employer.getPassword().isBlank() || employer.getPassword() == null) {
			 return new ErrorResult("Şifre Bilgisi Doldurulmak zorundadır"); 
		}
		return new SuccessResult();
	}
	
	private Result isRealPhoneNumber(Employer employer) {
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		/*
		 * ÖRNEK TELEFON NUMARALARI
		 * String[] validPhoneNumbers 
      = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125", 
      "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
		 */
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if(!matcher.matches()) {
			 return new ErrorResult("Geçersiz Telefon Numarası"); 
		}
		return new SuccessResult();
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Başarılı Şekilde Employer Listelendi");
	}

	@Override
	public Employer findByEmployerId(int id) {
		// TODO Auto-generated method stub
		return this.employerDao.findById(id);
	}

	@Override
	public Employer update(Employer employer) {
		// TODO Auto-generated method stub
		return this.employerDao.save(employer);
	}

	@Override
	public DataResult<Employer> findById(int id) {
		// TODO Auto-generated method stub
		if(this.employerDao.existsById(id)) {
			return new SuccessDataResult<Employer>(this.employerDao.findById(id),"İşveren bilgileri getirildi");
		}
		return new ErrorDataResult<>("İşveren bulunamadı");
	}

	@Override
	public Result uploadEmployerHeaderPhoto(int employerId, MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
	    var result = this.imageService.upload(multipartFile);
	      var url = result.getData().get("url");
	      
	      Employer ref = this.employerDao.getOne(employerId); 
	      ref.setHeaderImageUrl(url.toString());
	      this.employerDao.save(ref);
	      
	        return new SuccessResult("başarılı");
	}

	

	
	
	

}
