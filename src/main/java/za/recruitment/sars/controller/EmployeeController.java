package za.recruitment.sars.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.PhoneNumber;
import za.recruitment.sars.model.SocialMedia;
import za.recruitment.sars.service.AddressService;
import za.recruitment.sars.service.EmployeeService;
import za.recruitment.sars.service.PhoneNumberService;

@RestController
@RequestMapping(value = "/api/v1/employee", produces = "application/json")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PhoneNumberService phoneNumberService;
	
	//@Autowired
	//private SocialMediaService socialMediaService; 
	
	@ApiOperation(value = "Get single employee from DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The employee was retrieved successfully", response = Employee.class),
			@ApiResponse(code = 400, message = "There's a problem with the sent request"),
			@ApiResponse(code = 403, message = "Access to the requested employee details is forbidden"),
			@ApiResponse(code = 404, message = "The requested employee details were not found"),
			@ApiResponse(code = 500, message = "Internal error occured") })
	@GetMapping(value = "/{id}", produces = "application/json")
	public Employee getById(@PathVariable("id") Long Id) {
		return employeeService.findById(Id);
	}
	
	@ApiOperation(value = "Get all employee details from DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The employee details were retrieved successfully", response = Employee.class),
			@ApiResponse(code = 400, message = "There is a problem with the sent request"),
			@ApiResponse(code = 403, message = "Access to employee details is forbidden"),
			@ApiResponse(code = 404, message = "The requested employee details were not found"),
			@ApiResponse(code = 500, message = "Internal error occured") })
	@GetMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Object> getAllEmployees(){
		return new ResponseEntity<>( employeeService.findAllEmployees(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Save employee details to the DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The employee details were successfully stored on the DB", response = Employee.class),
			@ApiResponse(code = 201, message = "The employee details were successfully stored on the DB", response = Employee.class),
			@ApiResponse(code = 400, message = "There is a problem with the sent request"),
			@ApiResponse(code = 403, message = "Access to the requested employee details is forbidden"),
			@ApiResponse(code = 404, message = "The requested employee details were not found"),
			@ApiResponse(code = 500, message = "Internal error occured") })
	@PostMapping(consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		Set<Address> addresses = new HashSet<Address>(employee.getAddresses());
		Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>(employee.getPhoneNumbers());
		Set<SocialMedia> socialMedia = new HashSet<SocialMedia>(employee.getSocialMedia());
		
		Employee empl = new Employee();
		
		addresses.forEach( (address) -> {address.setEmployee(empl);});		
		phoneNumbers.forEach( phoneNumber -> phoneNumber.setEmployee(empl));
		socialMedia.forEach( scMedia -> scMedia.setEmployee(empl));
		
		empl.setFirstName(employee.getFirstName());
		empl.setLastName(employee.getLastName());
		empl.setEmployeeNumber(employee.getEmployeeNumber());
		empl.setEmailAddress(employee.getEmailAddress());
		empl.setPhoneNumbers(phoneNumbers);
		empl.setAddresses(addresses);
		empl.setSocialMedia(socialMedia);
		
		employeeService.saveEmployee(empl);
			
		return new ResponseEntity<>( empl , HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Update single employee details in the DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The employee details were successfully updated", response = Employee.class),
			@ApiResponse(code = 400, message = "There is a problem with the sent request"),
			@ApiResponse(code = 403, message = "Access to the requested employee details is forbidden"),
			@ApiResponse(code = 404, message = "The requested employee details were not found"),
			@ApiResponse(code = 500, message = "Internal error occured") })
	@PutMapping(value = "/{id}", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return new ResponseEntity<>( employeeService.updateEmployee(id, employee) , HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update particular employee details in the DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The employee details were successfully updated", response = Employee.class),
			@ApiResponse(code = 400, message = "There is a problem with the sent request"),
			@ApiResponse(code = 403, message = "Access to the requested employee details is forbidden"),
			@ApiResponse(code = 404, message = "The requested employee details were not found"),
			@ApiResponse(code = 500, message = "Internal error occured") })
	@PatchMapping(value = "/{id}", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> patchEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return new ResponseEntity<>( employeeService.updateEmployee(id, employee) , HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete an employee from the DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The employee was successfully deleted", response = Employee.class),
			@ApiResponse(code = 400, message = "There's a problem with the sent request"),
			@ApiResponse(code = 403, message = "Access to the requested employee details is forbidden"),
			@ApiResponse(code = 404, message = "The requested employee details were not found"),
			@ApiResponse(code = 500, message = "Internal error occured") })
	@DeleteMapping(value = "{id}", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> deleteEmployee(@RequestAttribute("empId") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<> ( employeeService.deleteEmployee(id) , HttpStatus.OK);
	}
	
}
