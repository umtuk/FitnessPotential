<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/community/comment" method="post">
    <input class="btn btn-outline-primary me-2" type="hidden" name="communityId" value="${community.id}" readonly>
    <input class="btn btn-outline-primary me-2" type="hidden" name="parentCommentId" value="${parent.id}" readonly>
    <input class="btn btn-outline-primary me-2" type="text" name="content">
    <input class="btn btn-outline-primary me-2" type="submit" value="submit">
</form>