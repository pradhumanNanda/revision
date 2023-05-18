package com.activity.revision.Exceptions;

import java.security.GeneralSecurityException;
import javax.xml.bind.ValidationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.activity.revision.response.ResponseStatus;
import com.activity.revision.response.SystemError;
import com.activity.revision.utils.Constants;

@RestControllerAdvice
public class ApplicationExceptionHandeling {

	@ExceptionHandler(OptimisticLockingFailureException.class)
	public ResponseStatus HandleIllegalArgumentException(OptimisticLockingFailureException ex) {
		return new ResponseStatus(SystemError.DUPLICATE);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseStatus HandleIllegalArgumentException(IllegalArgumentException ex) {
		return new ResponseStatus(SystemError.NULL);
	}


	@ExceptionHandler(ValidationException.class)
    public ResponseStatus HandlevalidationException(ValidationException e) {
		ResponseStatus resResponseStatus = new ResponseStatus(SystemError.CUSTOM);
		resResponseStatus.setMessage(e.getMessage());		 
    	return resResponseStatus;
    }
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseStatus HandleconstraintVoilationEx(HttpMessageNotReadableException e) {
		ResponseStatus resResponseStatus = new ResponseStatus(SystemError.CUSTOM);
		resResponseStatus.setMessage(e.getMessage());		 
    	return resResponseStatus;
    }
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseStatus HandleDataIntegrityViolationException(DataIntegrityViolationException e) {		 
    	return new ResponseStatus(SystemError.DATAINTEGRITY);
    }

    @ExceptionHandler(ConstraintViolationException.class)
     public ResponseStatus HandleconstraintVoilationEx(Exception e) {
    	 return new ResponseStatus(SystemError.UNIQUE);
    }
    
    @ExceptionHandler(GeneralSecurityException.class)
    public ResponseStatus HandleGeneralSecurityException(Exception e) {
    	return new ResponseStatus(SystemError.DUPLICATE);
    }
    
    @ExceptionHandler(ClassCastException.class)
    public ResponseStatus HandleClassCastException(Exception e) {
    	ResponseStatus resResponseStatus = new ResponseStatus(SystemError.CUSTOM);
		resResponseStatus.setMessage(e.getMessage());		 
    	return resResponseStatus;
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseStatus HandleMethodArgumentNotValidException(Exception e) {
    	return new ResponseStatus();
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseStatus HandleRuntimeException(Exception e) {
    	ResponseStatus resResponseStatus = new ResponseStatus(SystemError.CUSTOM);
		if(Constants.curUserJwtString == null) resResponseStatus.setMessage("No user Logedin");
		else resResponseStatus.setMessage(e.getMessage());
    	return resResponseStatus; 
    }

}