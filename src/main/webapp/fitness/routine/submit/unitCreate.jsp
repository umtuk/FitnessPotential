<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/fitness/routine/unit" method="post">
    <input type="hidden" name="fitnessRoutineId" value="${fitnessRoutine.id}" readonly>
    <input type="hidden" name="fitnessInfoId" value="1" readonly>
    title : <input type="text" name="title"><br>
    sets : <input type="text" name="sets"><br>
    reps : <input type="text" name="reps"><br>
    breakTimesPerSet : <input type="text" name="breakTimesPerSet"><br>
    <input type="submit" value="addUnit">
</form>