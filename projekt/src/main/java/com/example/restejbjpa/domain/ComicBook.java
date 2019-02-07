package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
	@NamedQuery(name = "comicBook.all", query = "Select c from ComicBook c"),
	@NamedQuery(name = "comicBook.delete.all", query = "Delete from ComicBook "),
	
	@NamedQuery(name = "comicBook.findByNumberOfComics", query = "Select cb from ComicBook cb where cb.numberOfComics = :numberOfComics")//,

})

@XmlRootElement
public class ComicBook {
	
	private Long id;
	private String title;
	private boolean isPopular;
	private double price;
	private String dateOfRelease;
	private int numberOfComics;
	private List<Creator> creators = new ArrayList<Creator>();
	private List<PublishingHouse> publishingHouses = new ArrayList<PublishingHouse>();
 	private Details details;
 	
 	
 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	public Long getId() {
 		return id;
 	}
 	
 	public void setId(Long id) {
 		this.id = id;
 	}
 	
 	public String getTitle() {
 		return title;
 	}
 	
 	public void setTitle(String title) {
 		this.title = title;
 	}
 	
 	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getIsPopular(){
		return isPopular;
	}
	public void setIsPopular(boolean isPopular) {
		this.isPopular = isPopular;
	}
	
	public String getDateOfRelease() {
		return dateOfRelease;
	}
	
	public void setDateOfRelease(String dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	
	public int getNumberOfComics() {
		return numberOfComics;
	}

	public void setNumberOfComics(int numberOfComics) {
		this.numberOfComics = numberOfComics;
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Creator> getCreators(){
		return creators;
	}
	
	public void setCreators(List<Creator> creators) {
		this.creators = creators;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<PublishingHouse> getPublishingHouses(){
		return publishingHouses;
	}
	
	public void setPublishingHouses(List<PublishingHouse> publishingHouses) {
		this.publishingHouses = publishingHouses;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	public Details getDetails() {
		return details;
	}
	
	public void setDetails(Details details)
	{
		this.details = details;
	}
	
 	public ComicBook() {
 		super();
 	}
 	
 	public ComicBook(String title, String dateOfRelease, boolean isPopular, double price) {
 		super();
 		this.title = title;
 		this.isPopular = isPopular;
 		this.price = price;
 		this.dateOfRelease = dateOfRelease;
 	}
 	
 	public ComicBook(Long id,String title, String dateOfRelease, boolean isPopular, double price) {
 		super();
 		this.id = id;
 		this.title = title;
 		this.isPopular = isPopular;
 		this.price = price;
 		this.dateOfRelease = dateOfRelease;
 	}
 	
 	public ComicBook(String title) {
 		super();
 		this.title = title;
 	}
}
