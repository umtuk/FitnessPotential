<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div class="foodDiaries">
        <c:forEach var="foodDiary" varStatus="status" items="${foodDiaries}">
            <div class="list-group w-auto">
                <a href="/food/diary/${foodDiary.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <h3 class="mb-0">${foodDiary.content}-${foodDiary.kcal} kcal-탄수화물 ${foodDiary.carbs}g-단백질 ${foodDiary.protein}g-지방 ${foodDiary.fat}g</h3>
                        <small class="opacity-50 text-nowrap">
                        </small>
                    </div>
                </a>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container-sm">
    <a href="/food/diary/create">create diary</a>
</div>
<form method="get" action="/food/diary/search">
    year: <input type="number" name="year" value="${year}"> <br>
    month: <input type="number" name="month" value="${month}"> <br>
    day: <input type="number" name="day" value="${day}"> <br>
    <input type="submit" value="submit">
</form>