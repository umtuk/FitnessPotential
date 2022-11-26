<!DOCTYPE html>
<html lang="en">
<body>
    <jsp:include page="../../header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/fitness/diary">back</a><br>
        <a href="/fitness/diary/update/${fitnessDiary.id}">update</a>
    </div>
    <jsp:include page="/fitness/diary/entity/diary.jsp">
        <jsp:param name="fitnessDiary" value="${fitnessDiary}" />
    </jsp:include>
</body>
</html>