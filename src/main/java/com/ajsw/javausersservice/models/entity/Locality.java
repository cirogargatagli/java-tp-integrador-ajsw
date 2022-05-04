package com.ajsw.javausersservice.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "locality", schema = "public", catalog = "d9sp9r36nrg2j2")
public class Locality {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_locality")
    private int idLocality;
    @Basic
    @Column(name = "name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locality that = (Locality) o;
        return idLocality == that.idLocality && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocality, name);
    }
}
