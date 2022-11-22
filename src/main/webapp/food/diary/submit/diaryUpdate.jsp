<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fitnessFoodUpdate</title>
</head>
<body>
<form action="/food/diary/${fitnessFood.id}" method="post">
    <input type="hidden" name="_method" value="put">
    content: <input type="text" name="content" id="content" value="${fitnessFood.content}"><br>
    intake: <input type="text" name="intake" id="intake" value="${fitnessFood.intake}"><br>
    intakeUnit:<input type="text" name="intakeUnit" id="intakeUnit" value="${fitnessFood.intakeUnit}"><br>
    kcal: <input type="text" name="kcal" id="kcal" value="${fitnessFood.kcal}"><br>
    carbs: <input type="text" name="carbs" id="carbs" value="${fitnessFood.carbs}"><br>
    protein: <input type="text" name="protein" id="protein" value="${fitnessFood.protein}"><br>
    fat:<input type="text" name="fat" id="fat" value="${fitnessFood.fat}"><br>
    year: <input type="text" name="year" id="year" value="${fitnessFood.year}"><br>
    month: <input type="text" name="month" id="month" value="${fitnessFood.month}"><br>
    day: <input type="text" name="day" id="day" value="${fitnessFood.day}"><br>
    <input type="submit" value="submit">
</form>
<a href="/food/diary/${fitnessFood.id}"><h1>back</h1></a>
</body>
</html>
