<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script src="/js/storage.js"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.0/axios.min.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div class="container-sm">
        <c:set var="targetSelector" value='.thumbnail' scope="request"></c:set>
        <jsp:include page="/storage/submit/storageCreate.jsp"></jsp:include>
        <form action="/fitness/info" method="post">
            <input type="hidden" name="thumbnail" class="thumbnail" required>
            title:
            <input type="text" name="title" id="title" required><br>
            summary:
            <input type="text" name="summary" id="summary" required><br>
            content:
            <textarea type="text" name="content" id="content" rows="10" cols="100" class="w-100" required>

            </textarea>
            팔 <input type="checkbox" name="majorCategory" value="팔"> <br>
            전완 굴곡근 <input type="checkbox" name="detailedCategory" value="전완 굴곡근"> <br>
            전완 신전근 <input type="checkbox" name="detailedCategory" value="전완 신전근"> <br>
            상완이두근 <input type="checkbox" name="detailedCategory" value="상완이두근"> <br>
            상완삼두근 <input type="checkbox" name="detailedCategory" value="상완삼두근"> <br>
            <br>
        
            어깨 <input type="checkbox" name="majorCategory" value="어깨"> <br>
            전면 삼각근 <input type="checkbox" name="detailedCategory" value="전면 삼각근"> <br>
            측면 삼각근 <input type="checkbox" name="detailedCategory" value="측면 삼각근"> <br>
            후면 삼각근 <input type="checkbox" name="detailedCategory" value="후면 삼각근"> <br>
            <br>
        
            등 <input type="checkbox" name="majorCategory" value="등"> <br>
            등 전체 <input type="checkbox" name="detailedCategory" value="등 전체"> <br>
            광배근 <input type="checkbox" name="detailedCategory" value="광배근"> <br>
            능형근 <input type="checkbox" name="detailedCategory" value="능형근"> <br>
            중간 승모근 <input type="checkbox" name="detailedCategory" value="중간 승모근"> <br>
            <br>
        
            하체 <input type="checkbox" name="majorCategory" value="하체"> <br>
            대퇴사두근 <input type="checkbox" name="detailedCategory" value="대퇴사두근"> <br>
            슬굴곡근 <input type="checkbox" name="detailedCategory" value="슬굴곡근"> <br>
            비복근 <input type="checkbox" name="detailedCategory" value="비복근"> <br>
            가자미근 <input type="checkbox" name="detailedCategory" value="가자미근"> <br>
            <br>
        
            복부 <input type="checkbox" name="majorCategory" value="복부"> <br>
            복직근 <input type="checkbox" name="detailedCategory" value="복직근"> <br>
            복사근 상부 <input type="checkbox" name="detailedCategory" value="복사근 상부"> <br>
            <br>
        
            가슴 <input type="checkbox" name="majorCategory" value="가슴"> <br>
            대흉근 상부 <input type="checkbox" name="detailedCategory" value="대흉근 상부"> <br>
            대흉근 중앙  <input type="checkbox" name="detailedCategory" value="대흉근 중앙"> <br>
            대흉근 하부 <input type="checkbox" name="detailedCategory" value="대흉근 하부"> <br>
            대흉근 바깥쪽 <input type="checkbox" name="detailedCategory" value="대흉근 바깥쪽"> <br>
            대흉근 안쪽 <input type="checkbox" name="detailedCategory" value="대흉근 안쪽"> <br>
            대흉근 상부 <input type="checkbox" name="detailedCategory" value="대흉근 상부"> <br>
            <br>
            <input type="submit" class="btn btn-outline-primary me-2" value="create info">
        </form>
        <a href="/fitness/info"><h1>back</h1></a>
    </div>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>