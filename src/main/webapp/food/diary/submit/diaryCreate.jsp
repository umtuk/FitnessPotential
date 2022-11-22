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
<form action="/food/diary" method="post">
    title: <input type="text" name="title" id="title"><br>
    content: <input type="text" name="content" id="content"><br>
    intake: <input type="text" name="intake" id="intake"><br>
    intakeUnit: <input type="text" name="intakeUnit" id="intakeUnit"><br>
    kcal: <input type="number" name="kcal" id="kcal"><br>
    carbs: <input type="number" name="carbs" id="carbs"><br>
    protein: <input type="number" name="protein" id="protein"><br>
    fat: <input type="number" name="fat" id="fat"><br>
    year: <input type="text" name="year" id="year"><br>
    month: <input type="text" name="month" id="month"><br>
    day: <input type="text" name="day" id="day"><br>
    <input type="submit" value="submit">
</form>
<a href="/food/diary"><h1>back</h1></a>
</body>
