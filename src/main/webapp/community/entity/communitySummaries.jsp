<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
    a:link { color: black; text-decoration: none;}
    a:visited { color: black; text-decoration: none;}
    a:hover { color: black; text-decoration: none;}
</style>

<div class="container-sm">
<div class="communitySummaries">
    <c:forEach var="communitySummary" varStatus="status" items="${communitySummaries.content}">
        <div class="list-group w-auto">
            <a href="/community/${communitySummary.id}">
            <div class="d-flex gap-2 w-100 justify-content-between">
                <div>
                    <h6 class="mb-0">${communitySummary.title}</h6><br>
                    tags: ${communitySummary.tags}
<%--                    <p class="mb-0 opacity-75">Some placeholder content in a paragraph.</p>--%>
                </div>
                <small class="opacity-50 text-nowrap">
                    views: ${communitySummary.views} <br>
                    likes: ${communitySummary.likes} <br>
                    createdAt: ${communitySummary.createdAt} <br>
                </small>
<%--                id: ${communitySummary.id} <br>--%>
<%--                creatorId: ${communitySummary.creatorId} <br>--%>
<%--                updatedAt: ${communitySummary.updatedAt} <br>--%>
<%--                deletedAt: ${communitySummary.deletedAt} <br>--%>
            </div>
            </a>
            <hr>
        </div>
    </c:forEach>
</div>
</div>
<div class="container-sm">
      <a href="/community/create">create community</a>
</div>
<div class="page">
<%--    totalPage: ${communitySummaries.totalPages} <br>--%>
<%--    totalElement: ${communitySummaries.totalElements} <br>--%>
<%--    size: ${communitySummaries.size} <br>--%>
<%--    number: ${communitySummaries.number} <br>--%>
<%--    <c:forEach var="i" varStatus="status" begin="1" end="${communitySummaries.totalPages}">--%>
<%--        <a href="/community/search?page=${i - 1}">${i}</a>--%>
<%--    </c:forEach>--%>
    <nav aria-label="Standard pagination example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="/community/search?page=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${communitySummaries.totalPages}">
                <li class="page-item"><a class="page-link" href="/community/search?page=${i-1}">${i}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/community/search?page=${communitySummaries.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>