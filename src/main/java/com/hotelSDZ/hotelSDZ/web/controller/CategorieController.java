package com.hotelSDZ.hotelSDZ.web.controller;

import com.hotelSDZ.hotelSDZ.dao.CategorieDao;
import com.hotelSDZ.hotelSDZ.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CategorieController {
    @Autowired
    CategorieDao categorieDao;

    @GetMapping(value="/categorie-chambre")
    public MappingJacksonValue allCatChambre(){
        Iterable<Categorie> categories = categorieDao.findAll();
        MappingJacksonValue hotelsJackson = new MappingJacksonValue(categories);
        return hotelsJackson;
    }
}
