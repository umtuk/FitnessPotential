<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div class="fitnessDiaries">
        <c:forEach var="fitnessDiaries" varStatus="status" items="${fitnessDiaries.content}">
            <div class="list-group w-auto">
                <a href="/fitness/diary/${fitnessDiaries.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <h3 class="mb-0">${fitnessDiaries.title}</h3>
                        <small class="opacity-50 text-nowrap">
                            fitnessInfoId: ${fitnessDiaries.fitnessInfoId}
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
<div class="page">
    <nav aria-label="Standard pagination example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="/fitness/diary/search?page=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${fitnessDiaries.totalPages}">
                <li class="page-item"><a class="page-link" href="/fitness/diary/search?page=${i-1}">${i}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/fitness/diary/search?page=${fitnessDiaries.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>