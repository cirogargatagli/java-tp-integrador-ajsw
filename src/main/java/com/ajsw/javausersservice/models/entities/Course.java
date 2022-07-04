package com.ajsw.javausersservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.jdi.NativeMethodException;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course")
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_course")
    private int idCourse;
    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;
    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;
    @Basic
    @Column(name = "price")
    private BigInteger price;
    @Basic
    @Column(name = "tittle")
    private String tittle;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "imageURL")
    private String imageURL;

    @ManyToOne
    @JoinColumn(
            name = "id_instructor",
            referencedColumnName = "id_person",
            foreignKey = @ForeignKey(
                    name = "fk_course_instructor",
                    foreignKeyDefinition = "FOREIGN KEY (id_instructor)\n" +
                            "        REFERENCES instructor (id_person) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Instructor instructor;

    @OneToOne
    @JoinColumn(name = "id_activity")
    private Activity activity;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_reserve"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserve> reserves;

    public Course() {
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getTittle() { return tittle; }

    public void setTittle(String tittle) { this.tittle = tittle; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
