package com.lcomputerstudy4.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerstudy4.example.domain.Question;
import com.lcomputerstudy4.example.domain.Survey;
import com.lcomputerstudy4.example.mapper.SurveyMapper;

@Service
public class SurveyServiceimpl implements SurveyService{

	@Autowired SurveyMapper surveyMapper;
	
	@Override
	public void insertProcess(Survey survey) {
		surveyMapper.insertSurvey(survey);
		for (Question question : survey.getQuestionList()) {
			question.setsIdx(survey.getsIdx());
			surveyMapper.insertQuestion(question);
			if(question.getItemList() != null &&  question.getItemList().size() != 0) {
				surveyMapper.insertItem(question);
			}
		}
	}
	@Override
	public List<Survey> surveyList(){
		return surveyMapper.surveyList();
	}
	
	
}
