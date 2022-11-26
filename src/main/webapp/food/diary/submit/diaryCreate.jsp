<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="/js/storage.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.0/axios.min.js"></script>
    </head>
    <body>
        <jsp:include page="/header.jsp"></jsp:include>

        <c:set var="targetSelector" value='.thumbnail' scope="request"></c:set>
        <jsp:include page="/storage/submit/storageCreate.jsp"></jsp:include>

        <div class="container-sm">
            <form action="/food/diary" method="post">
                <input type="hidden" name="thumbnail" class="thumbnail">
                content:
                <input type="text" name="content" id="content"><br><br>
                intake:
                <input type="number" name="intake" id="intake"><br><br>
                intakeUnit:
                <select name="intakeUnit">
                    <option value="g">g</option>
                    <option value="ml">ml</option>
                </select> <br> <br>
                kcal:
                <input type="number" name="kcal" id="kcal" min="0"><br><br>
                carbs:
                <input type="number" name="carbs" id="carbs" min="0"><br><br>
                protein:
                <input type="number" name="protein" id="protein" min="0"><br><br>
                fat:
                <input type="number" name="fat" id="fat" min="0"><br><br>
                year:
                <input type="number" name="year" id="year" min="0" max="9999"><br><br>
                month:
                <input type="number" name="month" id="month" min="1" max="12"><br><br>
                day:
                <input type="number" name="day" id="day" min="1" max="31"><br><br>

                hour:
                <input type="number" name="hour" id="hour" min="0" max="23"><br><br>

                minute:
                <input type="number" name="minute" id="minute" min="0" max="59"><br><br>
                <input type="submit" class="btn btn-outline-primary me-2" value="create diary">
            </form>
            <a href="/food/diary"><h1>back</h1></a>
        </div>
    </body> 
</html>