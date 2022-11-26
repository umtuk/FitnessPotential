<html>
<jsp:include page="../../../head.jsp"></jsp:include>
<body>
<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container-sm">
    <form action="/fitness/info/${fitnessInfo.id}" method="post">
        <input type="hidden" name="_method" value="put">
        title:
        <input type="text" name="title" id="title" value="${fitnessInfo.title}"> <br>
        summary:
        <input type="text" name="summary" id="summary" value="${fitnessInfo.summary}"><br>
        content:
        <textarea type="text" class="w-100" name="content" id="content" rows="10" cols="100">${fitnessInfo.content}</textarea>
        <input type="submit" class="btn btn-outline-primary me-2" value="update">
    </form>
    <a href="/fitness/info/${fitnessInfo.id}">back</a>
</div>
</body>
</html>

