<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-11-19
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="fitnessDiary">
    <h1>fitnessDiary</h1>
    <div class="title">
        title: ${fitnessDiary.title}
    </div>
    <div class="header">
        id: ${fitnessDiary.id} <br>
        creatorId: ${fitnessDiary.creatorId} <br>
        fitnessInfoId: ${fitnessDiary.fitnessInfoId} <br>
        createdAt: ${fitnessDiary.createdAt} <br>
        updatedAt: ${fitnessDiary.updatedAt} <br>
        deletedAt: ${fitnessDiary.deletedAt} <br>
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
        <input type="submit" value="delete"> <br>
    </form>
</div>