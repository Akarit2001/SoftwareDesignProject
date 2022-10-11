package com.web.furniturehub.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User {
    public User() {
    }

    @Override
    public String toString() {
        return "User [id=" + uid + ", name=" + name + ", email=" + email + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Integer uid;
    public Integer getUid() {
        return uid;
    }

    @Column(length = 45, nullable = false, unique = true)
    private String name;
    @Column(length = 45, nullable = false, unique = true)
    private String password;
    private String email;
    private String utype;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(targetEntity = Category.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> categorys;

    public User(Integer uid, String name, String password, String email, String utype) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.utype = utype;
    }

    public List<Category> getCategorys() {
        return categorys;
    };

    public void setCategorys(List<Category> p) {
        this.categorys = p;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public Integer getId() {
        return uid;
    }

    public void setId(Integer id2) {
        this.uid = id2;
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
}