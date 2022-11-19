<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/community/comment/${comment.id}" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="communityId" value="${community.id}" readonly>
    <input type="hidden" name="parentCommentId" value="${comment.id}" readonly>
    <input type="text" name="content" value="${comment.content}">
    <input type="submit" value="submit">
</form>