package com.singtel.espresso.core;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-9-3
 * Time: 下午2:06
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String domain;
    private String userName;
    private String passWord;
    private boolean isPersistent;
    private CustomCredential customCredential;


    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean getPersistent() {
        return isPersistent;
    }

    public void setPersistent(boolean persistent) {
        isPersistent = persistent;
    }

    public CustomCredential getCustomCredential() {
        return customCredential;
    }

    public void setCustomCredential(CustomCredential customCredential) {
        this.customCredential = customCredential;
    }
}
