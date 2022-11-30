<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="storage-create">
    <input type="file" name="images">
    <button onclick="storageSubmit(event, '${targetSelector}')">사진 등록하기</button>
    <button onclick="storageDelete(event, '${targetSelector}')">사진 삭제하기</button>
</div>