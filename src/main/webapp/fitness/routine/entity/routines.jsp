<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="fitnessRoutines">
    <h1>fitnessRoutines</h1>
    <c:forEach var="fitnessRoutines" varStatus="status" items="${fitnessRoutines.content}">
        <li>
            <a href="/fitness/routine/${fitnessRoutines.id}">
                id: ${fitnessRoutines.id} <br>
                creatorId: ${fitnessRoutines.creatorId} <br>
                title: ${fitnessRoutines.title}<br>
                createdAt: ${fitnessRoutines.createdAt} <br>
                updatedAt: ${fitnessRoutines.updatedAt} <br>
                deletedAt: ${fitnessRoutines.deletedAt} <br>
            </a>
        </li>
    </c:forEach>
</div>
<div class="page">
    <h1>page</h1>
    totalPage: ${fitnessRoutines.totalPages} <br>
    totalElement: ${fitnessRoutines.totalElements} <br>
    size: ${fitnessRoutines.size} <br>
    number: ${fitnessRoutines.number} <br>
    <c:forEach var="i" varStatus="status" begin="1" end="${fitnessRoutines.totalPages}">
        <a href="/fitness/routine/search?page=${i - 1}">${i}</a>
    </c:forEach>
</div>