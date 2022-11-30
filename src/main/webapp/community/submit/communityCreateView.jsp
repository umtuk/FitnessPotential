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
        <form action="/community" method="post">
            제목:
            <input type="text" class="w-100" name="title" id="title"> <br>

            내용:
            <textarea type="text" name="content" id="content" rows="10" cols="100" class="w-100">

            </textarea>
            <input class="btn btn-outline-primary me-2" type="submit" value="게시판 생성하기">
        </form>
        <span class="tags">
            <input type="text" name="tag" id="tag"> <input type="button" class="btn btn-outline-primary me-2" onclick="addTag(event)" value="태그 추가"> <br>
        </span>
        <a href="/community"><h1>back</h1></a>
    </div>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>