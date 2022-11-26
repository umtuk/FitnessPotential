<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-sm">
<div class="fitnessInfos">
    <c:forEach var="fitnessInfos" varStatus="status" items="${fitnessInfos.content}">
        <div class="list-group w-auto">
            <a href="/fitness/info/${fitnessInfos.id}">
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <img src="/storage/${fitnessInfos.thumbnail}" alt="" width="50" height="50">
                    title: ${fitnessInfos.title}<br>
                    summary: ${fitnessInfos.summary}<br>
                    <small class="opacity-50 text-nowrap">
                        createdAt: ${fitnessInfos.createdAt}
                    </small>
                </div>
            </a>
        </div>
        <hr>
    </c:forEach>
</div>
    <div class="container-sm">
        <a href="/fitness/info/create">create info</a>
    </div>
</div>
<form method="get" action="/fitness/info/search">

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

    <input type="submit" value="submit">
</form>
<nav aria-label="Standard pagination example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/fitness/info/search?page=0" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
            <c:forEach var="i" varStatus="status" begin="1" end="${fitnessInfos.totalPages}">
                <li class="page-item"><a class="page-link" href="/fitness/info/search?page=${i - 1}">${i}</a></li>
            </c:forEach>
        <li class="page-item">
            <a class="page-link" href="/fitness/info/search?page=${fitnessInfos.totalPages-1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</div>