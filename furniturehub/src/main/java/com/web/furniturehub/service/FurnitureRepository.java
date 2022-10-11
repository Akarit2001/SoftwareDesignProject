package com.web.furniturehub.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.furniturehub.model.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer>{
    
}
