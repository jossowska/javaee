<%@page import="com.jossowska.servletjspdemo.domain.Survey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All surveys</title>
</head>
<body>

<jsp:useBean id="storage" class="com.jossowska.servletjspdemo.service.SurveyService" scope="application" />
<%
  for (Survey survey : storage.getAllSurveys()) {
	  out.println("<p>Użytkownik: " + survey.getUser() + "; Od: " + survey.getFrom() + "; Do: " + survey.getTo() + "; Częstotliwość: " + survey.getFrequency() + "; Uwagi: " + survey.getComments() +"</p>");
  }
%>
<p>
  <a href="Survey.jsp">Prześlij następną ankietę</a>
</p>

</body>
</html>