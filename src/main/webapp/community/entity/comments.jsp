<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="comments">
    <h1>comments</h1>
    <c:forEach var="comment" varStatus="status" items="${comments}">
        <li>
            id: ${comment.id} <br>
            creatorId: ${comment.creatorId} <br>
            parentCommentId: ${comment.parentCommentId} <br>
            content: ${comment.content} <br>
            likes: ${comment.likes} <br>
            hates: ${comment.hates} <br>
            createdAt: ${comment.createdAt} <br>
            updatedAt: ${comment.updatedAt} <br>
            deletedAt: ${comment.deletedAt} <br>

            <c:set var="community" value="${community}" scope="request"></c:set>
            <c:set var="comment" value="${comment}" scope="request"></c:set>
            <c:set var="parent" value="${comment}" scope="request"></c:set>

            <form action="/community/comment/${comment.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="delete"> <br>
            </form>

            <h2>create child comment</h2>
            <jsp:include page="/community/submit/commentCreate.jsp"></jsp:include>
            <h2>update</h2>
            <jsp:include page="/community/submit/commentUpdate.jsp"></jsp:include>
        </li>
    </c:forEach>
</div>