package com.sima.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User_Details")
public class User {
	@Id
	private Integer id;
	@Column(name="user_name")
	private String name;
	private String gender;
	private String country;
	
	@CreationTimestamp // populate record created date
	@Column(updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp // populate record updated date
	@Column(insertable = false)
	private LocalDate lastUpdated;
	}
