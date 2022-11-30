<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main role="main" class="container">
      <div class="card flex-md-row mb-4 box-shadow h-md-250">
        <div class="card-body d-flex flex-column align-items-start">
          <strong class="d-inline-block mb-2 text-primary"></strong>
          <h3 class="mb-0">
            <a class="text-dark" href="#">${user.nickname}님 환영합니다.</a>
          </h3>
          <div class="mb-1 text-muted"></div>
          <p class="card-text mb-auto"></p>
          <a href="/logout">로그아웃</a>
        </div>
        <img src="${user.profileImageUrl}" alt="" width="200px" height="200px">
      </div>
  </main>