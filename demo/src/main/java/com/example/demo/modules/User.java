package com.example.demo.modules;

public class User {
private long id;
private String email;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
private String name;
public User(long id, String email, String name) {
	super();
	this.id = id;
	this.email = email;
	this.name = name;
}

}
