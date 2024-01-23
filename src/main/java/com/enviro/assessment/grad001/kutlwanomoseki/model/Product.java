package com.enviro.assessment.grad001.kutlwanomoseki.model;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "current_balance")
    private BigDecimal currentBalance;
    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor productInvestorId;

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
    public Investor getProductInvestorId() {
        return productInvestorId;
    }
    public void setProductInvestorId(Investor productInvestorId) {
        this.productInvestorId = productInvestorId;
    }
}
