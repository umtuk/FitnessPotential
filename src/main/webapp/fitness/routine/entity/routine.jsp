<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div id="fitnessRoutine" class="d-flex gap-2 w-100 justify-content-between">
    <div class="title">
        <h1>${fitnessRoutine.title}</h1>
    </div>
    <small class="opacity-50 text-nowrap">

    </small>
    </div><br>
    <form action="/fitness/routine/${fitnessRoutine.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="운동 루틴 삭제하기"> <br>
    </form><br>

    <c:set var="fitnessRoutineId" value="${fitnessRoutine.id}" scope="request"></c:set>
    <c:set var="units" value="${fitnessRoutine.units}" scope="request"></c:set>
    <jsp:include page="/fitness/routine/entity/units.jsp"></jsp:include>

    <a href="/fitness/routine/select?fitnessRoutineId=${fitnessRoutine.id}"><h3>운동 추가하기</h3></a>
    <a href="/fitness/routine/start?fitnessRoutineId=${fitnessRoutine.id}&unitIndex=0"><h2>운동 루틴 시작하기</h2></a>
</div>