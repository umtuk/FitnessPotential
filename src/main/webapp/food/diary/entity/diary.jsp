<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
<div id="foodDiary" class="d-flex gap-2 w-100 justify-content-between">
    <div class="header">
        <h3>${foodDiary.year}-${foodDiary.month}-${foodDiary.day}</h3><br><br>
    </div>
    <small class="opacity-50 text-nowrap">
        creatorId: ${foodDiary.creatorId} <br>
        createdAt: ${foodDiary.createdAt} <br>
    </small>
</div>
    <div class="content">
        content: ${foodDiary.content}<br>
        intake: ${foodDiary.intake}<br>
        intakeUnit: ${foodDiary.intakeUnit}<br>
        kcal: ${foodDiary.kcal}<br>
        carbs: ${foodDiary.carbs}<br>
        protein: ${foodDiary.protein}<br>
        fat: ${foodDiary.fat}<br>
        <img src="/storage/${foodDiary.thumbnail}" alt="" srcset="">
    </div>
    <form action="/food/diary/${foodDiary.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="delete"> <br>
    </form>
</div>