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
        <form id="fitnessUnitCreate" method="post" action="/fitness/diary">
            제목: <input type="text" name="title" value="${param.title}" readonly required minlength="5" maxlength="64"><br>
            <input type="hidden" name="fitnessInfoId" value="${param.fitnessInfoId}" readonly required>
            <input type="hidden" name="sets" required min="1" max="30">
            날짜(yyyy-mm-dd): 
            <input type="number" name="year" required min="0" max="9999">-
            <input type="number" name="month" required min="1" max="12">-
            <input type="number" name="day" required min="1" max="31"><br>
        
            <div class="sets">
                
            </div>
        
            <input type="submit" value="일지 추가하기">
        </form>
        <button onclick="addSetInputs(event)">세트 추가하기</button>
        <script>
            addSetInputs();
        </script>
    </div>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
