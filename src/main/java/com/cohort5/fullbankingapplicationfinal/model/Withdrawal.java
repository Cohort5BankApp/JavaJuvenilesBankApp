package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue
    private Long id;
    private enum type{
        p2p, deposit, withdrawal
    }
    private String transaction_date;
    private String status;
    private Long payer_id;
    private enum medium{
        balance, rewards
    }
    private Double amount;
    private String description;

    public Withdrawal() {
    }

    public Withdrawal(Long id, String transaction_date, String status, Long payer_id, Double amount, String description) {
        this.id = id;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payer_id = payer_id;
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

    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        this.payer_id = payer_id;
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
        return "Withdrawal{" +
                "id=" + id +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", payer_id=" + payer_id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}