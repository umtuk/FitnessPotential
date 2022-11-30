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
    <jsp:include page="/user/entity/user.jsp">
        <jsp:param name="user" value="${user}" />
    </jsp:include>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>