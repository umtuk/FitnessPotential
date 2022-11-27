<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
<body>
    <head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
    <jsp:include page="/community/entity/communitySummaries.jsp">
        <jsp:param name="communitySummaries" value="${communitySummaries}" />
    </jsp:include>
</body>
</html>