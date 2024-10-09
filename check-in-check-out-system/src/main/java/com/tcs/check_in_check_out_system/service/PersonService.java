package com.tcs.check_in_check_out_system.service;

import com.tcs.check_in_check_out_system.model.EmployeeModel;
import com.tcs.check_in_check_out_system.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.time.LocalDateTime.now;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    //1) Allows users to register a check-in //Post
    //2) Retrieve check-in and check-out records. //Get
    //3) Handle updating the check-out time when a person leaves the facility //Update
    //4) Provide functionality for deleting records if needed //Delete
    //5) Update each field
    //6) Get records by id

    //1
    public EmployeeModel registerCheckIn(String name, String department, String position, String email, String phone) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setName(name);
        employeeModel.setCheckInTime(LocalDateTime.now());
        employeeModel.setCheckOutTime(LocalDateTime.now());
        employeeModel.setDepartment(department);
        employeeModel.setPosition(position);
        employeeModel.setEmail(email);
        employeeModel.setPhone(phone);
        return personRepository.save(employeeModel);
    }

    //2
    public List<EmployeeModel> getRecords(){
        List<EmployeeModel> records = new ArrayList<>();
        for(EmployeeModel employeeModel : personRepository.findAll()){
            records.add(employeeModel);
        }
        return records;
    }

    //3
    public EmployeeModel updateCheckOut(Long id) {
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        employeeModel.setCheckOutTime(now());
        EmployeeModel updatedPerson = personRepository.save(employeeModel);
        return updatedPerson;
    }

    //4
    public void deleteRecord(Long id){
        personRepository.deleteById(id);
    }

    //5
    public EmployeeModel updateName(Long id, String name) {
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        employeeModel.setName(name);
        EmployeeModel updatedPerson = personRepository.save(employeeModel);
        return updatedPerson;
    }

    public EmployeeModel updatePosition(Long id, String position){
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        employeeModel.setPosition(position);
        return personRepository.save(employeeModel);
    }

    public EmployeeModel updateEmail(Long id, String  email) {
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        employeeModel.setEmail(email);
        return personRepository.save(employeeModel);
    }

    public EmployeeModel updatePhone(Long id, String  phone) {
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        employeeModel.setPhone(phone);
        return personRepository.save(employeeModel);
    }

    public EmployeeModel updateDepartment(Long id, String  department) {
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        employeeModel.setDepartment(department);
        return personRepository.save(employeeModel);
    }

    //6
    public List<EmployeeModel> getRecordId(Long id){
        EmployeeModel employeeModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        List<EmployeeModel> records = new LinkedList<>();
        records.add(employeeModel);
        return records;
    }

}
