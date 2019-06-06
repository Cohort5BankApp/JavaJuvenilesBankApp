package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	public Account (){}

	public Account(Long id, Type type, String nickname, Integer rewards, Double balance, Long customer_id) {
		this.id = id;
		this.type = type;
		this.nickname = nickname;
		this.rewards = rewards;
		this.balance = balance;
		this.customer_id = customer_id;
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

	private Long customer_id;

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

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
}

