<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-11-19
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fitnessDiaryUpdate</title>
</head>
<body>
<form action="/fitness/diary/${fitnessDiary.id}" method="post">
    <input type="hidden" name="_method" value="put">
    title: <input type="text" name="title" id="title" value="${fitnessDiary.title}"> <br>
    sets: <input type="text" name="sets" id="sets" value="${fitnessDiary.sets}"><br>
    reps: <input type="text" name="reps" id="reps" value="${fitnessDiary.reps}"><br>
    breakTimesPerSet: <input type="text" name="breakTimesPerSet" id="breakTimesPerSet" value="${fitnessDiary.breakTimesPerSet}"><br>
    year: <input type="text" name="year" id="year" value="${fitnessDiary.year}"><br>
    month: <input type="text" name="month" id="month" value="${fitnessDiary.month}"><br>
    day: <input type="text" name="day" id="day value="${fitnessDiary.day}""><br>
    <input type="submit" value="submit">
</form>
<a href="/fitness/diary/${community.id}"><h1>back</h1></a>
</body>
</html>
