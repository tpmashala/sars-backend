package za.recruitment.sars.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.PhoneNumber;
import za.recruitment.sars.model.SocialMedia;
import za.recruitment.sars.repository.EmployeeRepository;
import za.recruitment.sars.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/*public Employee saveEmployee(Employee employee, Address address, PhoneNumber phoneNumbers, SocialMedia smedia) {		
		return employeeRepository.save(employee, address, phoneNumbers, smedia);
	}*/
	
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(long id, Employee employee) {
		Employee updatedEmployee = employeeRepository.findById(id).orElse(null);
		
		if(employee.getFirstName() != null) {updatedEmployee.setFirstName(employee.getFirstName());}
		
		if(employee.getLastName() != null) {updatedEmployee.setLastName(employee.getLastName());}
		
		if(employee.getEmployeeNumber() != null) {updatedEmployee.setEmployeeNumber(employee.getEmployeeNumber());}
		
		//updatedEmployee.setPhoneNumber(employee.getPhoneNumber());
		
		if(employee.getEmailAddress() != null) {updatedEmployee.setEmailAddress(employee.getEmailAddress());}
		
		if(employee.getSocialMedia() != null) {updatedEmployee.setSocialMedia(employee.getSocialMedia());}
		
		//updatedEmployee.setEmployeeAddress(employee.getEmployeeAddress());
		return employeeRepository.save(updatedEmployee);
	}

	@Override
	public Employee deleteEmployee(Long id) {
		Employee deletedEmployee = employeeRepository.findById(id).orElse(null);
		if(deletedEmployee != null) {
			employeeRepository.deleteById(id);
			return deletedEmployee;
			}
		else {
			return null;
		}
		
	}
	
}
