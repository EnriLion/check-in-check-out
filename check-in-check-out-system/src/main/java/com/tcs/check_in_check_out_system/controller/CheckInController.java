package com.tcs.check_in_check_out_system.controller;


import com.tcs.check_in_check_out_system.model.CheckInModel;
import com.tcs.check_in_check_out_system.model.EmployeeModel;
import com.tcs.check_in_check_out_system.repository.CheckInRepository;
import com.tcs.check_in_check_out_system.repository.EmployeeRepository;
import com.tcs.check_in_check_out_system.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/v1/check")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @PostMapping
    public ResponseEntity<CheckInModel> createCheckIn(@RequestParam Long employeeId) {
        CheckInModel newCheckIn = checkInService.createdCheckIn(employeeId);
        return new ResponseEntity<>(newCheckIn, HttpStatus.CREATED);
    }
}
