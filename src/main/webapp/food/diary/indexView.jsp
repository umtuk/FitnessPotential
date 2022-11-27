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
        <a href="/food/diary">뒤로가기</a><br>
        <a href="/food/diary/update/${foodDiary.id}">식단 일지 수정하기</a>
    </div>
    <jsp:include page="/food/diary/entity/diary.jsp">
        <jsp:param name="foodDiary" value="${foodDiary}" />
    </jsp:include>
</body>
</html>