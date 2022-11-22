<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="foodInfo">
    <h1>foodInfo</h1>
    <div class="header">
        id: ${foodInfo.id} <br>
        name: ${foodInfo.name}<br>
    </div>
    <div class="content">
        majorCategory: ${foodInfo.majorCategory}<br>
        detailedCategory: ${foodInfo.detailedCategory}<br>
        servingSize: ${foodInfo.servingSize}<br>
        servingSizeUnit: ${foodInfo.servingSizeUnit}<br>
        kcal: ${foodInfo.kcal}<br>
        carbs: ${foodInfo.carbs}<br>
        protein: ${foodInfo.protein}<br>
        fat: ${foodInfo.fat}<br>
    </div>
</div>