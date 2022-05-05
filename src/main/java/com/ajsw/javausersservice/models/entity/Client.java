package com.ajsw.javausersservice.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "public", catalog = "d9sp9r36nrg2j2")
public class Client extends Person{
    @Basic
    @Column(name = "id_address")
    private Integer idAddress;

    public Client(String firstName, String lastName,String phone, Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Client() {

    }
}
