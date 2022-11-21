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

<div id="fitnessInfo">
    <h1>fitnessInfo</h1>
    <div class="title">
        title: ${fitnessInfo.title}
    </div>
    <div class="header">
        id: ${fitnessInfo.id} <br>
        creatorId: ${fitnessInfo.creatorId} <br>
        createdAt: ${fitnessInfo.createdAt} <br>
        updatedAt: ${fitnessInfo.updatedAt} <br>
        deletedAt: ${fitnessInfo.deletedAt} <br>
    </div>
    <div class="content">
        content: ${fitnessInfo.content}<br>
        summary: ${fitnessInfo.summary}<br>
    </div>
</div>