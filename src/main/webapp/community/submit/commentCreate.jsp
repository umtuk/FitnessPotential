<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/community/comment" method="post">
    <input type="hidden" name="communityId" value="${community.id}" readonly>
    <input type="hidden" name="parentCommentId" value="${parent.id}" readonly>
    <input type="text" name="content">
    <input type="submit" value="submit">
</form>