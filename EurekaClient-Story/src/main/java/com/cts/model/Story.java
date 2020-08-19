package com.cts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@NoArgsConstructor
@AllArgsConstructor
@NonNull
@Data
@Entity
@Table(name = "Story")
public class Story {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long story_id;
	@NotEmpty(message = " story name must not be empty")
	@Size(min=2,message = " name must not be less than two characters")
	private String story_name;
	
	@NotEmpty(message = "description  must not be empty") 
	private String description;
	
	
	@JsonIgnore
	private Long user_id;
	
	@JsonIgnore
	private String assigned;
	
	
	
	

}
