package com.duffiye.dao.common;

import java.util.List;

/**
 * This is a base exception class of all the exceptions.
 *
 */
public class BaseRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 6893675364069416306L;
    private String message;
    private String messageCode;
    private Object[] messageArguments;
    private List<? extends Object> errors;

    /**
     * Create a new BaseRuntimeException with the specified message.
     * @param msg the detail message
     */
    public BaseRuntimeException(String msg) {
        super(msg);
        this.message = msg;
    }

    /**
     * Create a new ServiceException with the specified message and errors.
     * @param msg the detail message
     * @param errors the concrete errors
     */
    public BaseRuntimeException(String msg, List<? extends Object> errors) {
        this.message = msg;
        this.errors = errors;
    }

    /**
     * Create a new BaseRuntimeException with the specified message
     * and root cause.
     * @param msg the detail message
     * @param ex the root cause
     */
    public BaseRuntimeException(String msg, Throwable ex) {
        super(msg, ex);
        this.message = msg;
    }

    /**
     * Create a new ServiceException with the specified message, errors
     * and root cause.
     * @param msg the detail message
     * @param errors the concrete errors
     * @param ex the root cause
     */
    public BaseRuntimeException(String msg, List<? extends Object> errors, Throwable ex) {
        super(msg, ex);
        this.message = msg;
        this.errors = errors;
    }

    /**
     * Create a new ServiceException with the specified message and errors.
     * @param msg the detail message
     * @param errors the concrete errors
     */
    public BaseRuntimeException(String messageCode, Object[] messageArgs, String defaultMessage) {
        this.messageCode = messageCode;
        this.messageArguments = messageArgs;
        this.message = defaultMessage;
    }

    /**
     * Create a new ServiceException with the specified message and errors.
     * @param msg the detail message
     * @param errors the concrete errors
     */
    public BaseRuntimeException(String messageCode, Object[] messageArgs, String defaultMessage,
            List<? extends Object> errors) {
        this.messageCode = messageCode;
        this.messageArguments = messageArgs;
        this.message = defaultMessage;
        this.errors = errors;
    }

    /**
     * Create a new BaseRuntimeException with the specified message
     * and root cause.
     * @param msg the detail message
     * @param ex the root cause
     */
    public BaseRuntimeException(String messageCode, Object[] messageArgs, String defaultMessage, Throwable ex) {
        super(defaultMessage, ex);
        this.messageCode = messageCode;
        this.messageArguments = messageArgs;
        this.message = defaultMessage;
    }

    /**
     * Create a new ServiceException with the specified message, errors
     * and root cause.
     * @param msg the detail message
     * @param errors the concrete errors
     * @param ex the root cause
     */
    public BaseRuntimeException(String messageCode, Object[] messageArgs, String defaultMessage,
            List<? extends Object> errors, Throwable ex) {
        super(defaultMessage, ex);
        this.messageCode = messageCode;
        this.messageArguments = messageArgs;
        this.message = defaultMessage;
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the messageCode
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * @return the messageArguments
     */
    public Object[] getMessageArguments() {
        return messageArguments;
    }

    /**
     * @return the errors
     */
    public List<? extends Object> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(List<? extends Object> errors) {
        this.errors = errors;
    }
}
