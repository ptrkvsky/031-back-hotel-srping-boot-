package com.hotelSDZ.hotelSDZ.dao;

import com.hotelSDZ.hotelSDZ.dto.HotelDto;
import com.hotelSDZ.hotelSDZ.model.Hotel;
import com.hotelSDZ.hotelSDZ.model.TypeHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgresDAO")
public interface HotelDao extends JpaRepository<Hotel, Integer> {


  //@Query("SELECT h FROM Hotel h WHERE h.nomhotel like %:nomhotel%")
  //Page<Hotel> findByNomhotelContaining(@Param("nomhotel") String nomhotel, Pageable pageable);
  Page<Hotel> findByNomhotelContaining(@Param("nomhotel") String nomhotel, Pageable pageable);

  @Query("SELECT h FROM Hotel h inner join h.typeHotel th where th.nutype = :nutype")
  List<Hotel> findHotelByNutype(@Param("nutype") int nutype);

  @Query("SELECT h FROM Hotel h inner join h.typeHotel th where th.nutype IN (:nutype) AND h.nomhotel like %:nomhotel%")
  Page<Hotel> findHotelByNutypes(@Param("nutype") List<Integer> nutype, @Param("nomhotel") String nomhotel, Pageable pageable);

  @Query(
      "SELECT distinct h FROM Hotel h INNER JOIN Chambre c on h.nuhotel = c.hotel.nuhotel  where c.categorie.nucat IN (:nucatchambre) AND h.nomhotel like %:nomhotel%")
  Page<Hotel> findHotelByChambretypes(
      @Param("nucatchambre") List<Integer> nucatchambre, @Param("nomhotel") String nomhotel, Pageable pageable);

  @Query(
      "SELECT distinct h FROM Hotel h INNER JOIN h.typeHotel th INNER JOIN Chambre c on h.nuhotel = c.hotel.nuhotel WHERE th.nutype IN (:nutype) AND c.categorie.nucat IN (:nucatchambre) AND h.nomhotel like %:nomhotel%")
  Page<Hotel> findHotelByChambreAndNutypes(
      @Param("nucatchambre") List<Integer> nucatchambre, @Param("nutype") List<Integer> nutype, @Param("nomhotel") String nomhotel, Pageable pageable);
}
