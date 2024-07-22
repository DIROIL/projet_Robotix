package model;

import java.util.Date;

public class Notification {
    private Date date = new Date();
    private String message;
    private Long accountId;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccount(Long accountId) {
        this.accountId = accountId;
    }

    public Notification(String message) {
        this.message = message;
    }
}
