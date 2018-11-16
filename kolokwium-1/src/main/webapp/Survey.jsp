<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ankiety</title>
</head>
<body>

<jsp:useBean id="storage" class="com.jossowska.servletjspdemo.service.SurveyService" scope="application" />
<jsp:useBean id="survey" class="com.jossowska.servletjspdemo.domain.Survey" scope="session" />

<form action="addSurvey.jsp">

  Nazwa: <input type="text" name="name" value="${survey.name}" /><br />
  Jak długo używałeś produkt? <br/> Od: <input type="text"  name="from" value="${survey.from}" /> Do: <input type="text"  name="to" value="${survey.to}" /><br/>
  Z jaką częstotliwością?<br/>
    <input type="radio" name="frequency" value="kilka razy dziennie">Kilka razy dziennie<br>
    <input type="radio" name="frequency" value="kilka razy w tygodniu">Kilka razy w tygodniu<br>
    <input type="radio" name="frequency" value="kilka razy w roku">Kilka razy w roku<br>
   Masz jakieś uwagi?<br/> 
   <input type="checkbox" name="comments" value="poprawić">Należy poprawić grafikę<br>
   <input type="checkbox" name="comments" value="zwiększyć">Należy zwiększyć częstość wydawania<br>
   <input type="checkbox" name="comments" value="rozbudować">Należy rozbudować produkt<br><br>
  
  <input type="submit" value=" Prześlij swoją ankietę! ">
  
</form>

</body>
</html>