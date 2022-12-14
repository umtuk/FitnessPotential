<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <c:forEach var="fitnessRoutine" varStatus="status" items="${fitnessRoutines}">
        <div class="list-group w-auto">
            <a href="/fitness/routine/${fitnessRoutine.id}">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <h2>${fitnessRoutine.title}<br></h2>
                    <small class="opacity-50 text-nowrap">
                        <c:forEach var="unit" varStatus="uStatus" items="${fitnessRoutine.units}">
                            ${unit.title} <br>
                        </c:forEach>
                    </small>
                </div>
            </a>
        </div>
        <hr>
    </c:forEach>
</div>
<div class="container-sm">
    <a href="/fitness/routine/create">운동 루틴 생성하기</a>
</div>