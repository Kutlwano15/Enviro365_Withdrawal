package com.enviro.assessment.grad001.kutlwanomoseki.repository;
import com.enviro.assessment.grad001.kutlwanomoseki.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepo extends JpaRepository<Investor, Long> {
}
