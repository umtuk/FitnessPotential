<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script src="/js/fitnessInfo.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/fitness/info">back</a><br>
        <a href="/fitness/info/update/${fitnessInfo.id}">update</a>
    </div>
    <jsp:include page="/fitness/info/entity/info.jsp">
        <jsp:param name="fitnessInfo" value="${fitnessInfo}" />
    </jsp:include>
</body>
</html>