<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
    <div id="fitnessInfo" class="d-flex gap-2 w-100 justify-content-between">
        <div class="title">
            <h1>title: ${fitnessInfo.title}</h1>
        </div>
        <div class="header">
            <small class="opacity-50 text-nowrap">
                id: ${fitnessInfo.id} <br>
                creatorId: ${fitnessInfo.creatorId} <br>
                createdAt: ${fitnessInfo.createdAt} <br>
            </small>
        </div>
    </div>
    <hr>
    <div class="content">
        thumbnail: <img src="/storage/${fitnessInfo.thumbnail}" alt="" srcset=""> <br>
        content: ${fitnessInfo.content}<br>
        summary: ${fitnessInfo.summary}<br>

        majorCategory: ${fitnessInfo.majorCategory} <br>
        detailedCategory: ${fitnessInfo.detailedCategory}
    </div>
</div>