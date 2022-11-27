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
                    태그: ${communitySummary.tags}
                </div>
                <small class="opacity-50 text-nowrap">
                    조회수: ${communitySummary.views} <br>
                </small>
            </div>
            </a>
            <hr>
        </div>
    </c:forEach>
</div>
</div>
<div class="container-sm">
    <a href="/community/create">게시판 생성하기</a>
</div>
<div class="page">
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