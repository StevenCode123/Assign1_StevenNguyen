package com.sn.week2;

/*
 * this is a model class for the Registration Page
 * it holds user registration data and provides getters and setters.
 */

public class RegistrationClass {

	private int id;
	private String userName;
    private String password;
    private String rePassword;
    private String mblnumber;
    private String email;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getMblnumber() {
        return mblnumber;
    }

    public void setMblnumber(String mblnumber) {
        this.mblnumber = mblnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
