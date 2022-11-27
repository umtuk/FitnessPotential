<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/community">뒤로가기</a><br>
        <a href="/community/update/${community.id}">게시판 수정하기</a><br>
    </div>
    <jsp:include page="/community/entity/community.jsp">
        <jsp:param name="community" value="${community}" />
    </jsp:include>
</body>
</html>