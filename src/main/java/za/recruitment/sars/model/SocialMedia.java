package za.recruitment.sars.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SOCIALMEDIA")
public class SocialMedia implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Column(name = "id")
	@SequenceGenerator(name = "sequence", sequenceName = "social_media_sequence", allocationSize = 1)
	private long id;

	@Column(name = "social_media_handle")
	private String socialMediaHandle;
	
	@Column(name = "social_media_type")
	@Enumerated(EnumType.STRING)
	private SocialMediaType socialMediaType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@JsonBackReference
	private Employee employee;
	
	public SocialMedia() {
		
	}
	
	public SocialMedia(String socialMediaHandle, SocialMediaType scMediaType, Employee employee) {
		this.socialMediaHandle = socialMediaHandle;
		this.socialMediaType = scMediaType;
		this.employee = employee;
	}
	
	public String toString() {
		return this.getSocialMediaHandle() + " (" + this.getSocialMediaType() + ")";
	}
}


