<form action="/community/comment" method="post">
    <input class="btn btn-outline-primary me-2" type="hidden" name="communityId" value="${community.id}" readonly>
    <input class="btn btn-outline-primary me-2" type="hidden" name="parentCommentId" value="${parent.id}" readonly>
    <input class="btn btn-outline-primary me-2" type="text" name="content">
    <input class="btn btn-outline-primary me-2" type="submit" value="submit">
</form>