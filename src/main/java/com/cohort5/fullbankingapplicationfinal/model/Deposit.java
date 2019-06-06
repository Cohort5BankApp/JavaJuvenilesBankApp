package com.cohort5.fullbankingapplicationfinal.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deposit {

    @Id
    @GeneratedValue
    private Long id;

    private enum type {
        p2p, deposit, withdraws
    }

    private String transaction_date;
    private String status;
    private Long payee_id;

    private enum medium {
        balance, rewards
    }

    private Double amount;
    private String description;

    public Deposit() {
    }

    public Deposit(Long id, String transaction_date, String status, Long payee_id, Double amount, String description) {
        this.id = id;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payee_id = payee_id;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(Long payee_id) {
        this.payee_id = payee_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", payee_id=" + payee_id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}