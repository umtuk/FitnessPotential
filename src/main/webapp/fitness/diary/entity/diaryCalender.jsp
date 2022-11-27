<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="get" action="/fitness/diary/search">
    <input type="number" name="year" required min="0" max="9999" value="${year}">-
    <input type="number" name="month" required min="1" max="12" value="${month}">-
    <input type="number" name="day" required min="1" max="31" value="${day}">
    <input type="submit" value="검색">
</form>