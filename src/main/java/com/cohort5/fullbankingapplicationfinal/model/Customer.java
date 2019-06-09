package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Customer {

	@GeneratedValue
	@Id
	Long customer_id;

	private String first_name;
	private String last_name;
	private Set<Address> addresses;

	public Customer() {
	}

	public Customer(Long customer_id, String first_name, String last_name, Set<Address> addresses) {
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.addresses = addresses;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
