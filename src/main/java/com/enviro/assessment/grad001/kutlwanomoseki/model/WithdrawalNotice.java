package com.enviro.assessment.grad001.kutlwanomoseki.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Table;
@Entity
@Table(name = "WithdrawalNotices")
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long withdrawalNoticeId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "withdrawal_amount")
    private BigDecimal withdrawalAmount;
    @Column(name = "withdrawal_date")
    private Date withdrawalDate;


    public WithdrawalNotice(Long withdrawalNoticeId, Product product, BigDecimal withdrawalAmount, Date withdrawalDate) {
        this.withdrawalNoticeId = withdrawalNoticeId;
        this.product = product;
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
    }

    public Long getWithdrawalNoticeId() {
        return withdrawalNoticeId;
    }

    public void setWithdrawalNoticeId(Long withdrawalNoticeId) {
        this.withdrawalNoticeId = withdrawalNoticeId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }
}
