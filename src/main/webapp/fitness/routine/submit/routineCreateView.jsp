<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script src="/js/fitnessUnit.js"></script>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/fitness/routine" method="post">
            제목:
            <input type="text" class="w-100" name="title" id="title"> <br>
            <br>
            <input type="submit" class="btn btn-outline-primary me-2" value="운동 루틴 생성하기">
        </form><br>
        <a href="/fitness/routine"><h1>뒤로가기</h1></a>
    </div>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>