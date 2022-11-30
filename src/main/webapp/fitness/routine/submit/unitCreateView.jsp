<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script src="/js/fitnessUnit.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <form id="fitnessUnitCreate" method="post" action="/fitness/routine/unit">
        제목: <input type="text" name="title" value="${param.title}" readonly><br>
        <input type="hidden" name="fitnessRoutineId" value="${sessionScope.fitnessRoutineId}" readonly>
        <input type="hidden" name="fitnessInfoId" value="${param.fitnessInfoId}" readonly>
        <input type="hidden" name="sets">
    
        <div class="sets">
            
        </div>
    
        <input type="submit" value="운동 추가히기">
    </form>
    <button onclick="addSetInputs(event)">세트 추가하기</button>
    <script>
        addSetInputs();
    </script>
</body>
</html>