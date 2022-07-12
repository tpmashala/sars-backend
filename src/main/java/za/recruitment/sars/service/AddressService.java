package za.recruitment.sars.service;

import java.util.List;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;

public interface AddressService {

	public Address findById(Long id);
	
	public List<Address> findAllAddresses();
	
	//EMPLOYEE_TBL
	//public List<Address> findAllAddressesByEmpId(Long empId);
	
	public Address saveAddress(Address address);
	
	public List<Address> saveAddresses(List<Address> address);
	
	public Address updateAddress(Address address);
	
	public Address deleteAddress(Long id);
	
	public Address deleteAllEmployeeAddresses(Employee emp);
}
