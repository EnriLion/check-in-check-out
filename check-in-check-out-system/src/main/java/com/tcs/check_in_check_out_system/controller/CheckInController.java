package com.tcs.check_in_check_out_system.controller;


import com.tcs.check_in_check_out_system.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/api/v1/check")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @PutMapping("/{checkInId}/status")
    public ResponseEntity<CheckInModel> createCheckIn(@PathVariable Long checkInId) {
        try {
            CheckInModel newCheckIn = checkInService.updateStatus(checkInId);
            return ResponseEntity.ok(newCheckIn);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("records")
    public ResponseEntity<List<CheckInModel>> getRecords(){
        try {
            List<CheckInModel> records = checkInService.getRecords();
            return ResponseEntity.ok(records);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{checkInId}/record")
    public ResponseEntity<List <CheckInModel>> getRecordId(@PathVariable Long checkInId){
        List<CheckInModel> records = checkInService.getRecordId(checkInId);
        return ResponseEntity.ok(records);
    }

    @DeleteMapping("/{checkInId}/delete")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long checkInId){
        checkInService.deleteRecord(checkInId);
        return ResponseEntity.noContent().build();
    }

}
