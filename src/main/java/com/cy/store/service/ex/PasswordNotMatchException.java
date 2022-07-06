package com.cy.store.service.ex;

/*密码验证失败*/
public class PasswordNotMatchException extends ServiceException{
    //Override Method...
    public PasswordNotMatchException(){
        super();
    }

    public PasswordNotMatchException(String message){
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause){
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause){
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}