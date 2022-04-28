package com.lcomputerstudy4.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy4.example.domain.Survey;

@Mapper
public interface SurveyMapper {

	public void insertSurvey(Survey survey);

	public void insertItem(Survey survey);

	public void insertQuestion(Survey survey);

	public List<Survey> surveyList();
}
