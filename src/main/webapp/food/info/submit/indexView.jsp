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
<a href="/food/info"><h1>back</h1></a>
<jsp:include page="/food/info/entity/info.jsp">
    <jsp:param name="foodInfo" value="${foodInfo}" />
</jsp:include>
<a href="/food/info/update/${foodInfo.id}"><h1>update</h1></a>
</body>
</html>