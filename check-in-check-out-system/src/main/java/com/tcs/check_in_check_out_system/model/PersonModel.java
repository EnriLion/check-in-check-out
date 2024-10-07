package com.tcs.check_in_check_out_system.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String namePerson;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

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

    public LocalDateTime getCheckInTime(){
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime){
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime(){
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime){
        this.checkOutTime = checkOutTime;
    }

}
