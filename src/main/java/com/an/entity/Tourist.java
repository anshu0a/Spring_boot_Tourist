package com.an.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="TOURIST_TAB_MINI_PROJECT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	
	//data
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "TOURIST_ID_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator ="gen1", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NonNull
	@Column(length = 30)
	private String name;
	
	@NonNull
	@Column(length = 60)
	private String addr;
	
	@NonNull
	@Column
	private Double budget;
	
	@NonNull
	@Column(length = 60)
	private String fromLoc;
	
	@NonNull
	@Column(length = 60)
	private String toLoc;
	
	
	//meta 
	
	@Version
	private Integer updateCount;
	
	@CreationTimestamp
	@Column(updatable = false, insertable = true)
	private LocalDateTime registerOn;
	
	@UpdateTimestamp
	@Column(updatable = true, insertable = false)
	private LocalDateTime lastUpdateOn;
	
	@Column(length = 30)
	private String createdBy;
	
	@Column(length = 30)
	private String updatedBy;
	
	@Column(length = 30)
	private String active_sw;
	
	
	

}
