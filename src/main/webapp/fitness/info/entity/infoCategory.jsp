<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="get" action="/fitness/info/search" id="fitnessInfoCategory">
    <input type="hidden" name="fitnessRoutineId" value="${fitnessRoutineId}" readonly>
    <select name="majorCategory" onchange="majorCategoryOnChange(event)">
        <option value="전체">전체</option>
        <option value="팔">팔</option>
        <option value="어깨">어깨</option>
        <option value="등">등</option>
        <option value="하체">하체</option>
        <option value="복부">복부</option>
        <option value="가슴">가슴</option>
    </select>
    <select name="detailedCategory"></select>
    <input type="submit" value="검색">
</form>
<script>
    setMajorCategory("${majorCategory}");
    setDetaiedCategory("${majorCategory}", "${detailedCategory}");
</script>