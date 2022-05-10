<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 작성</title>
</head>
<style>
div{
	width: 400px;
	height: 150px;
	border: 3px solid black;
	border-radius: 5px;
}

</style>
<body bgcolor="ebe7f1">

<div>
<h1>&nbsp;${sur.sTitle}</h1>
<h2>&nbsp;&nbsp;${sur.sContent}</h2>
</div>
<br>
<c:forEach items="${sv.questionlist}" var="q">
				<div class="item">
					<br><input type="text" name="" value="${q.qContent}" class = "question"><br>
					<c:choose>
						<c:when test="${q.qKind eq 'short'}">
							<select name="qKind" class="questionOption">
								<option value="none">===선택===</option>
								<option value="short" selected>단답형</option>
								<option value="long">장문형</option>
								<option value="multiplechoice">객관식 질문</option>
								<option value="checkbox">체크박스</option>
							</select>
						</c:when>
						<c:when test="${q.qKind eq 'long'}">
							<select name="qKind" class="questionOption">
								<option value="none">===선택===</option>
								<option value="short">단답형</option>
								<option value="long" selected>장문형</option>
								<option value="multiplechoice">객관식 질문</option>
								<option value="checkbox">체크박스</option>
							</select>
						</c:when>
						<c:when test="${q.qKind eq 'multiplechoice'}">
							<select name="qKind" class="questionOption">
								<option value="none">===선택===</option>
								<option value="short">단답형</option>
								<option value="long">장문형</option>
								<option value="multiplechoice" selected>객관식 질문</option>
								<option value="checkbox">체크박스</option>
							</select>
						</c:when>
						<c:when test="${q.qKind eq 'checkbox'}">
							<select name="qKind" class="questionOption">
								<option value="none">===선택===</option>
								<option value="short">단답형</option>
								<option value="long">장문형</option>
								<option value="multiplechoice">객관식 질문</option>
								<option value="checkbox" selected>체크박스</option>
							</select>
						</c:when>
					</c:choose>
					<button type = "button" class = "deleteQuestion" qMaster="${sv.sNo}" qIndex="${q.qIndex}">질문 삭제</button>
					<div class = "example2">
						<c:forEach items="${sv.examplelist}" var="e">
							<c:if test="${q.qIndex == e.eIndex && (q.qKind == 'multiplechoice' || q.qKind == 'checkbox')}">
								<input type='text' value = '${e.eContent}' class = 'example'>
								<button type = "button" class = "deleteExample">보기 삭제</button><br>
							</c:if>
						</c:forEach>
					</div>
						<c:if test="${q.qKind == 'multiplechoice' || q.qKind == 'checkbox'}">
							<button type = 'button' class = 'addExample'>보기 추가하기</button>
						</c:if>
					</div>
			</c:forEach>

</body>
</html>