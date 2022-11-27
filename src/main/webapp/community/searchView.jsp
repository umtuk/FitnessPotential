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
    <jsp:include page="/community/entity/communitySummaries.jsp">
        <jsp:param name="communitySummaries" value="${communitySummaries}" />
    </jsp:include>
</body>
</html>