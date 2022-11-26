<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div id="fitnessRoutine" class="d-flex gap-2 w-100 justify-content-between">
    <div class="title">
        <h1>title: ${fitnessRoutine.title}</h1>
    </div>
    <small class="opacity-50 text-nowrap">
        id: ${fitnessRoutine.id} <br>
        creatorId: ${fitnessRoutine.creatorId} <br>
        createdAt: ${fitnessRoutine.createdAt} <br>
    </small>
    </div><br>
    <form action="/fitness/routine/${fitnessRoutine.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="delete"> <br>
    </form><br>
    <c:set var="fitnessRoutine" value="${fitnessRoutine}" scope="request"></c:set>
    <c:set var="units" value="${fitnessRoutine.units}" scope="request"></c:set>

    <jsp:include page="/fitness/routine/entity/units.jsp"></jsp:include>

    <h2>create units</h2>
    <c:set var="parent" value="${null}" scope="request"></c:set>
    <jsp:include page="/fitness/routine/submit/unitCreate.jsp"></jsp:include>
</div>