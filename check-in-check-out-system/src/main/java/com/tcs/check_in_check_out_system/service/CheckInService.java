package com.tcs.check_in_check_out_system.service;

import com.tcs.check_in_check_out_system.model.CheckInModel;
import com.tcs.check_in_check_out_system.model.EmployeeModel;
import com.tcs.check_in_check_out_system.repository.CheckInRepository;
import com.tcs.check_in_check_out_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public CheckInModel createdCheckIn(Long employeeId){
        EmployeeModel employeeModel = employeeRepository.findById(employeeId).orElseThrow(NoSuchFieldError::new);
        CheckInModel checkInModel = new CheckInModel();
        checkInModel.setCheckInTime(LocalDateTime.now());
        checkInModel.setStatus(false);
        checkInModel.setEmployee(employeeModel);
        return checkInRepository.save(checkInModel);
    }


}
