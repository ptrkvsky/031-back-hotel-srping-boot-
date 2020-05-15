package com.hotelSDZ.hotelSDZ.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelSDZ.hotelSDZ.model.Chambre;
import com.hotelSDZ.hotelSDZ.model.TypeHotel;

import javax.persistence.*;
import java.util.List;


public class HotelDto  {

    private Integer nuhotel;

    private String adressehotel;

    private String cphotel;

    private String nomhotel;

    private String villehotel;


    private List<Chambre> chambres;

    private TypeHotel typeHotel;

    public HotelDto() {
    }

    public HotelDto(String adressehotel, String cphotel, String nomhotel, String villehotel,
                 TypeHotel typeHotel, List<Chambre> chambres) {
        this.adressehotel = adressehotel;
        this.cphotel = cphotel;
        this.nomhotel = nomhotel;
        this.villehotel = villehotel;
        this.typeHotel = typeHotel;
        this.chambres = chambres;
    }

    public Integer getNuhotel() {
        return this.nuhotel;
    }

    public void setNuhotel(Integer nuhotel) {
        this.nuhotel = nuhotel;
    }

    public String getAdressehotel() {
        return this.adressehotel;
    }

    public void setAdressehotel(String adressehotel) {
        this.adressehotel = adressehotel;
    }

    public String getCphotel() {
        return this.cphotel;
    }

    public void setCphotel(String cphotel) {
        this.cphotel = cphotel;
    }

    public String getNomhotel() {
        return this.nomhotel;
    }

    public void setNomhotel(String nomhotel) {
        this.nomhotel = nomhotel;
    }

    public String getVillehotel() {
        return this.villehotel;
    }

    public void setVillehotel(String villehotel) {
        this.villehotel = villehotel;
    }

    public List<Chambre> getChambres() {
        return this.chambres;
    }


    public TypeHotel getTypeHotel() {
        return this.typeHotel;
    }

    public void setTypeHotel(TypeHotel typeHotel) {
        this.typeHotel = typeHotel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adressehotel == null) ? 0 : adressehotel.hashCode());
        result = prime * result + ((cphotel == null) ? 0 : cphotel.hashCode());
        result = prime * result + ((nomhotel == null) ? 0 : nomhotel.hashCode());
        result = prime * result + ((nuhotel == null) ? 0 : nuhotel.hashCode());
        result = prime * result + ((villehotel == null) ? 0 : villehotel.hashCode());
        return result;
    }


}
