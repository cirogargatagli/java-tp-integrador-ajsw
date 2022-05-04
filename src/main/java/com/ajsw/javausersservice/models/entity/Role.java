package com.ajsw.javausersservice.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "public", catalog = "d9sp9r36nrg2j2")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_role")
    private int idRole;
    @Basic
    @Column(name = "description")
    private String description;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role that = (Role) o;
        return idRole == that.idRole && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, description);
    }
}
