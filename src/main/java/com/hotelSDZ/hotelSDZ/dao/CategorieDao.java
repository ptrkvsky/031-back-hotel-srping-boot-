package com.hotelSDZ.hotelSDZ.dao;

import com.hotelSDZ.hotelSDZ.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieDao  extends JpaRepository<Categorie, Integer> {

}