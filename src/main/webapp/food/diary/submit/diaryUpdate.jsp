<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/food/diary/${foodDiary.id}" method="post">
            <input type="hidden" name="_method" value="put">
            intake:
            <input type="text" name="intake" id="intake" value="${foodDiary.intake}"><br><br>
            intakeUnit:
            <input type="text" name="intakeUnit" id="intakeUnit" value="${foodDiary.intakeUnit}"><br><br>
            kcal:
            <input type="text" name="kcal" id="kcal" value="${foodDiary.kcal}"><br><br>
            carbs:
            <input type="text" name="carbs" id="carbs" value="${foodDiary.carbs}"><br><br>
            protein:
            <input type="text" name="protein" id="protein" value="${foodDiary.protein}"><br><br>
            fat:
            <input type="text" name="fat" id="fat" value="${foodDiary.fat}"><br><br>
            year:
            <input type="text" name="year" id="year" value="${foodDiary.year}"><br><br>
            month:
            <input type="text" name="month" id="month" value="${foodDiary.month}"><br><br>
            day:
            <input type="text" name="day" id="day" value="${foodDiary.day}"><br><br>
            content:
            <textarea type="text" name="content" id="content" row="10" cols="100">${foodDiary.content}</textarea><br><br>
            <input type="submit" class="btn btn-outline-primary me-2" value="update">
        </form>
        <a href="/food/diary/${foodDiary.id}"><h1>back</h1></a>
    </div>
</body>
</html>
