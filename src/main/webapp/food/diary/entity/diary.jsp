<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="foodDiary">
    <h1>foodDiary</h1>
    <div class="header">
        id: ${foodDiary.id} <br>
        creatorId: ${foodDiary.creatorId} <br>
        createdAt: ${foodDiary.createdAt} <br>
        updatedAt: ${foodDiary.updatedAt} <br>
        deletedAt: ${foodDiary.deletedAt} <br>
    </div>
    <div class="content">
        content: ${foodDiary.content}<br>
        intake: ${foodDiary.intake}<br>
        intakeUnit: ${foodDiary.intakeUnit}<br>
        kcal: ${foodDiary.kcal}<br>
        carbs: ${foodDiary.carbs}<br>
        protein: ${foodDiary.protein}<br>
        fat: ${foodDiary.fat}<br>
        year: ${foodDiary.year}<br>
        month: ${foodDiary.month}<br>
        day: ${foodDiary.day}<br>
    </div>
    <form action="/food/diary/${foodDiary.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="delete"> <br>
    </form>
</div>