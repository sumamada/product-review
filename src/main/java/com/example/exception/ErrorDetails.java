package com.example.exception;






import java.util.Date;

 

public class ErrorDetails {

 

    private Date timeStamp;
    private String message;
    private String details;

 


    //CONSTRUCTORS

 

    public ErrorDetails(Date timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

 


    //GETTERS & SETTERS

 

    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

 


    //TOSTRING

 

    @Override
    public String toString() {
        return "ErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
    }

 


}
