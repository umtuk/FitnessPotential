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
<a href="/fitness/routine"><h1>back</h1></a>
<jsp:include page="/fitness/routine/entity/routine.jsp">
    <jsp:param name="fitnessRoutine" value="${fitnessRoutine}" />
</jsp:include>
<a href="/fitness/routine/update/${fitnessRoutine.id}"><h1>update</h1></a>
</body>
</html>