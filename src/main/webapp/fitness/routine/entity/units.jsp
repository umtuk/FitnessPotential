<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="comments">
    <h1>units</h1>
    <c:forEach var="units" varStatus="status" items="${units}">
        <li>
            id: ${units.id} <br>
            title: ${units.title}<br>
            sets: ${units.sets}<br>
            reps: ${units.reps}<br>
            breakTimesPerSet: ${units.breakTimesPerSet}<br>

            <c:set var="fitnessRoutine" value="${fitnessRoutine}" scope="request"></c:set>
            <c:set var="units" value="${units}" scope="request"></c:set>

            <form action="/fitness/routine/unit/${units.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="delete"> <br>
            </form>

            <h2>update</h2>
            <jsp:include page="/fitness/routine/submit/routineUpdate.jsp"></jsp:include>
        </li>
    </c:forEach>
</div>