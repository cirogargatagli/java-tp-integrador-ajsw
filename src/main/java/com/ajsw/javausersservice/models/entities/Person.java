package com.ajsw.javausersservice.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_person")
    @Getter
    @Setter
    protected int idPerson;

    @Basic
    @Column(name = "first_name", nullable = false)
    @Getter
    @Setter
    protected String firstName;

    @Basic
    @Column(name = "last_name", nullable = false)
    @Getter
    @Setter
    protected String lastName;

    @Basic
    @Column(name = "phone")
    @Getter
    @Setter
    protected String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    @Getter
    @Setter
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_account")
    @Getter
    @Setter
    protected Account account;

    public Person(String firstName, String lastName, String phone, Address address, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.account = account;
    }

    public Person(String firstName, String lastName, String phone, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.account = account;
    }

    public Person() {

    }
}
