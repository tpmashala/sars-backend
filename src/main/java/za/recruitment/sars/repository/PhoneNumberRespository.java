package za.recruitment.sars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.recruitment.sars.model.Address;
import za.recruitment.sars.model.PhoneNumber;

@Repository
@Transactional
public interface PhoneNumberRespository extends JpaRepository<PhoneNumber, Long>{

}
