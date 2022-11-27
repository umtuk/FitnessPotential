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
            <li><a href="/fitness" class="nav-link px-2 link-dark">운동</a></li>
            <li><a href="/food" class="nav-link px-2 link-dark">식단</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/oauth2/authorization/kakao' ">Sign-in</button>
        </div>
    </header>
</div>