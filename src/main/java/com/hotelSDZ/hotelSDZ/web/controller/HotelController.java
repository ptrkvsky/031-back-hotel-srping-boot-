package com.hotelSDZ.hotelSDZ.web.controller;

import com.hotelSDZ.hotelSDZ.dao.HotelDao;
import com.hotelSDZ.hotelSDZ.dao.TypeHotelDao;
import com.hotelSDZ.hotelSDZ.model.Hotel;
import com.hotelSDZ.hotelSDZ.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://178.62.113.122")
@RestController
public class HotelController {
    @Autowired
    HotelDao hotelDao;

    @Autowired
    TypeHotelDao typeHotelDao;

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping (value="/hotels")
    public MappingJacksonValue listeHotels() {
        return new MappingJacksonValue(hotelService.getHotels());
    }

    @GetMapping (value="/hotels/test")
    public MappingJacksonValue listeHotelstest() {
        return new MappingJacksonValue(hotelService.getHotelsTest());
    }

    // Pagination
    @GetMapping (value="/hotels/pages/{idPage}")
    public MappingJacksonValue listeHotelsPage(@PathVariable int idPage) {
        return new MappingJacksonValue(hotelService.getPageHotels(idPage));
    }

    // One hotel by id
    @GetMapping(value = "/hotels/{id}")
    public Optional<Hotel> detailHotels(@PathVariable int id) {
        return hotelDao.findById(id);
    }
}