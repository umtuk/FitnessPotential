<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../head.jsp"></jsp:include>s
<body>
    <jsp:include page="../../header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/fitness/routine">back</a><br>
        <a href="/fitness/routine/update/${fitnessRoutine.id}">update</a>
    </div>
    <jsp:include page="/fitness/routine/entity/routine.jsp">
        <jsp:param name="fitnessRoutine" value="${fitnessRoutine}" />
    </jsp:include>
</body>
</html>