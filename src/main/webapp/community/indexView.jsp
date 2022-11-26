<!DOCTYPE html>
<html lang="en">
<body>
    <jsp:include page="../header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/community">back</a><br>
        <a href="/community/update/${community.id}">update</a><br>
    </div>
    <jsp:include page="/community/entity/community.jsp">
        <jsp:param name="community" value="${community}" />
    </jsp:include>
</body>
</html>