<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="breakTimeTimer">
    <div class="input container-sm">
        <h2>목표했던 반복 횟수만큼 진행하셨나요? 실제 반복 횟수를 적어주세요.</h2>
        반복 횟수: <input type="number" name="reps[]" value="${unit.reps.get(i)}"> <br>
        중량: <input type="number" name="weights[]" value="${unit.weights.get(i)}"> <br>
    </div>
    <h1 class="clock">${unit.breakTimesPerSet.get(i)}</h1>
    <button class="breakStart btn btn-outline-primary me-2">휴식 시작</button>
    <button class="nextSet btn btn-outline-primary me-2">다음 세트 시작</button>
</div>