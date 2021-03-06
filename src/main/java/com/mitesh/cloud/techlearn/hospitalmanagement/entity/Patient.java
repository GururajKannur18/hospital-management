package com.mitesh.cloud.techlearn.hospitalmanagement.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
		
	@Embedded
	private Insurance insurance;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "patients_doctors",joinColumns = @JoinColumn(name="patient_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="doctor_id",referencedColumnName = "id"))
	private List<Doctor> doctors;
	
	@OneToMany
	private List<Appointment> appointments;
	
}
