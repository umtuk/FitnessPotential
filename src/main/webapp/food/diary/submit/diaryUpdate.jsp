<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <jsp:include page="/head.jsp"></jsp:include>
        <script src="/js/storage.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.0/axios.min.js"></script>
    </head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <c:set var="targetSelector" value='.thumbnail' scope="request"></c:set>
        <jsp:include page="/storage/submit/storageCreate.jsp"></jsp:include><br>
        <form action="/food/diary/${foodDiary.id}" method="post">
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="thumbnail" class="thumbnail" value="${foodDiary.thumbnail}">
            내용:
            <input type="text" name="content" id="content" value="${foodDiary.content}"  required min="5" max="1024"><br><br>
            섭취량:
            <input type="number" name="intake" id="intake" value="${foodDiary.intake}"  required min="1"><br><br>
            섭취량 단위:
            <select name="intakeUnit">
                <option value="g">g</option>
                <option value="ml">ml</option>
            </select> <br> <br>
            칼로리(kcal):
            <input type="number" name="kcal" id="kcal" value="${foodDiary.kcal}"  min="1" required><br><br>
            탄수화물(g):
            <input type="number" name="carbs" id="carbs" value="${foodDiary.carbs}"  min="1" required><br><br>
            단백질(g):
            <input type="number" name="protein" id="protein" value="${foodDiary.protein}"  min="1" required><br><br>
            지방(g):
            <input type="number" name="fat" id="fat" value="${foodDiary.fat}"  min="1" required><br><br>
            
            날짜(yyyy-mm-dd):
            <input type="number" name="year" id="year" min="0" max="9999" value="${foodDiary.year}"  min="0" max="9999" required>-
            <input type="number" name="month" id="month" min="1" max="12" value="${foodDiary.month}"  min="1" max="12" required>-
            <input type="number" name="day" id="day" min="1" max="31" value="${foodDiary.day}"  min="1" max="31" required>

            시간:
            <input type="number" name="hour" id="hour" min="0" max="23" value="${foodDiary.hour}" min="0" max="23" required><br><br>

            분:
            <input type="number" name="minute" id="minute" min="0" max="59" value="${foodDiary.minute}"  min="0" max="59" required><br><br>
            <input type="submit" class="btn btn-outline-primary me-2" value="update">
        </form>
        <a href="/food/diary/${foodDiary.id}"><h1>back</h1></a>
    </div>
</body>
</html>
