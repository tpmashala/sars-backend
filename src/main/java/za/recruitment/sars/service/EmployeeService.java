package za.recruitment.sars.service;

import java.util.List;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.PhoneNumber;
import za.recruitment.sars.model.SocialMedia;

public interface EmployeeService {
	
	public Employee findById(Long id);
	
	public List<Employee> findAllEmployees();
	
	public Employee saveEmployee(Employee employee);
	
	//public Employee saveEmployee(Employee employee, Address address, PhoneNumber phoneNumbers, SocialMedia smedia);
	
	public Employee updateEmployee(long id, Employee employee);
	
	public Employee deleteEmployee(Long id);
}
