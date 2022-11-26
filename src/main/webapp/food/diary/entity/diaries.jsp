<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div class="foodDiaries">
        <c:forEach var="foodDiaries" varStatus="status" items="${foodDiaries.content}">
            <div class="list-group w-auto">
                <a href="/food/diary/${foodDiaries.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <h3 class="mb-0">${foodDiaries.year}-${foodDiaries.month}-${foodDiaries.day}</h3>
                        <small class="opacity-50 text-nowrap">
                        </small>
                    </div>
                </a>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container-sm">
    <a href="/food/diary/create">create diary</a>
</div>
<div class="page">
    <nav aria-label="Standard pagination example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="/food/diary/search?page=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${foodDiaries.totalPages}">
                <li class="page-item"><a class="page-link" href="/food/diary/search?page=${i-1}">${i}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/food/diary/search?page=${foodDiaries.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>