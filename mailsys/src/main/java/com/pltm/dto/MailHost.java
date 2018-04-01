package com.pltm.dto;

public class MailHost {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_host.id
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_host.host_name
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    private String hostName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_host.smtp_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    private String smtpHost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_host.smtp_host_port
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    private String smtpHostPort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_host.pop3_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    private String pop3Host;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_host.pop3_host_port
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    private String pop3HostPort;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_host.id
     *
     * @return the value of mail_host.id
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_host.id
     *
     * @param id the value for mail_host.id
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_host.host_name
     *
     * @return the value of mail_host.host_name
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_host.host_name
     *
     * @param hostName the value for mail_host.host_name
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_host.smtp_host
     *
     * @return the value of mail_host.smtp_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String getSmtpHost() {
        return smtpHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_host.smtp_host
     *
     * @param smtpHost the value for mail_host.smtp_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost == null ? null : smtpHost.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_host.smtp_host_port
     *
     * @return the value of mail_host.smtp_host_port
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String getSmtpHostPort() {
        return smtpHostPort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_host.smtp_host_port
     *
     * @param smtpHostPort the value for mail_host.smtp_host_port
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public void setSmtpHostPort(String smtpHostPort) {
        this.smtpHostPort = smtpHostPort == null ? null : smtpHostPort.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_host.pop3_host
     *
     * @return the value of mail_host.pop3_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String getPop3Host() {
        return pop3Host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_host.pop3_host
     *
     * @param pop3Host the value for mail_host.pop3_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public void setPop3Host(String pop3Host) {
        this.pop3Host = pop3Host == null ? null : pop3Host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_host.pop3_host_port
     *
     * @return the value of mail_host.pop3_host_port
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String getPop3HostPort() {
        return pop3HostPort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_host.pop3_host_port
     *
     * @param pop3HostPort the value for mail_host.pop3_host_port
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public void setPop3HostPort(String pop3HostPort) {
        this.pop3HostPort = pop3HostPort == null ? null : pop3HostPort.trim();
    }
}