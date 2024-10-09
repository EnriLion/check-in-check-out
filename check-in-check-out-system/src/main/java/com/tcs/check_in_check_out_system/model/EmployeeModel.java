package com.tcs.check_in_check_out_system.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    //Getter & Setters

    public Long getId(){
        return id;
    }

    public void setId(Long id){
       this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

}
