<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="communitySummaries">
    <h1>communitySummaries</h1>
    <c:forEach var="communitySummary" varStatus="status" items="${communitySummaries.content}">
        <li>
            <a href="/community/${communitySummary.id}">
                id: ${communitySummary.id} <br>
                creatorId: ${communitySummary.creatorId} <br>
                tags: ${communitySummary.tags} <br>
                views: ${communitySummary.views} <br>
                likes: ${communitySummary.likes} <br>
                hates: ${communitySummary.hates} <br>
                createdAt: ${communitySummary.createdAt} <br>
                updatedAt: ${communitySummary.updatedAt} <br>
                deletedAt: ${communitySummary.deletedAt} <br>
            </a>
        </li>
    </c:forEach>
</div>
<div class="page">
    <h1>page</h1>
    totalPage: ${communitySummaries.totalPages} <br>
    totalElement: ${communitySummaries.totalElements} <br>
    size: ${communitySummaries.size} <br>
    number: ${communitySummaries.number} <br>
    <c:forEach var="i" varStatus="status" begin="1" end="${communitySummaries.totalPages}">
        <a href="/community/search?page=${i - 1}">${i}</a>
    </c:forEach>
</div>