<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <div id="fitnessDiary" class="d-flex gap-2 w-100 justify-content-between">
        <div class="title">
            <h1>${fitnessDiary.title}</h1>
        </div>
        <small class="opacity-50 text-nowrap">
            ${fitnessDiary.year}-${fitnessDiary.month}-${fitnessDiary.day}
        </small>
    </div>
    <div class="content">
        세트수: ${fitnessDiary.sets} <br>
        반복횟수: ${fitnessDiary.reps} <br>
        중량(kg): ${fitnessDiary.weights} <br>
        휴식시간(초): ${fitnessDiary.breakTimesPerSet} <br>
    </div>
    <form action="/fitness/diary/${fitnessDiary.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="운동 일지 삭제하기"> <br>
    </form>
</div>