package com.web.furniturehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fur_id")
    private Integer fur_id;

    public Integer getFur_id() {
        return fur_id;
    }

    public void setFur_id(Integer fur_id) {
        this.fur_id = fur_id;
    }

    private String name;

    private Integer quantity;
    private double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category c) {
        this.category = c;
    }

    public Furniture() {
		
		super();
		setQuantity(0);
		setPrice(0);
	}

    public Furniture(String name) {
		super();
		setName(name);
		
     }

    public Furniture(String name,Integer q) {
		super();
		setName(name);
		setQuantity(q);
     }

    public Furniture(String name,Integer q,Double thePrice) {
		super();
		setName(name);
		setQuantity(q);
		setPrice(thePrice);
     }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + fur_id + ", name=" + name + ", Quantity=" + quantity + ", Category=" + category.getName()
                + "]";
    }
}
