<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/head.jsp"></jsp:include>
    <script>
        function addTag(event) {
            let text = document.querySelector('.tags input[name="tag"]').value;
            let input = document.createElement('input');
            input.type = "text";
            input.name = "tags[]";
            input.value = text;
            input.readOnly = true;
            let btn = document.createElement('input');
            btn.type = "button";
            btn.value = "X";
            btn.addEventListener("click", (e) => {
                deleteTag(e);
            })

            let span = document.createElement('span');
            span.appendChild(input);
            span.appendChild(btn);
            span.appendChild(document.createElement('br'));


            let form = document.querySelector('form');
            let submit = form.querySelector('input[type="submit"]');
            form.insertBefore(span, submit);
        }

        function deleteTag(event) {
            let btn = event.target;
            let span = btn.parentNode;
            span.remove();
        }
    </script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/community/${community.id}" method="post">
            <input type="hidden" name="_method" value="put">
            제목:
            <input type="text" class="w-100" name="title" id="title" value="${community.title}"> <br>
            내용:
            <textarea type="text" class="w-100" name="content" id="content" rows="10" cols="100">${community.content}</textarea>
            <span class="tags">
                <input type="text" name="tag" id="tag"> <input type="button" class="btn btn-outline-primary me-2" onclick="addTag(event)" value="태그 추가"> <br>
            </span>
            <c:forEach var="tag" varStatus="status" items="${community.tags}">
                <span>
                    <input type="text" name="tags[]" value="${tag}" />
                    <input type="button" class="btn btn-outline-primary me-2" value="X" onclick="deleteTag(event)">
                    <br>
                </span>
            </c:forEach>
            <input type="submit" class="btn btn-outline-primary me-2" value="게시판 수정하기">
        </form>
        <a href="/community/${community.id}"><h1>뒤로가기</h1></a>
    </div>
</body>
</html>