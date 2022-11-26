<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/food/diary" method="post">
            title:
            <input type="text" class="w-100" name="title" id="title"><br><br>
            content:
            <input type="text" name="content" id="content"><br><br>
            intake:
            <input type="text" name="intake" id="intake"><br><br>
            intakeUnit:
            <input type="text" name="intakeUnit" id="intakeUnit"><br><br>
            kcal:
            <input type="number" name="kcal" id="kcal"><br><br>
            carbs:
            <input type="number" name="carbs" id="carbs"><br><br>
            protein:
            <input type="number" name="protein" id="protein"><br><br>
            fat:
            <input type="number" name="fat" id="fat"><br><br>
            year:
            <input type="text" name="year" id="year"><br><br>
            month:
            <input type="text" name="month" id="month"><br><br>
            day:
            <input type="text" name="day" id="day"><br><br>
            <input type="submit" class="btn btn-outline-primary me-2" value="create diary">
        </form>
        <a href="/food/diary"><h1>back</h1></a>
    </div>
</body>
