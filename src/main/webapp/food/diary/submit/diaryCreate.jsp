<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/head.jsp"></jsp:include>
        <script src="/js/storage.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.0/axios.min.js"></script>
    </head>
    <body>
        <jsp:include page="/header.jsp"></jsp:include>
        <div class="container-sm">
            <c:set var="targetSelector" value='.thumbnail' scope="request"></c:set>
            <jsp:include page="/storage/submit/storageCreate.jsp"></jsp:include>
            <br>
            <form action="/food/diary" method="post">
                <input type="hidden" name="thumbnail" class="thumbnail">
                내용:
                <input type="text" name="content" id="content" required min="5" max="1024"><br><br>
                섭취량:
                <input type="number" name="intake" id="intake" required min="1"><br><br>
                섭취량 단위:
                <select name="intakeUnit" required>
                    <option value="g">g</option>
                    <option value="ml">ml</option>
                </select> <br> <br>
                칼로리(kcal):
                <input type="number" name="kcal" id="kcal" min="1" required><br><br>
                탄수화물(g):
                <input type="number" name="carbs" id="carbs" min="1" required><br><br>
                단백질(g):
                <input type="number" name="protein" id="protein" min="1" required><br><br>
                지방(g):
                <input type="number" name="fat" id="fat" min="1" required><br><br>
                날짜(yyyy-mm-dd):
                <input type="number" name="year" id="year" min="0" max="9999" required>-
                <input type="number" name="month" id="month" min="1" max="12" required>-
                <input type="number" name="day" id="day" min="1" max="31" required><br><br>

                시간:
                <input type="number" name="hour" id="hour" min="0" max="23" required>&nbsp;&nbsp;

                분:
                <input type="number" name="minute" id="minute" min="0" max="59" required><br><br>
                <input type="submit" class="btn btn-outline-primary me-2" value="create diary">
            </form>
            <a href="/food/diary"><h1>back</h1></a>
        </div>
    </body> 
</html>