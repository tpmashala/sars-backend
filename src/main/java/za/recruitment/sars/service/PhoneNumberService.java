package za.recruitment.sars.service;

import java.util.List;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.PhoneNumber;

public interface PhoneNumberService {

	public PhoneNumber findById(Long id);
	
	public List<PhoneNumber> findAllPhoneNumbers();
	
	public List<PhoneNumber> findAllPhoneNumbersByEmpId(Long empId);
	
	public PhoneNumber savePhoneNumber(PhoneNumber phoneNumber);
	
	public List<PhoneNumber> savePhoneNumbers(List<PhoneNumber> phoneNumber);
	
	public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber);
	
	public PhoneNumber deletePhoneNumber(Long id);
	
	public PhoneNumber deleteAllPhoneNumbersByEmployeeId(Employee emp);
}
