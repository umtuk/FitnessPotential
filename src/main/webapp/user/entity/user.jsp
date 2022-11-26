<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="user">
    nickname: ${user.nickname} <br>
    <img src="${user.profileImageUrl}" alt="No content">
</div>