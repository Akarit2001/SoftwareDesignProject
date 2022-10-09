package com.web.furniturehub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer category_id;
    @Column(length = 45, nullable = false, unique = true)
    private String name;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @OneToMany(targetEntity = Furniture.class, mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Furniture> furnitures;

    public List<Furniture> getFurnitures() {
        return furnitures;
    };

    public void setFurnitures(List<Furniture> p) {
        this.furnitures = p;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category() {
        super();
    }

    public Category(String name2) {
        this.name = name2;
    }

    @Override
    public String toString() {
        return "Category [id=" + category_id + ", name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
