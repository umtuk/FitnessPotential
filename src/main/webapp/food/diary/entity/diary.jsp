<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
<div id="foodDiary" class="d-flex gap-2 w-100 justify-content-between">
    <div class="header">
        <h3>${foodDiary.year}-${foodDiary.month}-${foodDiary.day}</h3><br><br>
    </div>
    <small class="opacity-50 text-nowrap">
    </small>
</div>
    <div class="content">
        내용: ${foodDiary.content}<br>
        섭취량: ${foodDiary.intake} ${foodDiary.intakeUnit}<br>
        칼로리(kcal): ${foodDiary.kcal}<br>
        탄수화물(g): ${foodDiary.carbs}<br>
        단백질: ${foodDiary.protein}<br>
        지방: ${foodDiary.fat}<br>
        <c:if test="${not empty foodDiary.thumbnail}">
            <img src="/storage/${foodDiary.thumbnail}" alt="" srcset="">
        </c:if>
    </div>
    <form action="/food/diary/${foodDiary.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="삭제하기"> <br>
    </form>
</div>