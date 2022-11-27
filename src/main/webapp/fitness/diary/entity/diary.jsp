<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-sm">
    <div id="fitnessDiary" class="d-flex gap-2 w-100 justify-content-between">
        <div class="title">
            <h1>title: ${fitnessDiary.title}</h1>
        </div>
        <small class="opacity-50 text-nowrap">
            creatorId: ${fitnessDiary.creatorId} <br>
            fitnessInfoId: ${fitnessDiary.fitnessInfoId} <br>
            createdAt: ${fitnessDiary.createdAt} <br>
        </small>
    </div>
    <div class="content">
        sets: ${fitnessDiary.sets}<br>
        reps: ${fitnessDiary.reps}<br>
        breakTimesPerSet: ${fitnessDiary.breakTimesPerSet}<br>
        year: ${fitnessDiary.year}<br>
        month: ${fitnessDiary.month}<br>
        day: ${fitnessDiary.day}<br>
    </div>
    <form action="/fitness/diary/${fitnessDiary.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input class="btn btn-outline-primary me-2" type="submit" value="delete"> <br>
    </form>
</div>