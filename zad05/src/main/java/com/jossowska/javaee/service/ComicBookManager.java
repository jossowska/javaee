package com.jossowska.javaee.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jossowska.javaee.domain.ComicBook;

public class ComicBookManager {

	private List<ComicBook> db = Collections.synchronizedList(new ArrayList<>());

	public void addComicBook(ComicBook comicbook) {
		db.add(comicbook);
	}

	public void deleteComicBook(ComicBook comicbook){
		db.remove(comicbook);
 	}
	
	public ComicBook getComicBook(Integer id) {
		return new ComicBook();
	}
	
	public List<ComicBook> getAllComics(){
		return db;
	}
	
	public void deleteAllComics(){
		db.clear();
	}
}
