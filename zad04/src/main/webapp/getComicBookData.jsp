<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comics</title>
</head>
<body>

<jsp:useBean id="storage" class="com.jossowska.servletjspdemo.service.StorageService" scope="application" />
<jsp:useBean id="comic" class="com.jossowska.servletjspdemo.domain.ComicBook" scope="session" />

<form action="addComicBook.jsp">

  Title: <input type="text" name="title" value="${comic.title}" /><br />
  Date of release : <input type="date"  name="dateOfRelease" value="${comic.dateOfRelease}" /><br />
  Price: <input type="text"  name="price" value="${comic.price}" /><br />
  Is this a popular comic book?: <select name="isPopular"><option value="true">Yes</option><option value="false">No</option></select><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>