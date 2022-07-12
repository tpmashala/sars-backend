package za.recruitment.sars.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.repository.AddressRespository;
import za.recruitment.sars.repository.EmployeeRepository;
import za.recruitment.sars.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRespository addressRepository;
	
	@Override
	public Address findById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public List<Address> findAllAddresses() {
		
		return addressRepository.findAll();
	}
	
	/*@Override
	public List<Address> findAllAddressesByEmpId(Long empId){
		List<Address> addresses = addressRepository.findAllAddressesByEmpId(empId);
		return null;	//addresses;
	}*/

	@Override
	public Address saveAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public List<Address> saveAddresses(List<Address> addresses) {
		
		return addressRepository.saveAll(addresses);
	}

	@Override
	public Address updateAddress(Address address) {
		Address updatedAddress = addressRepository.findById(address.getId()).orElse(null);
		
		updatedAddress.setAddressLine1(address.getAddressLine1());
		updatedAddress.setAddressLine2(address.getAddressLine2());
		updatedAddress.setSurburb(address.getSurburb());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setPostalCode(address.getPostalCode());
		updatedAddress.setAddressType(address.getAddressType());
//		updatedAddress.setEmployeeAddress(address.getEmployeeAddress());
		return addressRepository.save(updatedAddress);
	}

	@Override
	public Address deleteAddress(Long id) {
		Address deletedAddress = addressRepository.findById(id).orElse(null);
		
		if(deletedAddress != null) {
			addressRepository.deleteById(id);
			return deletedAddress;
		} else {
			return null;
		}
	
	}

	@Override
	public Address deleteAllEmployeeAddresses(Employee emp) {
		//employeeRepository.findById(null)
		//List<Address> deletedAddresses = findAllAddressesByEmpId(emp.getId());
		//addressRepository.deleteAllAddressesByEmployeeId(emp.getId());
		return null; 
	}

}
