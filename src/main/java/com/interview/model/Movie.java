package com.interview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {

	
/************************Note table structure***********************/	
	/*CREATE TABLE public.movie
	(
	  id integer NOT NULL,
	  name character varying(255),
	  category character varying(255),
	  starrating character varying(255),
	  CONSTRAINT movie_pkey PRIMARY KEY (id)
	)
	WITH (
	  OIDS=FALSE
	);*/
	
  @Id
  @Column(name="id")
   private String    id; 

  @Column(name="name")
   private String name;
  
  @Column(name="category")
   private String category;
  
  @Column(name="starrating")
   private String starrating;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getStarrating() {
		return starrating;
	}
	
	public void setStarrating(String starrating) {
		this.starrating = starrating;
	}
   

   
   
}
