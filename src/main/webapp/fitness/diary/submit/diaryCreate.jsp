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
    <form action="/fitness/diary" method="post">
        title: <input type="text" name="title" id="title"><br>
        fitnessInfoId: <input type="text" name="fitnessInfoId" id="fitnessInfoId"><br>
        sets: <input type="text" name="sets" id="sets"><br>
        reps: <input type="text" name="reps" id="reps"><br>
        breakTimesPerSet: <input type="text" name="breakTimesPerSet" id="breakTimesPerSet"><br>
        year: <input type="text" name="year" id="year"><br>
        month: <input type="text" name="month" id="month"><br>
        day: <input type="text" name="day" id="day"><br>
        <input type="submit" value="submit">
    </form>
    <a href="/fitness/diary"><h1>back</h1></a>
</body>
