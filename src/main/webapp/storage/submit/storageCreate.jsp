<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/storage" enctype="multipart/form-data" method="post">
    <input type="file" name="images">
    <input type="submit" value="submit" class="axios">
</form>