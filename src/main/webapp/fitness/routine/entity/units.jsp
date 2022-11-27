<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <ul class="list-group">
        <c:forEach var="units" varStatus="status" items="${units}">
            <li class="list-group-item">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <!-- id: ${units.id} <br> -->
                    ${units.title}<br>
                    <small class="opacity-50 text-nowrap">
                        세트수: ${units.sets}<br>
                        반복횟수: ${units.reps}<br>
                        중량(kg): ${units.weights}<br>
                        휴식시간(초): ${units.breakTimesPerSet}<br>
                    </small>
                </div>

                <form action="/fitness/routine/unit/${units.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" class="btn btn-outline-primary me-2" value="운동 삭제"> <br>
                </form>
            </li>
        </c:forEach>
    </ul>
</div>