<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="foodInfos">
    <h1>foodInfos</h1>
    <c:forEach var="foodInfos" varStatus="status" items="${foodInfos.content}">
        <li>
            <a href="/food/info/${foodInfos.id}">
                id: ${foodInfos.id} <br>
                name: ${foodInfos.name}<br>
                majorCategory: ${foodInfos.majorCategory}<br>
                detailedCategory: ${foodInfos.detailedCategory}<br>
            </a>
        </li>
    </c:forEach>
</div>
<div>
<%--    <select name="majorCategory" id="majorCategory">--%>
<%--        <option>구이류</option>--%>
<%--        <option>국 및 탕류</option>--%>
<%--        <option>볶음류</option>--%>
<%--        <option>기타</option>--%>
<%--        <option>튀김류</option>--%>
<%--        <option>회류</option>--%>
<%--        <option>찌개 및 전골류</option>--%>
<%--    </select>--%>
    <form action="/food/info/category" method="get">
        majorCategory: <input type="text" id="majorCategory" name="majorCategory" value="${majorCategory}">
        detailedCategory: <input type="text" id="detailedCategory" name="detailedCategory" value="${detailedCategory}">
        <input type="submit" value="search">
    </form>
</div>
<div class="page">
    <h1>page</h1>
    totalPage: ${foodInfos.totalPages} <br>
    totalElement: ${foodInfos.totalElements} <br>
    size: ${foodInfos.size} <br>
    number: ${foodInfos.number} <br>
    <c:forEach var="i" varStatus="status" begin="1" end="${foodInfos.totalPages}">
        <a href="/food/info/category?page=${i - 1}&majorCategory=${majorCategory}&detailedCategory=${detailedCategory}">${i}</a>
    </c:forEach>
</div>