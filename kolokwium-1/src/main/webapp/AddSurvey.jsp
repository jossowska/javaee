<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey</title>
</head>
<body>
<jsp:useBean id="survey" class="com.jossowska.servletjspdemo.domain.Survey" scope="session" />

<jsp:setProperty name="survey" property="*" /> 

<jsp:useBean id="storage" class="com.jossowska.servletjspdemo.service.SurveyService" scope="application" />

<% 
  storage.addSurvey(survey);
%>

<p>Ankieta została przesłana </p>
<p>Imię: ${survey.name} </p>
<p>Od: ${survey.from} </p>
<p>Do: ${survey.to }</p>
<p>Częstotliwość: ${survey.frequency }</p>
<p>Uwagi: ${survey.comments }</p>


</body>
</html>