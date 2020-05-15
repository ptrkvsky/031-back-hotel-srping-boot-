package com.hotelSDZ.hotelSDZ.service;

import com.hotelSDZ.hotelSDZ.dto.HotelDto;
import com.hotelSDZ.hotelSDZ.model.Hotel;

import java.util.List;

public interface InterfaceHotelService {
  public List<HotelDto> getHotels();
  public Iterable<Hotel> getPageHotels(int idPage);
}
