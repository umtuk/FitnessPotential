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
<form action="/fitness/info" method="post">
    title: <input type="text" name="title" id="title"><br>
    summary: <input type="text" name="summary" id="summary"><br>
    content: <input type="text" name="content" id="content"><br>
    <input type="submit" value="submit">
</form>
<a href="/fitness/info"><h1>back</h1></a>
</body>