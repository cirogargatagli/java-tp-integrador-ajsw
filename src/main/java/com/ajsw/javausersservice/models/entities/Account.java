package com.ajsw.javausersservice.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account")
    @Getter
    @Setter
    private int idAccount;

    @Basic
    @Column(name = "email", nullable = false, unique = true)
    @Getter
    @Setter
    private String email;

    @Basic
    @Column(name = "password", nullable = false)
    @Getter
    @Setter
    private String password;

    @Basic
    @Column(name = "created_at", nullable = false, columnDefinition = "date DEFAULT 'now()'")
    @Getter
    @Setter
    private Date createdAt = new Date(System.currentTimeMillis());

    @Basic
    @Column(name = "updated_at")
    @Getter
    @Setter
    private Date updatedAt;

    @Basic
    @Column(name = "active")
    @Getter
    @Setter
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "id_role")
    @Getter
    @Setter
    private Role role;

    public Account(String email, String password, Boolean active, Role role) {
        this.email = email;
        this.password = password;
        this.createdAt = new Date(System.currentTimeMillis());
        this.active = active;
        this.role = role;
    }

    public Account(int idAccount) {
        this.idAccount = idAccount;
    }

    public Account() {

    }
}
