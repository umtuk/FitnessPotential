<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script src="/js/fitnessUnit.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <a href="/fitness/routine">뒤로가기</a><br>
        <a href="/fitness/routine/update/${fitnessRoutine.id}">루틴 제목 수정하기</a>
    </div>
    <jsp:include page="/fitness/routine/entity/routine.jsp">
        <jsp:param name="fitnessRoutine" value="${fitnessRoutine}" />
    </jsp:include>
    <jsp:include page="/footer.jsp"></jsp:include>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>