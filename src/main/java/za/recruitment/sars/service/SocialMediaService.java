package za.recruitment.sars.service;

import java.util.List;

import za.recruitment.sars.model.Employee;
import za.recruitment.sars.model.SocialMedia;

public interface SocialMediaService {

	public SocialMedia findById(Long id);
	
	public List<SocialMedia> findAllSocialMedia();
	
	public List<SocialMedia> findAllSocialMediaByEmpId(Long empId);
	
	public SocialMedia saveSocialMedia(SocialMedia socialMedia);
	
	public List<SocialMedia> saveSocialMedia(List<SocialMedia> socialMedia);
	
	public SocialMedia updateSocialMedia(SocialMedia socialMedia);
	
	public SocialMedia deleteSocialMedia(Long id);
	
	public SocialMedia deleteAllSocialMediaByEmployeeId(Employee emp);
}
