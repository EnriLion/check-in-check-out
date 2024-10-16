package com.tcs.check_in_check_out_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String department;

    private String position;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //Set cascade to manage check-ins
    @JsonManagedReference
    private List<CheckInModel> checkIns = new ArrayList<>();


//   public List<CheckInModel> getCheckIns(){
//        return  checkIns;
//    }
//    public void setCheckIns(List<CheckInModel> checkIns){
//        this.checkIns = checkIns;
//    }

}
