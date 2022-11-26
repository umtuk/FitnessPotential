<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<body>
    <jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/fitness/routine/${fitnessRoutine.id}" method="post">
            <input type="hidden" name="_method" value="put">
            title:
            <input type="text" class="w-100" name="title" id="title" value="${fitnessRoutine.title}"> <br>
            <br>
            <input class="btn btn-outline-primary me-2" type="submit" value="update">
        </form>
        <br>
        <a href="/fitness/routine/${fitnessRoutine.id}"><h1>back</h1></a>
    </div>
</body>
</html>