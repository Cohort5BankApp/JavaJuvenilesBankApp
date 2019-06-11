package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

	@GeneratedValue
	@Id
	private Long account_id;

	@NotNull
	private Type type;

	private enum Type {
		Savings,Checking,Credit
	}

	@NotNull
	private String nickname;

	@NotNull
	private Integer rewards;

	@NotNull
	private Double balance;

	@NotNull
	private Long customer_id;

	public Account (){}

	public Account(Long account_id, Type type, String nickname, Integer rewards, Double balance, Long customer_id) {
		this.account_id = account_id;
		this.type = type;
		this.nickname = nickname;
		this.rewards = rewards;
		this.balance = balance;
		this.customer_id = customer_id;
	}


	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
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

