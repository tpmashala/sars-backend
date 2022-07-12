package za.recruitment.sars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.recruitment.sars.model.Address;

@Repository
@Transactional
public interface AddressRespository extends JpaRepository<Address, Long>{
	/*
	@Query("SELECT id FROM ADDRESS_TBL")
	List<Address> findAllAddressesByEmpId(long employeeId);
	
	@Query("DELETE FROM ADDRESS_TBL a WHERE a.id = :employeeId")
	List<Address> deleteAllAddressesByEmployeeId(@Param("employeeId") long employeeId);*/

}
