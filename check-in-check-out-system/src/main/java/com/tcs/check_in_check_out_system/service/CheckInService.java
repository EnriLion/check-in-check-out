package com.tcs.check_in_check_out_system.service;

import com.tcs.check_in_check_out_system.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;

    public CheckInModel updateStatus(Long checkInId){
        CheckInModel checkInModel = checkInRepository.findById(checkInId).orElseThrow(NoSuchElementException::new);
        checkInModel.setCheckOutTime(LocalDateTime.now());
        checkInModel.setStatus(true);
        return checkInRepository.save(checkInModel);
    }

    //get all the checks
    public List<CheckInModel> getRecords(){
        List<CheckInModel> records = new ArrayList<>();
        for(CheckInModel checkInModel: checkInRepository.findAll()){
            records.add(checkInModel);
        }
        return records;
    }

    //get checks by ID
    public List<CheckInModel> getRecordId(Long checkInId){
        CheckInModel checkInModel = checkInRepository.findById(checkInId).orElseThrow(NoSuchElementException::new);
        List<CheckInModel> records = new LinkedList<>();
        records.add(checkInModel);
        return records;
    }

    //remove checks by ID
    public void deleteRecord(Long checkInId){
        CheckInModel checkInModel = checkInRepository.findById(checkInId).orElseThrow(NoSuchElementException::new);
        checkInRepository.delete(checkInModel);
    }
}
