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
<jsp:include page="/fitness/routine/entity/routines.jsp">
    <jsp:param name="fitnessRoutines" value="${fitnessRoutines}" />
</jsp:include>
<a href="/fitness/routine/create"><h1>create</h1></a>
</body>
</html>