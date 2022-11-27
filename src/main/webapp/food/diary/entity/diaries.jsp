<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div class="foodDiaries">
        <c:forEach var="foodDiary" varStatus="status" items="${foodDiaries}">
            <div class="list-group w-auto">
                <a href="/food/diary/${foodDiary.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <h3 class="mb-0">${foodDiary.content}</h3>
                        <small class="opacity-50 text-nowrap">
                            섭취량: ${foodDiary.intake} ${foodDiary.intakeUnit}<br>
                            칼로리: ${foodDiary.kcal} kcal <br>
                            탄수화물: ${foodDiary.carbs}g <br>
                            단백질: ${foodDiary.protein}g <br>
                            지방: ${foodDiary.fat}g
                        </small>
                    </div>
                </a>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container-sm">
    <a href="/food/diary/create">식단 일지 생성하기</a>
</div>
<form method="get" action="/food/diary/search">
    날짜(yyyy-mm-dd): 
    <input type="number" name="year" value="${year}">-
    <input type="number" name="month" value="${month}">-
    <input type="number" name="day" value="${day}">-
    <input type="submit" value="submit">
</form>