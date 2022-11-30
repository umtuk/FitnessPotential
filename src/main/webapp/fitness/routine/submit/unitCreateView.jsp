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

    <form id="fitnessUnitCreate" class="container-sm" method="post" action="/fitness/routine/unit">
        <div class="row">
            제목: <input type="text" name="title" class="col" value="${param.title}" readonly><br>
            <input type="hidden" class="col" name="fitnessRoutineId" value="${sessionScope.fitnessRoutineId}" readonly>
            <input type="hidden" class="col" name="fitnessInfoId" value="${param.fitnessInfoId}" readonly>
            <input type="hidden" class="col" name="sets">
        </div>
        <br>
        <div class="sets">
            
        </div>
    
        <input type="submit" class="btn btn-outline-primary me-2" value="운동 추가히기">
    </form>
    <div class="container-sm">
        <button class="btn btn-outline-primary me-2" onclick="addSetInputs(event)">세트 추가하기</button>
    </div>
    <script>
        addSetInputs();
    </script>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>