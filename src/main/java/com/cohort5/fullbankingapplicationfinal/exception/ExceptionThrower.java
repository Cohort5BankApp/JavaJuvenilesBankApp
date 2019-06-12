package com.cohort5.fullbankingapplicationfinal.exception;

public class ExceptionThrower {

    public void throwGeneralException() throws Exception {
        Exception e = new Exception();
        throw e;
    }

    public void throwCustomException() throws CustomException {
        CustomException e = new CustomException();
        e.setCode(404);
        e.setMessage("Custom works");
        throw e;
    }

}
