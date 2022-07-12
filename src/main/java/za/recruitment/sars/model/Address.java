package za.recruitment.sars.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
@JsonInclude(value = Include.NON_NULL)
public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Column(name = "id")
	@SequenceGenerator(name = "sequence", sequenceName = "address_sequence", allocationSize = 1)
	private long id;

	@Column(name = "address_Line1")
	private String addressLine1;
	
	@Column(name = "address_Line2")
	private String addressLine2;

	@Column(name = "surburb")
	private String surburb;

	@Column(name = "city")
	private String city;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "address_type")
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@JsonBackReference
	private Employee employee;

	public Address() {

	}
	
	public Address(String addressLine1, String addressLine2, String surburb, String city, String postalCode, AddressType addressType, Employee employee) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.surburb = surburb;
		this.city = city;
		this.postalCode = postalCode;
		this.addressType = addressType;
		this.employee = employee;
	}
	
	public String toString() {
		return " Address Line 1: "+ this.getAddressLine1()+" Address Line 2: "+this.getAddressLine1()+" Surburb: "+
				this.getSurburb()+" City: "+this.getCity()+" PostalCode: "+this.getPostalCode()+ " AddressType: "+this.getAddressType();
	}

}
