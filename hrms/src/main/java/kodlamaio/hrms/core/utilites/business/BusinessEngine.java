package kodlamaio.hrms.core.utilites.business;

import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;

public class BusinessEngine {
    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
}