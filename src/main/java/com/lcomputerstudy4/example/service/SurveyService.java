package com.lcomputerstudy4.example.service;

import java.util.List;

import com.lcomputerstudy4.example.domain.Survey;

public interface SurveyService {

	public void insertProcess(Survey survey);
	
	public List<Survey> surveyList();
	
	public List<Survey> mySurveyList(Survey survey);
}
