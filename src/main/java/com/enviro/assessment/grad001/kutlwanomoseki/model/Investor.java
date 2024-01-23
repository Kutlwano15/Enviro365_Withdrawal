package com.enviro.assessment.grad001.kutlwanomoseki.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Investors")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long investorId;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @OneToMany(mappedBy = "productInvestorId")
    private List<Product> products;

    public Investor(Long investorId, String name, String lastName, Integer age, String address, String contact, List<Product> products) {
        this.investorId = investorId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.products = products;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}