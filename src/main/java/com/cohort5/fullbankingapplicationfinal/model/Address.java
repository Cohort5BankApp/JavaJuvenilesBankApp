package com.cohort5.fullbankingapplicationfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {


	@GeneratedValue
	@Id
	private Long address_id;

	private String street_number;
	private String street_name;
	private String city;
	private String state;
	private String zip;

	public Address(){}

	public Address(Long address_id, String street_number, String street_name, String city, String state, String zip) {
		this.address_id = address_id;
		this.street_number = street_number;
		this.street_name = street_name;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
