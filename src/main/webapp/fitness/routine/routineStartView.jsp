<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script src="/js/fitnessUnit.js"></script>
    <script src="/js/routineStart.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/fitness/routine/start?unitIndex=${unitIndex + 1}&fitnessRoutineId=${unit.fitnessRoutine.id}" method="post" id="routineStart">
            <h2>${unit.title}</h2>
            <div class="sets">
                <input type="hidden" name="title" value="${unit.title}">
                <input type="hidden" name="sets" value="${unit.sets}">
                <c:forEach var="i" varStatus="status" begin="0" end="${unit.sets - 1}">
                    <div class="set">
                        <div class="info">
                            반복 횟수: ${unit.reps.get(i)} <br>
                            중량: ${unit.weights.get(i)} <br><br>
                            <button class="startFitness btn btn-outline-primary me-2">세트 완료</button><br>
                        </div>
                        <c:set var="isLast" value="${i == unit.sets - 1}" scope="request"></c:set>
                        <input type="hidden" name="breakTimesPerSet[]" value="${unit.breakTimesPerSet.get(i)}">
                        <jsp:include page="/fitness/routine/util/breakTimeTimer.jsp"></jsp:include>
                    </div>
                </c:forEach>
            </div>
            <br><br>
        </form>
        <a href="/fitness/info"><h2>종료하기</h2></a>
        <a href="/fitness/routine/start?unitIndex=${unitIndex + 1}&fitnessRoutineId=${unit.fitnessRoutine.id}"><h2>건너뛰기</h2></a>
    </div>
    <script>
        initRoutineStart();
    </script>
</body>
</html>