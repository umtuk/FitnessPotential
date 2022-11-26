<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
<div class="fitnessInfos">
    <c:forEach var="fitnessInfos" varStatus="status" items="${fitnessInfos.content}">
        <div class="list-group w-auto">
            <a href="/fitness/info/${fitnessInfos.id}">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    summary: ${fitnessInfos.summary}<br>
                    <small class="opacity-50 text-nowrap">
                        createdAt: ${fitnessInfos.createdAt}
                    </small>
                </div>
            </a>
        </div>
        <hr>
    </c:forEach>
</div>
    <div class="container-sm">
        <a href="/fitness/info/create">create info</a>
    </div>
</div>
<nav aria-label="Standard pagination example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/fitness/info/search?page=0" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${fitnessInfos.totalPages}">
                <li class="page-item"><a class="page-link" href="/fitness/info/search?page=${i - 1}">${i}</a></li>
            </c:forEach>
        <li class="page-item">
            <a class="page-link" href="/fitness/info/search?page=${fitnessInfos.totalPages-1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</div>