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
<form action="/fitness/routine/${fitnessRoutine.id}" method="post">
    <input type="hidden" name="_method" value="put">
    title: <input type="text" name="title" id="title" value="${fitnessRoutine.title}"> <br>
    <input type="submit" value="update">
</form>
<a href="/fitness/routine/${fitnessRoutine.id}"><h1>back</h1></a>
</body>
</html>