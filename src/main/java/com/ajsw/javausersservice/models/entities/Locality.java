package com.ajsw.javausersservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locality")
public class Locality {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_locality")
    private int idLocality;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;

    public Locality(int idLocality) {
        this.idLocality = idLocality;
    }

    public Locality() {

    }

    public int getIdLocality() {
        return idLocality;
    }

    public void setIdLocality(int idLocality) {
        this.idLocality = idLocality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
