package za.recruitment.sars.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Column(name = "employee_id")
	@SequenceGenerator(name = "sequence", sequenceName = "employee_sequence", allocationSize = 1)
	private long employee_id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "employee_number")
	private String employeeNumber;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private Set<PhoneNumber> phoneNumbers = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    @JsonManagedReference
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private Set<SocialMedia> socialMedia = new HashSet<>();

	public Employee() {

	}
	
	public Employee(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.employeeNumber = employee.getEmployeeNumber();
		this.phoneNumbers = employee.getPhoneNumbers();
		this.emailAddress = employee.getEmailAddress();
		this.addresses = employee.getAddresses();
		this.socialMedia = employee.getSocialMedia();
	}

	public Employee(String firstName, String lastName, String employeeNumber, 
					Set<PhoneNumber> phoneNumbers, String emailAddress, Set<Address> addresses, Set<SocialMedia> socialMedia) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.phoneNumbers = phoneNumbers;
		this.emailAddress = emailAddress;
		this.addresses = addresses;
		this.socialMedia = socialMedia;
	}
	
	public String toString() {
		return "Firstname: "+this.getFirstName() + " Lastname: " + this.getLastName()+ " email address: "+ this.getEmailAddress() + 
				" employee number: "+ this.getEmployeeNumber() +" phone number: "+ this.getPhoneNumbers()+ " addresses: "+ this.getAddresses()+
				" social media: "+ this.getSocialMedia();
	}
	
}
