<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div id="foodInfo" class="d-flex gap-2 w-100 justify-content-between">
        <div class="header">
            <h1>${foodInfo.name}</h1><br>
        </div>
            <small class="opacity-50 text-nowrap">
                식품 대분류: ${foodInfo.majorCategory}<br>
                식품 상세분류: ${foodInfo.detailedCategory}<br>
            </small>
    </div>
        1회 제공량: ${foodInfo.servingSize} ${foodInfo.servingSizeUnit}<br>
        칼로리: ${foodInfo.kcal} kcal<br>
        탄수화물: ${foodInfo.carbs} g<br>
        단백질: ${foodInfo.protein} g<br>
        지방: ${foodInfo.fat} g<br>
</div>