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
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, unique = true)
    private String name;
    @Column(length = 45, nullable = false, unique = true)
    private String password;
    private String email;
    private String utype;

    @OneToMany(targetEntity = Category.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> categorys;

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
        return id;
    }

    public void setId(Integer id2) {
        this.id = id2;
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