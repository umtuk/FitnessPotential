<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/food/diary/entity/diaries.jsp">
    <jsp:param name="foodDiaries" value="${foodDiaries}" />
</jsp:include>
</body>
</html>