<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
    a:link { color: black; text-decoration: none;}
    a:visited { color: black; text-decoration: none;}
    a:hover { color: black; text-decoration: none;}
</style>
<div class="container-sm">
    <div class="comments">
        <c:forEach var="comment" varStatus="status" items="${comments}">
            <div class="list-group w-auto">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    ${comment.content} <br>
                    <small class="opacity-50 text-nowrap">
                        <form action="/community/comment/${comment.id}" method="post">
                            <input class="btn btn-outline-primary me-2" type="hidden" name="_method" value="delete">
                            <input class="btn btn-outline-primary me-2" type="submit" value="댓글 삭제하기"> <br>
                        </form>
                    </small>
                </div>
                <!-- <c:set var="community" value="${community}" scope="request"></c:set>
                <c:set var="comment" value="${comment}" scope="request"></c:set>
                <c:set var="parent" value="${comment}" scope="request"></c:set>
                <p>create child comment
                <jsp:include page="/community/submit/commentCreate.jsp"></jsp:include></p> -->
            </div>
        </c:forEach>
    </div>
</div>