package vn.com.doctorcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@Column(name="status")
	private int status;

	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="note")
	private String note;

	@Column(name="confirmed")
	private int confirmed; //default: 0, yes: 1, no: 2
	
	@Column(name="reject_text")
	private String rejectText;
	
	public Appointment() {}

	public Appointment(Patient patient, Doctor doctor, int status, String date, String time, String note, int confirmed,
			String rejectText) {
		this.patient = patient;
		this.doctor = doctor;
		this.status = status;
		this.date = date;
		this.time = time;
		this.note = note;
		this.confirmed = confirmed;
		this.rejectText = rejectText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public String getRejectText() {
		return rejectText;
	}

	public void setRejectText(String rejectText) {
		this.rejectText = rejectText;
	}

}
