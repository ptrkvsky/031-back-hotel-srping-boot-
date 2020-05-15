package com.hotelSDZ.hotelSDZ.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="type_hotel")
public class TypeHotel {

  @Id @GeneratedValue(strategy = GenerationType.AUTO) private int nutype;

  public TypeHotel (){

  }
  public TypeHotel(String nomtype) {
    this.nomtype = nomtype;
  }


  private String nomtype;

  public int getNutype() {
    return nutype;
  }

  public void setNutype(int nutype) {
    this.nutype = nutype;
  }

  public String getNomtype() {
    return nomtype;
  }

  public void setNomtype(String nomtype) {
    this.nomtype = nomtype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TypeHotel typeHotel = (TypeHotel) o;
    return nutype == typeHotel.nutype && Objects.equals(nomtype, typeHotel.nomtype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nutype, nomtype);
  }

  @Override
  public String toString() {
    return "TypeHotel{" + "nutype=" + nutype + ", nomtype='" + nomtype + '\'' + '}';
  }
}
