package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.ComicBook;
import com.example.restejbjpa.domain.Creator;
import com.example.restejbjpa.domain.Details;
import com.example.restejbjpa.domain.PublishingHouse;

import javax.persistence.EntityManager;

@Singleton
public class ComicBookManager {
	
	public static Long id=(long)1;
	@PersistenceContext
	EntityManager em;
	
	
	
	public void addComicBook(ComicBook comicBook) {
		em.persist(comicBook);
	}
	
	public ComicBook getComicBook(Long id) {
		ComicBook retrieved = em.find(ComicBook.class, id);
		return retrieved;
	}
	
	public void addPublishingHouse(PublishingHouse publishingHouse) {
		em.persist(publishingHouse);
	}
	
	public PublishingHouse getPublishingHouse(Long id) {
		PublishingHouse retrieved = em.find(PublishingHouse.class, id);
		return retrieved;
	}
	
	public void addDetails(Details details) {
		em.persist(details);
	}
	
	public Details getDetails(Long id) {
		Details retrieved = em.find(Details.class, id);
		return retrieved;
	}
	
	public void addCreator(Creator creator) {
		em.persist(creator);
	}
	
	public Creator getCreator(Long id) {
		Creator retrieved = em.find(Creator.class, id);
		return retrieved;
	}
	
	public Creator findMostPowerfullCreator(){
		List<Creator> creators = new ArrayList<>();  
		creators = getAllCreators();
		int max = 0;
		Long id = (long) 1;
		for(Creator c : creators) {
			for(ComicBook cb: c.getComics()) {
				if(cb.getNumberOfComics()>max) {
					max = cb.getNumberOfComics();
					id = c.getId();
				}
			}
		}
		return em.find(Creator.class, id);
	}
	
	public Creator findManyPublishingHouses(){
		List<Creator> creators = new ArrayList<>();  
		creators = getAllCreators();
		int max = 0, local = 0;
		Long id = (long) 1;
		for(Creator c : creators) {
			local = 0;
			for(ComicBook b: c.getComics()) {
				local += b.getPublishingHouses().size();
			}
			if(local>max) {
				id = c.getId();
				max = local;
			}
		}
		return em.find(Creator.class, id);
	}
	

	public List<Creator> findManyPublishingHouses(int n){
		List<Creator> many = new ArrayList<>(); 
		List<Creator> creators = new ArrayList<>();  
		creators = getAllCreators();
		for(Creator o : creators) {
			int count = 0;
			for(ComicBook b: o.getComics()) {
				count += b.getPublishingHouses().size();
			}
			if(count>n) {
				many.add(o);
			}
		}
		return many;
	}

	
	@SuppressWarnings("unchecked")
	public List<ComicBook> getAllComics(){
		return em.createNamedQuery("comicBook.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PublishingHouse> getAllPublishingHouses(){
		return em.createNamedQuery("publishingHouse.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Details> getAllDetails(){
		return em.createNamedQuery("details.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Creator> getAllCreators(){
		return em.createNamedQuery("creators.all").getResultList();
	}
	
	public void deleteAllComics() {
		em.createNamedQuery("comicBook.delete.all").executeUpdate();
	}
	
	public void deleteAllPublishingHouses() {
		em.createNamedQuery("publishingHouse.delete.all").executeUpdate();
	}
	
	public void deleteAllDetails() {
		em.createNamedQuery("details.deleteAll").executeUpdate();
	}
	
	public void deleteAllCreators() {
		em.createNamedQuery("creator.deleteAll").executeUpdate();
	}
}
