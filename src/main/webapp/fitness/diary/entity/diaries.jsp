<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <div class="fitnessDiaries">
        <c:forEach var="fitnessDiary" varStatus="status" items="${fitnessDiaries}">
            <div class="list-group w-auto">
                <a href="/fitness/diary/${fitnessDiary.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <h3 class="mb-0">${fitnessDiary.title}</h3>
                        <small class="opacity-50 text-nowrap">
                            fitnessInfoId: ${fitnessDiary.fitnessInfoId}
                        </small>
                    </div>
                </a>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container-sm">
    <a href="/fitness/diary/create">create diary</a>
</div>

<c:set var="year" value="${year}" scope="request"></c:set>
<c:set var="month" value="${month}" scope="request"></c:set>
<c:set var="day" value="${day}" scope="request"></c:set>
<jsp:include page="/fitness/diary/entity/diaryCalender.jsp"></jsp:include>