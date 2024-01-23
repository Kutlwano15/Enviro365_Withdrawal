package com.enviro.assessment.grad001.kutlwanomoseki.repository;

import com.enviro.assessment.grad001.kutlwanomoseki.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long>{
    Optional<Product> findByInvestorId(Long productInvestorId);


}
