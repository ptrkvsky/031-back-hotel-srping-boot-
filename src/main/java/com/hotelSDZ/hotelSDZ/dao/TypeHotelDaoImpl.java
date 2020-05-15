/*
package com.hotelSDZ.hotelSDZ.dao;

import com.hotelSDZ.hotelSDZ.model.TypeHotel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TypeHotelDaoImpl implements TypeHotelDao {

  public static List<TypeHotel> TypeHotelList = new ArrayList<TypeHotel>();

  static {
    TypeHotelList.add(new TypeHotel(1, "test"));
    TypeHotelList.add(new TypeHotel(2, "test 2"));
    TypeHotelList.add(new TypeHotel(3, "test 3"));
  }

  @Override
  public List<TypeHotel> findAll() {
    List<TypeHotel> TypeHotelList = new ArrayList<TypeHotel>();
    return TypeHotelList;
  }

  @Override
  public TypeHotel findById(int id) {
    for (TypeHotel elementTypeHotel : TypeHotelList) {
      if (elementTypeHotel.getNutype() == id) {
        return elementTypeHotel;
      }
    }
    return null;
  }

  @Override
  public TypeHotel typeHotelSave(TypeHotel p_typeHotel) {
    TypeHotelList.add(p_typeHotel);
    return p_typeHotel;
  }
}
*/