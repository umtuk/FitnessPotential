<!DOCTYPE html>
<html lang="en">
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <jsp:include page="/community/entity/communitySummaries.jsp">
        <jsp:param name="communitySummaries" value="${communitySummaries}" />
    </jsp:include>
</body>
</html>