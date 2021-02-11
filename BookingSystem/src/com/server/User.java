/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server;

/**
 *
 * @author danma
 */
public class User {
    
    String name;
    String email;
    String encryptedpass;
    long phonenum;
    int userId;
    boolean isAdmin;
    public User(String name, String email, String encryptedpass, long phonenum, int userId, boolean isAdmin) throws Exception {
        this.name = name;
        this.email = email;
        this.encryptedpass = encryptedpass;
        this.phonenum = phonenum;
        this.userId = userId;
        this.isAdmin = isAdmin;
    }

    public User(String name, String email, String encryptedpass, long phonenum) throws Exception {
        this.name = name;
        this.email = email;
        this.encryptedpass = encryptedpass;
        this.phonenum = phonenum;
    }
    
    public User(String name, String email, long phonenum) throws Exception {
        this.name = name;
        this.email = email;
        this.phonenum = phonenum;
    }
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPass() {
        return encryptedpass;
    }

    public void setEncryptedPass(String encryptedpass) {
        this.encryptedpass = encryptedpass;
    }

    public long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    
    
    
}
