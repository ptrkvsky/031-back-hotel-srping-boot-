package com.hotelSDZ.hotelSDZ.service;

import com.hotelSDZ.hotelSDZ.dao.HotelDao;
import com.hotelSDZ.hotelSDZ.dto.HotelDto;
import com.hotelSDZ.hotelSDZ.model.Hotel;
import com.hotelSDZ.hotelSDZ.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class HotelService implements InterfaceHotelService {

    private final HotelDao hotelDao;

    @Autowired
    public HotelService(@Qualifier("postgresDAO") HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    public List<HotelDto> getHotels() {
        PageRequest limit = PageRequest.of(0,10);
        Iterable<Hotel> hotelList = hotelDao.findAll(limit);
        List<HotelDto> hotelDtoList = Mapper.mapLana(hotelList, HotelDto.class);
        return hotelDtoList;
    }

    public Iterable<Hotel>  getHotelsTest() {
        PageRequest limit = PageRequest.of(0,10);
        return hotelDao.findAll(limit);
    }

    public Iterable<Hotel> getPageHotels(int idPage){
        PageRequest limit = PageRequest.of(idPage,10);
        return hotelDao.findAll(limit);
    }
}
