package com.example.restejbjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name="publishingHouse.findAll", query = "Select p from PublishingHouse p"),
	@NamedQuery(name="publishingHouse.delete.all", query = "Delete from PublishingHouse"),
	@NamedQuery(name="publishingHouse.findById", query = " Select p from PublishingHouse p where p.id = :id")
})
public class PublishingHouse {
	private Long id;
	private String name;
	
	@ManyToOne
	private ComicBook comicBook;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public PublishingHouse() {
		super();
	}
	
	public PublishingHouse(String name) {
		super();
		this.name = name;
	}
}
