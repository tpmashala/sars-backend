package za.recruitment.sars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.recruitment.sars.model.SocialMedia;

@Repository
@Transactional
public interface SocialMediaRespository extends JpaRepository<SocialMedia, Long>{

}
