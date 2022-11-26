<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../head.jsp"></jsp:include>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
<jsp:include page="/fitness/diary/entity/diaries.jsp">
    <jsp:param name="fitnessDiaries" value="${fitnessDiaries}" />
</jsp:include>
</body>
</html>
