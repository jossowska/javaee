package com.jossowska.javaee.service;

import java.util.ArrayList;
import java.util.List;

import com.jossowska.javaee.domain.Comics;

public class StorageService {

    private List<Comics> db = new ArrayList<Comics>();

    public void add(Comics comics) {
        Comics newComics = new Comics(comics.getTitle(), comics.getDateOfRelease(), comics.getPrice(), comics.getIsPopular());
        db.add(newComics);
    }

    public List<Comics> getAllComics() {
        return db;
}
}
