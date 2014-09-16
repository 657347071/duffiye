package com.duffiye.core.service.exception;

public class ServerException extends RuntimeException {

    /** 
    *serialVersionUID 
    */
    private static final long serialVersionUID = 1L;

    public ServerException() {
        super();
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }

    
}
