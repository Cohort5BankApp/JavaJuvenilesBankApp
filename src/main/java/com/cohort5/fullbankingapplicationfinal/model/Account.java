package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	public Account (){}

	public Account(Long id, Type type, String nickname, Integer rewards, Double balance, Customer customer) {
		this.id = id;
		this.type = type;
		this.nickname = nickname;
		this.rewards = rewards;
		this.balance = balance;
		this.customer = customer;
	}

	@GeneratedValue
	@Id
	private Long id;

	private Type type;

	private enum Type {
		Savings,Checking,Credit
	}

	private String nickname;

	private Integer rewards;

	private Double balance;

	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getAccounttype() {
		return type;
	}

	public void setAccounttype(Type accounttype) {
		this.type = accounttype;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getRewards() {
		return rewards;
	}

	public void setRewards(Integer rewards) {
		this.rewards = rewards;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
