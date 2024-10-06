package com.tcs.check_in_check_out_system.controller;

import com.tcs.check_in_check_out_system.model.PersonModel;
import com.tcs.check_in_check_out_system.service.PersonService;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/checkin")
    public ResponseEntity<PersonModel> loginCheckIn(@RequestParam String namePerson){
        PersonModel personModel = personService.registerCheckIn(namePerson);
        return ResponseEntity.ok(personModel);
    }

    @GetMapping("/records")
    public ResponseEntity<List <PersonModel>> getRecords(){
        List<PersonModel> records = personService.getRecords();
        return ResponseEntity.ok(records);
    }

    @PutMapping("/{id}/checkout")
    public ResponseEntity<PersonModel> updateCheckOut(@PathVariable Long id) {
        try {
            PersonModel personModel = personService.updateCheckOut(id);
            return ResponseEntity.ok(personModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        personService.deleteRecord(id);
        return ResponseEntity.noContent().build(); //204
    }
}
