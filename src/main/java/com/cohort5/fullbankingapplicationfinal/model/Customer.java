package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {

	@GeneratedValue
	@Id
	Long customer_id;

	String first_name;

	String last_name;

	@OneToMany(cascade = CascadeType.ALL)
	List<Address> addresses;

	public Customer() {
	}

	public Customer(Long customer_id, String first_name, String last_name, List<Address> addresses) {
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
