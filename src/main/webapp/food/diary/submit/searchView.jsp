<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness Potential</title>
</head>
<body>
<jsp:include page="/food/diary/entity/diary.jsp">
    <jsp:param name="foodDiaries" value="${foodDiaries}" />
</jsp:include>
<a href="/food/diary/create"><h1>create</h1></a>
</body>
</html>
