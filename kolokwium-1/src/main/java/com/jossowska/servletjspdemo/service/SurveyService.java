package com.jossowska.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.jossowska.servletjspdemo.domain.Survey;

public class SurveyService {

    private List<Survey> db = new ArrayList<Survey>();


    public void addSurvey(Survey survey) {
        Survey newSurvey = new Survey(survey.getName(),survey.getFrom(), survey.getTo(),survey.getFrequency(), survey.getComments());
        db.add(newSurvey);
    }
    

    public List<Survey> getAllSurveys() {
        return db;
    }
    

}
