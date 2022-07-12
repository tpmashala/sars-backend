package za.recruitment.sars.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "PHONENUMBER")
@JsonInclude(value = Include.NON_NULL)
public class PhoneNumber implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Column(name = "id")
	@SequenceGenerator(name = "sequence", sequenceName = "phone_number_sequence", allocationSize = 1)
	private long id;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "phone_number_type")
	@Enumerated(EnumType.STRING) 
	private PhoneNumberType phoneNumberType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@JsonBackReference
	private Employee employee;
	
	public PhoneNumber() {

	}
	
	public PhoneNumber(String phoneNumber, PhoneNumberType phoneNumberType, Employee employee) {
		this.phoneNumber = phoneNumber;
		this.phoneNumberType = phoneNumberType;
		this.employee = employee;
	}
	
	public String toString() {
		return "phone number: "+ this.getPhoneNumber() + " phone number type: "+this.getPhoneNumberType();
	}

}
