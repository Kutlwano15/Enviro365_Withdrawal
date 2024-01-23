package com.enviro.assessment.grad001.kutlwanomoseki.controller;

import com.enviro.assessment.grad001.kutlwanomoseki.model.WithdrawalNotice;
import com.enviro.assessment.grad001.kutlwanomoseki.repository.WithdrawalNoticeRepo;
import com.enviro.assessment.grad001.kutlwanomoseki.service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/withdrawal")
public class WithdrawalNoticeController {

    @Autowired
    private WithdrawalNoticeRepo withdrawalNoticeRepo;
    @Autowired
    private WithdrawalNoticeService withdrawalNoticeService;

    @PostMapping("/create/{productId}")
    public ResponseEntity<Object> createWithdrawalNotice(@PathVariable Long productId, @RequestBody WithdrawalNotice withdrawalNotice){
      ResponseEntity<Object> validationResponse = withdrawalNoticeService.validateWithdrawalNotice(productId, withdrawalNotice);
        if (validationResponse != null) {
            return validationResponse;
        }
        WithdrawalNotice createdWithdrawalNotice = withdrawalNoticeRepo.save(withdrawalNotice);
        return new ResponseEntity<>(createdWithdrawalNotice, HttpStatus.CREATED);
    }
}
