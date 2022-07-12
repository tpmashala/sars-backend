package za.recruitment.sars.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.PhoneNumber;
import za.recruitment.sars.repository.EmployeeRepository;
import za.recruitment.sars.repository.PhoneNumberRespository;
import za.recruitment.sars.service.PhoneNumberService;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

	@Autowired
	PhoneNumberRespository phoneNumberRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public PhoneNumber findById(Long id) {
		return phoneNumberRepository.findById(id).orElse(null);
	}

	@Override
	public List<PhoneNumber> findAllPhoneNumbers() {
		
		return phoneNumberRepository.findAll();
	}
	
	public List<PhoneNumber> findAllPhoneNumberesByEmpId(Long empId){
		List<PhoneNumber> addresses = null;//phoneNumberRepository.findAllPhoneNumbersByEmpId(empId);
		return addresses;
	}

	@Override
	public PhoneNumber savePhoneNumber(PhoneNumber phoneNumber) {
		
		return phoneNumberRepository.save(phoneNumber);
	}

	@Override
	public List<PhoneNumber> savePhoneNumbers(List<PhoneNumber> phoneNumbers) {
		
		return phoneNumberRepository.saveAll(phoneNumbers);
	}

	@Override
	public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber) {
		PhoneNumber updatedPhoneNumber = phoneNumberRepository.findById(phoneNumber.getId()).orElse(null);
		
		updatedPhoneNumber.setPhoneNumber(phoneNumber.getPhoneNumber());
		updatedPhoneNumber.setPhoneNumberType(phoneNumber.getPhoneNumberType());

		return phoneNumberRepository.save(updatedPhoneNumber);
	}

	@Override
	public PhoneNumber deletePhoneNumber(Long id) {
		PhoneNumber deletedPhoneNumber = phoneNumberRepository.findById(id).orElse(null);
		
		if(deletedPhoneNumber != null) {
			phoneNumberRepository.deleteById(id);
			return deletedPhoneNumber;
		} else {
			return null;
		}
	
	}

	@Override
	public PhoneNumber deleteAllPhoneNumbersByEmployeeId(Employee emp) {
		//employeeRepository.findById(null)
		//List<PhoneNumber> deletedPhoneNumberes = findAllPhoneNumberesByEmpId(emp.getId());

		return null; //phoneNumberRepository.deleteAllPhoneNumbersByEmployeeId(emp.getId());
	}

	@Override
	public List<PhoneNumber> findAllPhoneNumbersByEmpId(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
