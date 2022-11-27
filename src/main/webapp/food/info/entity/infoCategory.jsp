<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="get" action="/food/info/search" id="foodInfoCategory">
    <input type="hidden" name="fitnessRoutineId" value="${fitnessRoutineId}" readonly>
    <select name="majorCategory" onchange="majorCategoryOnChange(event)">
    </select>
    <select name="detailedCategory"></select>
    <input type="submit" value="검색">
</form>
<script>
    setCategoryMap("${foodInfoCategory.categories}");
    setMajorCategory("${majorCategory}");
    setDetaiedCategory("${majorCategory}", "${detailedCategory}");
</script>