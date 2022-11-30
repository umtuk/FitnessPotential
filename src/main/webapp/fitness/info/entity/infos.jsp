<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <div class="fitnessInfos">
        <c:forEach var="fitnessInfos" varStatus="status" items="${fitnessInfos.content}">
            <div class="list-group w-auto">
                <a href="/fitness/info/${fitnessInfos.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <img src="/storage/${fitnessInfos.thumbnail}" alt="" width="50" height="50">
                        ${fitnessInfos.title}<br>
                        ${fitnessInfos.summary}<br>
                        <small class="opacity-50 text-nowrap">
                            
                        </small>
                    </div>
                </a>
            </div>
            <hr>
        </c:forEach>
    </div>

    <!-- 삭제 예정 -->
    <div class="container-sm">
        <a href="/fitness/info/create">create info</a>
    </div>


</div>

<c:set var="majorCategory" value="${majorCategory}" scope="request"></c:set>
<c:set var="detailedCategory" value="${detailedCategory}" scope="request"></c:set>
<jsp:include page="/fitness/info/entity/infoCategory.jsp"></jsp:include>

<nav aria-label="Standard pagination example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/fitness/info/search?page=0&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${fitnessInfos.totalPages}">
                <li class="page-item"><a class="page-link" href="/fitness/info/search?page=${i - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}">${i}</a></li>
            </c:forEach>
        <li class="page-item">
            <a class="page-link" href="/fitness/info/search?page=${fitnessInfos.totalPages - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>