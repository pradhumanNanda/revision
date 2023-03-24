package com.activity.revision.response;

public enum SystemError {

	OK(200,"The request was successfully completed."),
    
    CREATED(201,"A new resource was successfully created."),
    
    BAD_REQUEST(400,"The request was invalid."),
    
    UNAUTHORIZED(401,"The request did not include an authentication token or the authentication token was expired."),
    
    FORBIDDEN(403,"The client did not have permission to access the requested resource."),
    
    NOT_FOUND(404,"The requested resource was not found."),
    
    UNIQUE(405,"Email should be unique. Alrealy existing in the database"),
    
    CUSTOM(406,""),
    
    DUPLICATE(407,"Resourse already exist in the database."),
    
    NULL(408,"Resourse does not exist"),
    
    DATAINTEGRITY(409,"Unique data required"),
    
    INTERNAL_SERVER_ERROR(500,"The request was not completed due to an internal error on the server side."),
    
    SERVICE_UNAVAILABLE(503,"The server was unavailable.");


    private Integer statusCode;
    
    private String statusMessage;

    SystemError(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public Integer getStatusCode(){
        return statusCode;
    }
    public String getStatusMessage(){
        return statusMessage;
    }

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
