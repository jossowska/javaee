<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="comic" class="com.jossowska.servletjspdemo.domain.ComicBook" scope="session" />

<jsp:setProperty name="comic" property="*" /> 

<jsp:useBean id="storage" class="com.jossowska.servletjspdemo.service.StorageService" scope="application" />

<% 
  storage.add(comic);
%>

<p>Comic book has been added to storage: </p>
<p>Title: ${comic.title} </p>
<p>Date of release: <jsp:getProperty name="comic" property="dateOfRelease"></jsp:getProperty></p>

</body>
</html>