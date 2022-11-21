<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="fitnessRoutine">
    <h1>fitnessRoutine</h1>
    <div class="title">
        title: ${fitnessRoutine.title}
    </div>
    <div class="units">
        <c:forEach var="units" varStatus="status" items="${fitnessRoutine.units}">
            <li>units: ${units}</li>
        </c:forEach>
    </div>
    <div class="header">
        id: ${fitnessRoutine.id} <br>
        creatorId: ${fitnessRoutine.creatorId} <br>
        createdAt: ${fitnessRoutine.createdAt} <br>
        updatedAt: ${fitnessRoutine.updatedAt} <br>
        deletedAt: ${fitnessRoutine.deletedAt} <br>
    </div>
    <form action="/fitness/routine/${fitnessRoutine.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="delete"> <br>
    </form>

    <c:set var="fitnessRoutine" value="${fitnessRoutine}" scope="request"></c:set>
    <c:set var="units" value="${fitnessRoutine.units}" scope="request"></c:set>

    <jsp:include page="/fitness/routine/entity/units.jsp"></jsp:include>
    <h2>create units</h2>

    <c:set var="parent" value="${null}" scope="request"></c:set>
    <jsp:include page="/fitness/routine/submit/unitCreate.jsp"></jsp:include>
</div>