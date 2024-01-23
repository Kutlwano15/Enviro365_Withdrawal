package com.enviro.assessment.grad001.kutlwanomoseki.service;

import com.enviro.assessment.grad001.kutlwanomoseki.model.Product;
import com.enviro.assessment.grad001.kutlwanomoseki.model.WithdrawalNotice;
import com.enviro.assessment.grad001.kutlwanomoseki.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawalNoticeService {
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<Object> validateWithdrawalNotice(Long productId,WithdrawalNotice withdrawalNotice) {
        Product product = productRepo.findById(productId).orElse(null);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        if (withdrawalNotice.getWithdrawalAmount().compareTo(product.getCurrentBalance()) > 0) {
            return new ResponseEntity<>("Withdrawal amount exceeds current balance", HttpStatus.BAD_REQUEST);
        }

        if ("RETIREMENT".equals(product.getType()) && product.getProductInvestorId().getAge() <= 65) {
            return new ResponseEntity<>("Investor must be older than 65 for RETIREMENT withdrawals", HttpStatus.BAD_REQUEST);
        }
        BigDecimal maxWithdrawalAmount = product.getCurrentBalance().multiply(new BigDecimal("0.9"));
        if (withdrawalNotice.getWithdrawalAmount().compareTo(maxWithdrawalAmount) > 0) {
            return new ResponseEntity<>("Withdrawal amount cannot exceed 90% of the current balance.", HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}