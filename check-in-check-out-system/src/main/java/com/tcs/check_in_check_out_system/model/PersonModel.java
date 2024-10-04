package com.tcs.check_in_check_out_system.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String namePerson;

    @Column(name = "check_in_time")
    private LocalDate checkInTime;

    @Column(name = "check_out_time")
    private LocalDate checkOutTime;

    //Getter & Setters

    public Long getId(){
        return id;
    }

    public void setId(Long id){
       this.id = id;
    }

    public String getNamePerson(){
        return namePerson;
    }

    public void setNamePerson(String namePerson){
        this.namePerson = namePerson;
    }

    public LocalDate getCheckInTime(){
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime){
        this.checkInTime = checkInTime;
    }

    public LocalDate getCheckOutTime(){
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDate checkOutTime){
        this.checkOutTime = checkOutTime;
    }

}
