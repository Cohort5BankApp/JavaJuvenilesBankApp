package com.cohort5.fullbankingapplicationfinal.model;

import org.apache.tomcat.jni.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.reflect.Type;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue
    private Long id;
    private enum type{
        p2p, deposit, withdrawal
    }
    private Type type;
    private String transaction_date;
    private enum status{
        pending, cancelled, completed, reccuring
    }
    private Status status;
    private Long payer_id;
    private enum Medium{
        balance, rewards
    }
    private Medium medium;
    private Double amount;
    private String description;

    public Withdrawal() {
    }

    public Withdrawal(Long id, Type type, String transaction_date, Status status, Long payer_id, Medium medium, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payer_id = payer_id;
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

    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        this.payer_id = payer_id;
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
        return "Withdrawal{" +
                "id=" + id +
                ", type=" + type +
                ", transaction_date='" + transaction_date + '\'' +
                ", status=" + status +
                ", payer_id=" + payer_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}