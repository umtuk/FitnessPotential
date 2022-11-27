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
    <form action="" method="post">
        <h2>${unit.title}</h2>
        <c:forEach var="i" varStatus="status" begin="0" end="${unit.sets - 1}">
            <div class="set">
                <div class="info">
                    반복 횟수: ${unit.reps.get(i)} <br>
                    중량: ${unit.weights.get(i)} <br>
                    <button class="">운동 시작</button>
                </div>
                <input type="hidden" name="breakTimesPerSet[]" value="${unit.breakTimesPerSet.get(i)}">
                <jsp:include page="/fitness/routine/util/breakTimeTimer.jsp"></jsp:include>
            </div>
        </c:forEach>
        <input type="submit" value="다음 운동 진행하기">
    </form>
    <a href="/fitness/info"><h2>종료하기</h2></a>
    <a href="/fitness/routine/start?unitIndex=${unitIndex + 1}&fitnessRoutineId=${unit.fitnessRoutine.id}"><h2>건너뛰기</h2></a>
</body>
</html>