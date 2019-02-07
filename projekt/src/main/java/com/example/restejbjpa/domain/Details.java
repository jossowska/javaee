package com.example.restejbjpa.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name = "details.findAll", query = "Select d from Details d"),
	@NamedQuery(name = "details.deleteAll", query = "Delete from Details"),
	@NamedQuery(name = "details.findById", query = "Select d from Details d where d.id = :id")
})

@XmlRootElement
public class Details {
	
	private Long id;
	private String description;
	private ComicBook comicBook;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @OneToOne(fetch = FetchType.EAGER)
    public ComicBook getComicBook() {
		return comicBook;
	}

	public void setComicBook(ComicBook comicBook) {
		this.comicBook = comicBook;
	}
	
	public Details() {
		super();
	}
	
	public Details(String description) {
		super();
		this.description = description;
	}
}
