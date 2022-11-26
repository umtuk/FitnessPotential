<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <ul class="list-group">
        <c:forEach var="units" varStatus="status" items="${units}">
            <li class="list-group-item">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    id: ${units.id} <br>
                    title: ${units.title}<br>
                    <small class="opacity-50 text-nowrap">
                        sets: ${units.sets}<br>
                        reps: ${units.reps}<br>
                        breakTimesPerSet: ${units.breakTimesPerSet}<br>
                    </small>
                </div>
                <c:set var="fitnessRoutine" value="${fitnessRoutine}" scope="request"></c:set>
                <c:set var="units" value="${units}" scope="request"></c:set>

                <form action="/fitness/routine/unit/${units.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" class="btn btn-outline-primary me-2" value="delete"> <br>
                </form>
            </li>
        </c:forEach>
    </ul>
</div>