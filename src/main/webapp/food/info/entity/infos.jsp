<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div class="foodInfos">
        <c:forEach var="foodInfos" varStatus="status" items="${foodInfos.content}">
            <div class="list-group w-auto">
                <a href="/food/info/${foodInfos.id}">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <div>
                                ${foodInfos.name}<br>
                        </div>
                        <small class="opacity-50 text-nowrap">
                                1회 제공량: ${foodInfos.servingSize} ${foodInfos.servingSizeUnit}<br>
                                칼로리: ${foodInfos.kcal} kcal<br>
                                탄수화물: ${foodInfos.carbs} g<br>
                                단백질: ${foodInfos.protein} g<br>
                                지방: ${foodInfos.fat} g<br>
                        </small>
                    </div>
                </a>
                <hr>
            </div>  
        </c:forEach>
    </div>
</div>
<div class="container">
    <div class="row justify-content-center">
        <c:set var="majorCategory" value="${majorCategory}" scope="request"></c:set>
        <c:set var="detailedCategory" value="${detailedCategory}" scope="request"></c:set>
        <jsp:include page="/food/info/entity/infoCategory.jsp"></jsp:include>
    </div>
</div><br>
<div class="page">
    <nav aria-label="Standard pagination example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="/food/info/search?page=0&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${foodInfos.totalPages}">
                <li class="page-item"><a class="page-link" href="/food/info/search?page=${i - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}">${i}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/food/info/search?page=${foodInfos.totalPages - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>