package com.lcomputerstudy4.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerstudy4.example.domain.Survey;
import com.lcomputerstudy4.example.domain.User;
import com.lcomputerstudy4.example.mapper.SurveyMapper;
import com.lcomputerstudy4.example.service.SurveyService;
import com.lcomputerstudy4.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserService userservice;
	@Autowired SurveyService surveyservice;

	
	@RequestMapping("/")
	public String home(Model model, Survey survey,  Authentication authentication) {
		
		logger.debug("debug");
	    logger.info("info");
	    logger.error("error");
	    
	    
	    
		
	   
	    // 로그인시 사용
	    if(authentication != null) {
	     	User user = (User)authentication.getPrincipal();
			survey.setUser(user);
			survey.setuIdx(user.getuIdx());
		    List<Survey> myList = surveyservice.mySurveyList(survey);
		 
		    model.addAttribute("myList", myList);
	    }
	    
	    List<Survey> list = surveyservice.surveyList();
		model.addAttribute("list", list);
	  

		return "/index";
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	
	
	@RequestMapping("/signup")
	public String signup(User user) {
		
		 //비밀번호 암호화
	      String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
	      
	      //유저 데이터 세팅
	      user.setPassword(encodedPassword);
	      user.setAccountNonExpired(true);
	      user.setEnabled(true);
	      user.setAccountNonLocked(true);
	      user.setCredentialsNonExpired(true);
	      user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));   
	      
	      //유저 생성
	      userservice.createUser(user);
	      //유저 권한 생성
	      userservice.createAuthorities(user);

		
		return "/login";
	}
	
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		return "/admin";
	}
	   
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
	     
		return "/user_info";
	}
	   
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	}


	@RequestMapping("/make/survey")
	public String makesurvey() {
		
		return "/makesurvey";
	}	
	
	@RequestMapping("/insert/survey")
	public String insertProcess(Model model,@RequestBody Survey survey, Authentication authentication) {
		
		User user = (User)authentication.getPrincipal();
		survey.setUser(user);
		survey.setuIdx(user.getuIdx());
		surveyservice.insertProcess(survey);
		
		return "/index";
	}
	
	@RequestMapping("/detail/survey")
	public String surveyDetail(Model model, Survey survey) {
	
		survey = surveyservice.getSurvey(survey);
		
	  
		model.addAttribute("sur", survey);
		
		return "/surveyDetail";
	}
	
	@RequestMapping("/detail/mySurvey")
	public String mySurveyDetail(Model model, Survey survey) {
		
		
		return "/surveyDetail";
	}	
	
	
	
}
