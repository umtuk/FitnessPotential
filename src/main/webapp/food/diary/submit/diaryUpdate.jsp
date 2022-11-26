<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <script src="/js/storage.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.0/axios.min.js"></script>
    </head>
<body>
<jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <c:set var="targetSelector" value='.thumbnail' scope="request"></c:set>
        <jsp:include page="/storage/submit/storageCreate.jsp"></jsp:include>
        <form action="/food/diary/${foodDiary.id}" method="post">
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="thumbnail" class="thumbnail" value="${foodDiary.thumbnail}">
            content:
            <input type="text" name="content" id="content" value="${foodDiary.content}"><br><br>
            intake:
            <input type="number" name="intake" id="intake" value="${foodDiary.intake}"><br><br>
            intakeUnit:
            <select name="intakeUnit">
                <option value="g">g</option>
                <option value="ml">ml</option>
            </select> <br> <br>
            kcal:
            <input type="number" name="kcal" id="kcal" min="0" value="${foodDiary.kcal}"><br><br>
            carbs:
            <input type="number" name="carbs" id="carbs" min="0" value="${foodDiary.carbs}"><br><br>
            protein:
            <input type="number" name="protein" id="protein" min="0" value="${foodDiary.protein}"><br><br>
            fat:
            <input type="number" name="fat" id="fat" min="0" value="${foodDiary.fat}"><br><br>
            year:
            <input type="number" name="year" id="year" min="0" max="9999" value="${foodDiary.year}"><br><br>
            month:
            <input type="number" name="month" id="month" min="1" max="12" value="${foodDiary.month}"><br><br>
            day:
            <input type="number" name="day" id="day" min="1" max="31" value="${foodDiary.day}"><br><br>

            hour:
            <input type="number" name="hour" id="hour" min="0" max="23" value="${foodDiary.hour}"><br><br>

            minute:
            <input type="number" name="minute" id="minute" min="0" max="59" value="${foodDiary.minute}"><br><br>
            <input type="submit" class="btn btn-outline-primary me-2" value="update">
        </form>
        <a href="/food/diary/${foodDiary.id}"><h1>back</h1></a>
    </div>
</body>
</html>
