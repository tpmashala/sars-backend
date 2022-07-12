package za.recruitment.sars.controller;

import java.util.List;

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

import za.recruitment.sars.model.PhoneNumber;
import za.recruitment.sars.service.PhoneNumberService;

@RestController
@RequestMapping(value = "api/v1/phonenumber", produces = "application/json")
public class PhoneNumberController {

	@Autowired
	private PhoneNumberService phoneNumberService;
	
	@GetMapping(value = "/{id}")
	public PhoneNumber getById(Long Id) {
		return phoneNumberService.findById(Id);
	}
	
	@GetMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> getAllPhoneNumbers(){
		return new ResponseEntity<>( phoneNumberService.findAllPhoneNumbers(), HttpStatus.OK);
	}
		
	@PostMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> addPhoneNumber(PhoneNumber phoneNumber) {
		return new ResponseEntity<>( phoneNumberService.savePhoneNumber(phoneNumber) , HttpStatus.CREATED);
		
	}
	
	/*@PostMapping(value = "", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> addPhoneNumbers(List<PhoneNumber> phoneNumber) {
		return new ResponseEntity<>( phoneNumberService.savePhoneNumbers(phoneNumber) , HttpStatus.CREATED);
		
	}*/
	
	@PutMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> updatePhoneNumber(@RequestAttribute("phoneNumberId") long id, PhoneNumber phoneNumber) {
		return new ResponseEntity<>( phoneNumberService.updatePhoneNumber(phoneNumber) , HttpStatus.OK);
	}
	
	@DeleteMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> deletePhoneNumber(@RequestAttribute("addressId") Long id) {
		phoneNumberService.deletePhoneNumber(id);
		return new ResponseEntity<> ( phoneNumberService.deletePhoneNumber(id) , HttpStatus.OK);
	}
}


