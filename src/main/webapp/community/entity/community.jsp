<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="community">
    <h1>community</h1>
    <div class="title">
        title: ${community.title}
    </div>
    <div class="tags">
        <c:forEach var="tag" varStatus="status" items="${community.tags}">
            <li>tag: ${tag}</li>
        </c:forEach>
    </div>
    <div class="header">
        id: ${community.id} <br>
        creatorId: ${community.creatorId} <br>
        views: ${community.views} <br>
        createdAt: ${community.createdAt} <br>
        updatedAt: ${community.updatedAt} <br>
        deletedAt: ${community.deletedAt} <br>
    </div>
    <div class="content">
        content: ${community.content}
    </div>
    <div class="footer">
        likes: ${community.likes} <br>
        hates: ${community.hates} <br>
    </div>
    <form action="/community/${community.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="delete"> <br>
    </form>

    <c:set var="community" value="${community}" scope="request"></c:set>
    <c:set var="comments" value="${community.comments}" scope="request"></c:set>

    <jsp:include page="/community/entity/comments.jsp"></jsp:include>
    <h2>create root comment</h2>

    <c:set var="parent" value="${null}" scope="request"></c:set>
    <jsp:include page="/community/submit/commentCreate.jsp"></jsp:include>
</div>