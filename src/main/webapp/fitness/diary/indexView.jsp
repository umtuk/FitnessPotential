<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/fitness/diary">back</a><br>
        <a href="/fitness/diary/update/${fitnessDiary.id}">update</a>
    </div>
    <jsp:include page="/fitness/diary/entity/diary.jsp">
        <jsp:param name="fitnessDiary" value="${fitnessDiary}" />
    </jsp:include>
</body>
</html>