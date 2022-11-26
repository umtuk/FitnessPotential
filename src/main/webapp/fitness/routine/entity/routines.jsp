<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <c:forEach var="fitnessRoutines" varStatus="status" items="${fitnessRoutines.content}">
        <div class="list-group w-auto">
            <a href="/fitness/routine/${fitnessRoutines.id}">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <h2>title: ${fitnessRoutines.title}<br></h2>
                    <small class="opacity-50 text-nowrap">
                        createdAt: ${fitnessRoutines.createdAt} <br>
                    </small>
                </div>
            </a>
        </div>
        <hr>
    </c:forEach>
</div>
<div class="container-sm">
    <a href="/fitness/routine/create">create routine</a>
</div>
<nav aria-label="Standard pagination example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/fitness/routine/search?page=0" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" varStatus="status" begin="1" end="${fitnessRoutines.totalPages}">
            <li class="page-item"><a class="page-link" href="/fitness/routine/search?page=${i - 1}">${i}</a></li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link" href="/fitness/routine/search?page=${fitnessRoutines.totalPages-1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>