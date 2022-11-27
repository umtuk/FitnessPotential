<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
<body>
    <head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
    <div class="container-sm">
        <a href="/community">back</a><br>
        <a href="/community/update/${community.id}">update</a><br>
    </div>
    <jsp:include page="/community/entity/community.jsp">
        <jsp:param name="community" value="${community}" />
    </jsp:include>
</body>
</html>