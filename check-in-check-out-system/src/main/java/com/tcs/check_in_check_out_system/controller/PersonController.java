package com.tcs.check_in_check_out_system.controller;

import com.tcs.check_in_check_out_system.model.EmployeeModel;
import com.tcs.check_in_check_out_system.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/checkin")
    public ResponseEntity<EmployeeModel> loginCheckIn(@RequestParam String name , @RequestParam String department, @RequestParam String position, @RequestParam String email, @RequestParam String phone){
        if (name.isEmpty() || department.isEmpty() || position.isEmpty() || email.isEmpty() || phone.isEmpty()) {
           return  ResponseEntity.notFound().build();
        } else {
            EmployeeModel employeeModel = personService.registerCheckIn(name,department,position,email,phone);
            return ResponseEntity.ok(employeeModel);
        }
    }

    @GetMapping("/records")
    public ResponseEntity<List <EmployeeModel>> getRecords(){
        List<EmployeeModel> records = personService.getRecords();
        return ResponseEntity.ok(records);
    }

    @PutMapping("/{id}/checkout")
    public ResponseEntity<EmployeeModel> updateCheckOut(@PathVariable Long id) {
        try {
            EmployeeModel employeeModel = personService.updateCheckOut(id);
            return ResponseEntity.ok(employeeModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/name") //name
    public ResponseEntity<EmployeeModel> updateName(@PathVariable Long id, @RequestParam String name){
        try {
            EmployeeModel employeeModel = personService.updateName(id,name);
            return ResponseEntity.ok(employeeModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/position") //position
    public ResponseEntity<EmployeeModel> updatePosition(@PathVariable Long id, @RequestParam String position){
        try {
            EmployeeModel employeeModel = personService.updatePosition(id,position);
            return ResponseEntity.ok(employeeModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/email") //email
    public ResponseEntity<EmployeeModel> updateEmail(@PathVariable Long id, @RequestParam String email){
        try {
            EmployeeModel employeeModel = personService.updateEmail(id,email);
            return ResponseEntity.ok(employeeModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/phone") //phone
    public ResponseEntity<EmployeeModel> updatePhone(@PathVariable Long id, @RequestParam String phone){
        try {
            EmployeeModel employeeModel = personService.updatePhone(id,phone);
            return ResponseEntity.ok(employeeModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/department") //phone
    public ResponseEntity<EmployeeModel> updateDepartment(@PathVariable Long id, @RequestParam String department){
        try {
            EmployeeModel employeeModel = personService.updateDepartment(id,department);
            return ResponseEntity.ok(employeeModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/record")
    public ResponseEntity<List <EmployeeModel>> getRecordId(@PathVariable Long id){
        List<EmployeeModel> records = personService.getRecordId(id);
        return ResponseEntity.ok(records);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        personService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
