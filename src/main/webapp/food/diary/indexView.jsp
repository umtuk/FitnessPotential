<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<body>
<head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
<div class="container-sm">
    <a href="/food/diary">back</a><br>
    <a href="/food/diary/update/${foodDiary.id}">update</a>
</div>
<jsp:include page="/food/diary/entity/diary.jsp">
    <jsp:param name="foodDiary" value="${foodDiary}" />
</jsp:include>
</body>
</html>