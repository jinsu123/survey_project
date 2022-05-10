<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table{
		border-collapse:collapse;
	}
	table tr th{
		font-weight:700;
	}
	table tr td, table tr th{
	
		width:20%;
		text-align:left;
	}
	th{
		background-color:#b0e0e6;
	}
	
	
</style>
<body>
	<h1>Google Survey</h1>
	<hr>
	<div>
		<sec:authorize access="isAnonymous()">
			<a href="/login">로그인</a>
			<a href="/beforeSignUp">회원가입</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
	    	<sec:authentication property="principal" var="principal"/>
	    	<h2>${principal.uName}님</h2>
	    </sec:authorize>
	</div>
	<div>
		<sec:authorize access="isAuthenticated()">        
        	<a href="/user/info">내 정보</a>
        	<a href="/logout">로그아웃</a>
        	<a href="/admin">관리자</a>
    	</sec:authorize>
	</div>
	
	<sec:authorize access="isAuthenticated()">
	     	<hr>
		     	<h2>내 설문</h2>
		     		<table>
						<tr>		
							<th>제목</th>
							<th>작성일</th>
						</tr>
						<c:forEach items="${myList}" var="myList">
							<tr>
								<td><a href="/detail/mySurvey?sIdx=${myList.sIdx}">${myList.sTitle}</a></td>
								<td>${myList.sDatetime}</td>
							</tr>
						</c:forEach>
					</table>
		     		
					<br>
					<a href="/make/survey">설문 만들기</a>

	     
		
	 <hr>
	 	<h2>설문 참여하기</h2>
	 		<table>
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td><a href="/detail/survey?sIdx=${list.sIdx}">${list.sTitle}</a></td>
						<td>${list.sDatetime}</td>
					</tr>
				</c:forEach>
			</table>
     </sec:authorize>
</body>
</html>