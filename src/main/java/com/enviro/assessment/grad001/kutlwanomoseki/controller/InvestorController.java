package com.enviro.assessment.grad001.kutlwanomoseki.controller;

import com.enviro.assessment.grad001.kutlwanomoseki.model.Investor;
import com.enviro.assessment.grad001.kutlwanomoseki.repository.InvestorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {
    @Autowired
    private InvestorRepo investorRepo;

    @GetMapping("/getAllInvestors")
    public ResponseEntity<List<Investor>> getAllInvestors() {
        try {
            List<Investor> investorList = new ArrayList<>();
            investorRepo.findAll().forEach(investorList::add);

            if (investorList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(investorList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInvestorById/{investorId}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long investorId) {
        Optional<Investor> investorData = investorRepo.findById(investorId);

        if (investorData.isPresent()) {
            return new ResponseEntity<>(investorData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addInvestor")
    public ResponseEntity<Investor> addInvestor(@RequestBody Investor investor) {
        if (isInvalidInvestorData(investor)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Investor investorObj = investorRepo.save(investor);
        return new ResponseEntity<>(investorObj, HttpStatus.OK);
    }

    private boolean isInvalidInvestorData(Investor investor) {
        return investor == null || investor.getName() == null || investor.getLastName() == null || investor.getAge() == null ||
                investor.getAddress() == null || investor.getContact() == null;
    }

    @PutMapping("/updateInvestorById/{investorId}")
    public ResponseEntity<Investor> updateInvestorById(@PathVariable Long investorId, @RequestBody Investor updatedInvestor) {
        Optional<Investor> oldData = investorRepo.findById(investorId);

        if (oldData.isPresent()) {
            Investor updatedInvestorData = oldData.get();
            updatedInvestorData.setName(updatedInvestor.getName());
            updatedInvestorData.setLastName(updatedInvestor.getLastName());
            updatedInvestorData.setAge(updatedInvestor.getAge());
            updatedInvestorData.setContact(updatedInvestor.getContact());
            updatedInvestorData.setAddress(updatedInvestor.getAddress());

            Investor investorObj = investorRepo.save(updatedInvestorData);
            return new ResponseEntity<>(investorObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteInvestorById/{investorId}")
    public ResponseEntity<Void> deleteInvestor(@PathVariable Long investorId) {
        investorRepo.deleteById(investorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


