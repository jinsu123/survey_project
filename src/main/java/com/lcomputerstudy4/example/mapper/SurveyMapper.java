package com.lcomputerstudy4.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy4.example.domain.Question;
import com.lcomputerstudy4.example.domain.Survey;

@Mapper
public interface SurveyMapper {

	public void insertSurvey(Survey survey);

	public void insertItem(Question question);

	public void insertQuestion(Question question);

	public List<Survey> surveyList();
}
