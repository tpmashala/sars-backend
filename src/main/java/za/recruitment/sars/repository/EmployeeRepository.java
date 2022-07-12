package za.recruitment.sars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.PhoneNumber;
import za.recruitment.sars.model.SocialMedia;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	/*@Override
	@Query("INSERT INTO EMPLOYEE e VALUES ("+ employee.getFirstName() +","+ employee.getLastName()+","+");"
			+ "INSERT INTO ADDRESS a VALUES ();"
			+ "INSERT INTO PHONENUMBER p VALUES ();"
			+ "INSERT INTO SOCIALMEDIA s VALUES ();")
	public Employee saveEmployee(Employee employee, Address address, PhoneNumber phoneNumbers, SocialMedia smedia);*/

	

}
