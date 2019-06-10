package com.cohort5.fullbankingapplicationfinal.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Deposit{

    @Id
    @GeneratedValue
    private Long id;

    private enum Type {
        p2p, deposit, withdraws
    }

    private Type type;
    private String transaction_date;
    private enum Status{
        pending, cancelled, completed, reccuring
    }
    private Status status;
    private Long account_id;

    private enum Medium {
        balance, rewards
    }

    private Medium medium;
    private Double amount;
    private String description;

    public Deposit() {
    }

    public Deposit(Long id, Type type, String transaction_date, Status status, Long account_id, Medium medium, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.account_id = account_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
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
                ", type=" + type +
                ", transaction_date='" + transaction_date + '\'' +
                ", status=" + status +
                ", account_id=" + account_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}