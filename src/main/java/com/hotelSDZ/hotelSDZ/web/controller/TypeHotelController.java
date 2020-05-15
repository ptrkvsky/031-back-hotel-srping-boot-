package com.hotelSDZ.hotelSDZ.web.controller;

import com.hotelSDZ.hotelSDZ.dao.TypeHotelDao;
import com.hotelSDZ.hotelSDZ.model.TypeHotel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TypeHotelController {

  @Autowired TypeHotelDao typeHotelDao;

  @GetMapping(value = "/type-hotels")
  public MappingJacksonValue listeTypeHotels() {
    Iterable<TypeHotel> typeHotels = typeHotelDao.findAll();
    MappingJacksonValue typeHotelsJackson = new MappingJacksonValue(typeHotels);
    return typeHotelsJackson;
  }

  @GetMapping(value = "/type-hotel/{id}")
  public Optional<TypeHotel> detailTypeHotel(@PathVariable int id) {
    return typeHotelDao.findById(id);
  }

  /*
  @Autowired
  private TypeHotelDao typeHotelDaoImpl;

   @GetMapping(value = "/type-hotel/{id}")
   public TypeHotel detailTypeHotel(@PathVariable int id) {
     //TypeHotelDaoImpl thImpl = new TypeHotelDaoImpl();
     // TypeHotel findedTypeHotel = thImpl.findById(id);

     // return findedTypeHotel;

         return typeHotelDaoImpl.findById(id);
   }
   */

}
