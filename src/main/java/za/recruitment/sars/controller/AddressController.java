package za.recruitment.sars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.service.AddressService;

@RestController
@RequestMapping(value = "api/v1/address", produces = "application/json")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{addressId}")
	public Address getById(@RequestAttribute("addressId") Long Id) {
		return addressService.findById(Id);
	}
	
	@GetMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> getAllEmployees(){
		return new ResponseEntity<>( addressService.findAllAddresses(), HttpStatus.OK);
	}
	
	@PostMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> addAddress(Address address) {
		return new ResponseEntity<>( addressService.saveAddress(address) , HttpStatus.CREATED);
		
	}
	
	@PutMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> updateAddress(@RequestAttribute("addressId") long id, Address address) {
		return new ResponseEntity<>( addressService.updateAddress(address) , HttpStatus.OK);
	}
	
	@DeleteMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> deleteEmployee(@RequestAttribute("addressId") Long id) {
		addressService.deleteAddress(id);
		return new ResponseEntity<> ( addressService.deleteAddress(id) , HttpStatus.OK);
	}
}


