package com.tcs.check_in_check_out_system.service;

import com.tcs.check_in_check_out_system.model.PersonModel;
import com.tcs.check_in_check_out_system.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    //1) Allows users to register a check-in //Post
    //2) Retrieve check-in and check-out records. //Get
    //3) Handle updating the check-out time when a person leaves the facility //Update
    //4) Provide functionality for deleting records if needed //Delete

    //1
    public PersonModel registerCheckIn(String namePerson) {
        PersonModel personModel = new PersonModel();
        personModel.setNamePerson(namePerson);
//        personModel.setCheckInTime(checkInTime);
        personModel.setCheckOutTime(LocalDateTime.now());
        return personRepository.save(personModel);
    }

    //2
    public List<PersonModel> getRecords(){
        List<PersonModel> records = new ArrayList<>();
        for(PersonModel personModel : personRepository.findAll()){
            records.add(personModel);
        }
        return records;
    }

    //3
    public PersonModel updateCheckOut(Long id) {
        PersonModel personModel = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
        personModel.setCheckOutTime(LocalDate.now());
        PersonModel updatedPerson = personRepository.save(personModel);
        return updatedPerson;
    }


    //4
    public void deleteRecord(Long id){
        personRepository.deleteById(id);
    }

}
