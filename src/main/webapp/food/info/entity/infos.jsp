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
                        ${foodInfos.majorCategory}<br>
                        ${foodInfos.detailedCategory}<br>
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
        <form action="/food/info/category" method="get">
            <div class="majorCategory">
                <c:forEach var="category" varStatus="status" items="${foodInfoCategory.categories.ketSet()}">
                    
                </c:forEach>
            </div>
            majorCategory: <input type="text" id="majorCategory" name="majorCategory" value="${majorCategory}">
            detailedCategory: <input type="text" id="detailedCategory" name="detailedCategory" value="${detailedCategory}">
            <input type="submit" class="btn btn-outline-primary me-2" value="search">
        </form>
    </div>
</div><br>
<div class="page">
    <nav aria-label="Standard pagination example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="/food/info/category?page=0&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
                <c:forEach var="i" varStatus="status" begin="1" end="${foodInfos.totalPages}">
                    <li class="page-item"><a class="page-link" href="/food/info/category?page=${i - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}">${i}</a></li>
                </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/food/info/category?page=${foodInfos.totalPages - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>