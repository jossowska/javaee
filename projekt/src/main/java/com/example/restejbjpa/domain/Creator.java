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
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name = "creator.findAll", query = "Select c from Creator c"),
	@NamedQuery(name = "creator.deletAll", query = "Delete from Creator "),
	@NamedQuery(name = "creator.findById", query = "Select c from Creator c where c.id = :id")
})

@XmlRootElement
public class Creator {
	private Long id;
	private String name;
	
	private List<ComicBook> comics = new ArrayList<ComicBook>();
	
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

    public void setName(String firstName) {
        this.name = firstName;
    }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<ComicBook> getComics(){
    	return comics;
    }
    
    public void setComics(List<ComicBook> comics) {
    	this.comics = comics;
    }
	public Creator() {
		super();
	}
	
	public Creator(String name) {
		super();
		this.name = name;
	}
}
