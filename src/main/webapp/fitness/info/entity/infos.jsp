<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="fitnessInfos">
    <h1>fitnessInfos</h1>
    <c:forEach var="fitnessInfos" varStatus="status" items="${fitnessInfos.content}">
        <li>
            <a href="/fitness/info/${fitnessInfos.id}">
                id: ${fitnessInfos.id} <br>
                summary: ${fitnessInfos.summary}<br>
                createdAt: ${fitnessInfos.createdAt} <br>
                updatedAt: ${fitnessInfos.updatedAt} <br>
                deletedAt: ${fitnessInfos.deletedAt} <br>
            </a>
        </li>
    </c:forEach>
</div>
<div class="page">
    <h1>page</h1>
    totalPage: ${fitnessInfos.totalPages} <br>
    totalElement: ${fitnessInfos.totalElements} <br>
    size: ${fitnessInfos.size} <br>
    number: ${fitnessInfos.number} <br>
    <c:forEach var="i" varStatus="status" begin="1" end="${fitnessInfos.totalPages}">
        <a href="/fitness/info/search?page=${i - 1}">${i}</a>
    </c:forEach>
</div>