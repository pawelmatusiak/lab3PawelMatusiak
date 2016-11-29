package com.register;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
@Entity
public class User {
    @Id Long id;
    public String name;
    public String password;
    private String email;
    byte[] rawData;
    @Ignore int irrelevant;

    public User() {}

    public User(String nam, String pass,String ema) {
        this.name = nam;
        this.password = pass;
        this.email=ema;
    }
    public String getUsername() {
		return name;
	}
    public String getPassword() {
		return password;
	}
    public String getEmail() {
		return email;
	}
 
}