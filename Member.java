package com.snist.crowdfunding_app.model;
import jakarta.persistence.*;
@Entity
@Table(name="member")
public class Member {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "mid")
private Integer mid;
@Column(name = "mname")
private String mname;
@Column(name = "username")
private String username;
@Column(name = "contact")
private String contact;
@Column(name = "email")
private String email;
@Column(name = "password")
private String password;
public int getMid() { return mid; }

public String getMname() { return mname; }
public void setMname(String mname) { this.mname = mname; }

public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }

public String getContact() { return contact; }
public void setContact(String contact) { this.contact = contact; }

public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }

public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; }
}
