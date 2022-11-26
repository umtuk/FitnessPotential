<div class="container-sm">
    <div id="community" class="d-flex gap-2 w-100 justify-content-between">
        <div class="title">
            <h1>title: ${community.title}</h1>
        </div>
        <div class="header">
            <small class="opacity-50 text-nowrap">
                creatorId: ${community.creatorId} <br>
                views: ${community.views} <br>
                createdAt: ${community.createdAt} <br>
            </small>
        </div>
    </div>
    <div class="tags">
        tag:&nbsp;&nbsp;
        <c:forEach var="tag" varStatus="status" items="${community.tags}">
            ${tag}&nbsp;&nbsp;
        </c:forEach>
    </div>
    <hr class="opacity-50">
    <span class="border-1 border-dark border-opacity-50">
        <div class="content min-vh-100 w-100">
            content: ${community.content}
        </div>
    </span>
    <hr class="opacity-50">
    <form action="/community/${community.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="delete"> <br>
    </form>
    <c:set var="community" value="${community}" scope="request"></c:set>
    <c:set var="comments" value="${community.comments}" scope="request"></c:set>
    <br><br>
    <jsp:include page="/community/entity/comments.jsp"></jsp:include>
    <br><br>
    <h2>create root comment</h2>
    <c:set var="parent" value="${null}" scope="request"></c:set>
    <jsp:include page="/community/submit/commentCreate.jsp"></jsp:include>
</div>