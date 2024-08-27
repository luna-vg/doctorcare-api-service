package vn.com.doctorcare.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="general_introduction")
	private String generalIntroduction;

	@Column(name="education")
	private String education;

	@Column(name="rewards")
	private String rewards;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;
	
	@ManyToOne
	@JoinColumn(name = "specialization_id")
	private Specialization specialization;
	
//	@ManyToMany
//	@JoinTable(
//			name="appointments",
//			joinColumns=@JoinColumn(name="doctor_id"),
//			inverseJoinColumns=@JoinColumn(name="patient_id")
//			)
//	private List<Patient> patients;
	
	public Doctor() {}

	public Doctor(String generalIntroduction, String education, String rewards,
			User user, Clinic clinic, Specialization specialization) {
		this.generalIntroduction = generalIntroduction;
		this.education = education;
		this.rewards = rewards;
		this.user = user;
		this.clinic = clinic;
		this.specialization = specialization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeneralIntroduction() {
		return generalIntroduction;
	}

	public void setGeneralIntroduction(String generalIntroduction) {
		this.generalIntroduction = generalIntroduction;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getRewards() {
		return rewards;
	}

	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

//	public List<Patient> getPatients() {
//		return patients;
//	}
//
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}

}
