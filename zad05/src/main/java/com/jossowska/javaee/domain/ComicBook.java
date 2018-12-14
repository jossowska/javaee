package com.jossowska.javaee.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ComicBook {

	private String title;
	private Double price;
	private Boolean isPopular;
	private Date dateOfRelease;
	
	public ComicBook() {
		
	}
	
	public ComicBook( String title, Double price, Boolean isPopular, Date dateOfRelease) {

		this.title = title;
		this.price = price;
		this.isPopular = isPopular;
		this.dateOfRelease = dateOfRelease;
	}
	



	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Boolean getIsPopular() {
		return isPopular;
	}
	
	public void setIsPopular(Boolean isPopular) {
		this.isPopular = isPopular;
	}
	
	public Date getDateOfRelease() {
		return dateOfRelease;
	}
	
	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	
	
	
	
	
}
