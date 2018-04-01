package com.pltm.vo;

public class MailMessage {
    private Integer mailMsgId;
    private String mailMsgFrom;
    private String mailMsgSubject;
    private String mailMsgDate;
    private String mailMsgContent;

    public MailMessage(){}

    public MailMessage(Integer mailMsgId, String mailMsgFrom,
                       String mailMsgSubject, String mailMsgDate,
                       String mailMsgContent) {
        this.mailMsgId = mailMsgId;
        this.mailMsgFrom = mailMsgFrom;
        this.mailMsgSubject = mailMsgSubject;
        this.mailMsgDate = mailMsgDate;
        this.mailMsgContent = mailMsgContent;
    }

    public Integer getMailMsgId() {
        return mailMsgId;
    }

    public void setMailMsgId(Integer mailMsgId) {
        this.mailMsgId = mailMsgId;
    }

    public String getMailMsgFrom() {
        return mailMsgFrom;
    }

    public void setMailMsgFrom(String mailMsgFrom) {
        this.mailMsgFrom = mailMsgFrom;
    }

    public String getMailMsgSubject() {
        return mailMsgSubject;
    }

    public void setMailMsgSubject(String mailMsgSubject) {
        this.mailMsgSubject = mailMsgSubject;
    }

    public String getMailMsgDate() {
        return mailMsgDate;
    }

    public void setMailMsgDate(String mailMsgDate) {
        this.mailMsgDate = mailMsgDate;
    }

    public String getMailMsgContent() {
        return mailMsgContent;
    }

    public void setMailMsgContent(String mailMsgContent) {
        this.mailMsgContent = mailMsgContent;
    }

    @Override
    public String toString() {
        return "MailMessage "+mailMsgId+"\t"+"From: "+getMailMsgFrom()+"\t"
                +"Subject: "+getMailMsgSubject()+"\t"+"Data: "+getMailMsgDate()
                +"\t"+"Content: "+getMailMsgContent();
    }
}
