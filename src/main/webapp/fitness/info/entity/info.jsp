<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div id="fitnessInfo" class="d-flex gap-2 w-100 justify-content-between">
        <div class="title">
            <h1>${fitnessInfo.title}</h1>
        </div>
        <div class="header">
            <small class="opacity-50 text-nowrap">
                주 타겟 부위: ${fitnessInfo.majorCategory} <br>
                세부 타겟 부위: ${fitnessInfo.detailedCategory}
            </small>
        </div>
    </div>
    <hr>
    <div class="content">
        <img src="/storage/${fitnessInfo.thumbnail}" alt="" srcset=""> <br>
        ${fitnessInfo.content}<br>
    </div>
    <c:if test="${not empty param.fitnessRoutineId}">
        <a href="/fitness/routine/submit/unitCreateView.jsp?fitnessRoutineId=${param.fitnessRoutineId}&title=${fitnessInfo.title}&fitnessInfoId=${fitnessInfo.id}">운동 추가하기</a>
    </c:if>
</div>