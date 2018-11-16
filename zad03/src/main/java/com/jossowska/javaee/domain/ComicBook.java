package com.jossowska.javaee.domain;

import java.util.Date;

public class ComicBook {
	
		private long id;
		private String title;
		private Date dateOfRelease;
		private double price;
		private boolean isPopular;
		
		public ComicBook() {
			super();
		}
		
		
		public ComicBook(long id,String title, Date dateOfRelease, double price, boolean isPopular) {
			
			this.id = id;
			this.title = title;
			this.dateOfRelease = dateOfRelease;
			this.price = price;
			this.isPopular = isPopular;
		}
		
		public long getId() {
			return id;
		}
		
		public void setId(long id) {
			this.id = id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public Date getDateOfRelease() {
			return dateOfRelease;
		}
		
		public void setDateOfRelease(Date dateOfRelease) {
			this.dateOfRelease = dateOfRelease;
		}
		
		public double getPrice() {
			return price;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		
		public boolean getIsPopular() {
			return isPopular;
		}
		
		public void setIsPopular(boolean isPopular) {
			this.isPopular = isPopular;
		}
}
