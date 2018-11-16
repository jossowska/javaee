<%@page import="com.jossowska.servletjspdemo.domain.ComicBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All comics</title>
</head>
<body>

<jsp:useBean id="storage" class="com.jossowska.servletjspdemo.service.StorageService" scope="application" />
<%
  for (ComicBook comic : storage.getAllComics()) {
	  out.println("<p>Title: " + comic.getTitle() + "; Price: " + comic.getPrice() + "</p>");
  }
%>
<p>
  <a href="getComicBookData.jsp">Add another comic book</a>
</p>

</body>
</html>