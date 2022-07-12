package za.recruitment.sars.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.recruitment.sars.model.SocialMedia;
import za.recruitment.sars.model.Employee;
import za.recruitment.sars.repository.SocialMediaRespository;
import za.recruitment.sars.repository.EmployeeRepository;
import za.recruitment.sars.service.SocialMediaService;

@Service
public class SocialMediaServiceImpl implements SocialMediaService{

	@Autowired
	SocialMediaRespository socialMediaRepository;
	
	@Override
	public SocialMedia findById(Long id) {
		return socialMediaRepository.findById(id).orElse(null);
	}

	@Override
	public List<SocialMedia> findAllSocialMedia() {
		
		return socialMediaRepository.findAll();
	}
	
	@Override
	public List<SocialMedia> findAllSocialMediaByEmpId(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SocialMedia saveSocialMedia(SocialMedia socialMedia) {
		
		return socialMediaRepository.save(socialMedia);
	}

	@Override
	public List<SocialMedia> saveSocialMedia(List<SocialMedia> socialMediaes) {
		
		return socialMediaRepository.saveAll(socialMediaes);
	}

	@Override
	public SocialMedia updateSocialMedia(SocialMedia socialMedia) {
		SocialMedia updatedSocialMedia = socialMediaRepository.findById(socialMedia.getId()).orElse(null);
		updatedSocialMedia.setSocialMediaHandle(socialMedia.getSocialMediaHandle());
		return socialMediaRepository.save(updatedSocialMedia);
	}

	@Override
	public SocialMedia deleteSocialMedia(Long id) {
		SocialMedia deletedSocialMedia = socialMediaRepository.findById(id).orElse(null);
		
		if(deletedSocialMedia != null) {
			socialMediaRepository.deleteById(id);
			return deletedSocialMedia;
		} else {
			return null;
		}
	
	}

	@Override
	public SocialMedia deleteAllSocialMediaByEmployeeId(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
