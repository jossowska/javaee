package com.jossowska.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.jossowska.servletjspdemo.domain.ComicBook;

public class StorageService {

    private List<ComicBook> db = new ArrayList<ComicBook>();
    private List<ComicBook> Cart = new ArrayList<ComicBook>();

    public void addComicBook(ComicBook comic) {
        ComicBook newComicBook = new ComicBook(comic.getId(),comic.getTitle(), comic.getDateOfRelease(),comic.getPrice(), comic.getIsPopular());
        db.add(newComicBook);
    }
    

    public List<ComicBook> getAllComics() {
        return db;
    }
    
    public void addToCart(ComicBook comic) {
        ComicBook newComicBook = new ComicBook(comic.getId(),comic.getTitle(), comic.getDateOfRelease(),comic.getPrice(), comic.getIsPopular());
        Cart.add(newComicBook);
    }
    
    public List<ComicBook> getCart(){
    	return Cart;
    }
}
