<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div id="foodInfo" class="d-flex gap-2 w-100 justify-content-between">
        <div class="header">
            <h1>name: ${foodInfo.name}</h1><br>
        </div>
            <small class="opacity-50 text-nowrap">
                majorCategory: ${foodInfo.majorCategory}<br>
                detailedCategory: ${foodInfo.detailedCategory}<br>
            </small>
    </div>
        servingSize: ${foodInfo.servingSize}<br>
        servingSizeUnit: ${foodInfo.servingSizeUnit}<br>
        kcal: ${foodInfo.kcal}<br>
        carbs: ${foodInfo.carbs}<br>
        protein: ${foodInfo.protein}<br>
        fat: ${foodInfo.fat}<br>
</div>