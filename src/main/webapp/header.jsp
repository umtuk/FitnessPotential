<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <h1>Fitness Potential</h1>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="/" class="nav-link px-2 link-secondary">메인</a></li>
            <li><a href="/community" class="nav-link px-2 link-dark">게시판</a></li>
            <li><a href="/fitness/info" class="nav-link px-2 link-dark">운동기구정보</a></li>
            <li><a href="/fitness/routine" class="nav-link px-2 link-dark">운동루틴</a></li>
            <li><a href="/fitness/diary" class="nav-link px-2 link-dark">운동일지</a></li>
            <li><a href="/food/info" class="nav-link px-2 link-dark">음식정보</a></li>
            <li><a href="/food/diary" class="nav-link px-2 link-dark">식단일지</a></li>
        </ul>
        <c:if test="${not empty sessionScope.user}">
            <a href="/user/my">
                <img class="rounded-circle" src="${sessionScope.user.profileImageUrl}" alt="" width="50px" height="50px">
            </a>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <a href="/oauth2/authorization/kakao" class="nav-link px-2 link-dark">로그인</a>
        </c:if>
    </header>
</div>