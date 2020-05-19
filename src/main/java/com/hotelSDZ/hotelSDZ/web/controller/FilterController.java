package com.hotelSDZ.hotelSDZ.web.controller;

import com.hotelSDZ.hotelSDZ.dao.HotelDao;
import com.hotelSDZ.hotelSDZ.model.Filter;
import com.hotelSDZ.hotelSDZ.model.Hotel;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class FilterController {

  // Post filter post man
  @Autowired HotelDao hotelDao;
  @CrossOrigin(origins = "http://kovsky-hotel-app.ovh/")
  @PostMapping(value = "/filter")
  public MappingJacksonValue filter(@RequestBody Map<String, ?> input) {
    PageRequest limit = PageRequest.of(0, 10);

    String searchNom = (String) input.get("searchNom");
    List<Integer> typeHotelIds = (List<Integer>) input.get("typeHotel");
    List<Integer> catChambreIds = (List<Integer>) input.get("categorieChambre");
    Iterable<Hotel> hotels = null;

    if (!searchNom.equals(null) && !searchNom.equals("")) {
      hotels = hotelDao.findByNomhotelContaining(searchNom, limit);
    }else{
      searchNom = "";
    }

    if (!typeHotelIds.isEmpty() && catChambreIds.isEmpty()) {
      hotels = hotelDao.findHotelByNutypes(typeHotelIds,searchNom, limit);
    } else if (typeHotelIds.isEmpty() && !catChambreIds.isEmpty()) {
      hotels = hotelDao.findHotelByChambretypes(catChambreIds, searchNom, limit);
    } else {
      hotels = hotelDao.findHotelByChambreAndNutypes(catChambreIds, typeHotelIds, searchNom, limit);
    }

    return new MappingJacksonValue(hotels);
  }
}
