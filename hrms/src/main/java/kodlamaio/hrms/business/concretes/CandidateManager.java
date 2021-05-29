package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.CallbackMessages;
import kodlamaio.hrms.core.utilites.IdentityValidation;
import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService{
	
	//dependecy injection
	@Autowired
	private CandidateDao candidateDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;
	

	public CandidateManager(CandidateDao candidateDao,EmailVerificationService emailVerificationService,UserService userService) {
		super();
		this.candidateDao = candidateDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		// TODO Auto-generated method stub
		Result engine = BusinessEngine.run(firstNameChecker(candidate),lastNameChecker(candidate),
				IdentityValidation.isRealPerson(candidate.getIdentificationNumber()),
				IdChecker(candidate),
				birthDateChecker(candidate),
				emailNullChecker(candidate),
				isRealEmail(candidate),
				passwordNullChecker(candidate),
				isMailRegistered(candidate)
				);
		if(!engine.isSuccess()) {
			return new ErrorDataResult(null,engine.getMessage());
		}
		
		User savedUser = this.userService.add(candidate);
		this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),CallbackMessages.isRegisterSuccessForCandidateMessage);
		
		
		
	
		


		
		
		
		
	}
	
	private Result firstNameChecker(Candidate candidate) {
		if(candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredFirstName);
			
		}
		return new SuccessResult();
	}
	
	private Result lastNameChecker(Candidate candidate) {
		if(candidate.getLastName().isBlank() || candidate.getLastName().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredLastName);
		}
		return new SuccessResult();
	}
	
	private Result birthDateChecker(Candidate candidate) {
		if(candidate.getBirthDate().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredBirthDate);
		}
		return new SuccessResult();
	}
	
	private Result emailNullChecker(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredEmail);
		}
		return new SuccessResult();
	}
	
	private Result passwordNullChecker(Candidate candidate) {
		if(candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredPassword);
		}
		return new SuccessResult();
	}
	
	private Result isRealEmail(Candidate candidate) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(candidate.getEmail());
	     if(!matcher.matches()) {
	    		return new ErrorResult(CallbackMessages.isRealMail);
	     }
	     return new SuccessResult();
	     
	}
	
	private Result IdChecker(Candidate candidate) {
		if(candidate.getIdentificationNumber().isBlank()) {
			return new ErrorResult(CallbackMessages.requiredId);
		}
		
		 return new SuccessResult();
	}
	
	private Result isMailRegistered(Candidate candidate) {
		if(candidateDao.findByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorResult(CallbackMessages.alreadyRegisteredMail);
		}
		 return new SuccessResult();
	}
	
	private Result isIdRegistered(Candidate candidate) {
		if(candidateDao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0 ) {
			return new ErrorResult(CallbackMessages.alreadyRegisteredId);
		}
		 return new SuccessResult();
	}
	


	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),CallbackMessages.listedCandidates);
	}
	
	
	
	



}
