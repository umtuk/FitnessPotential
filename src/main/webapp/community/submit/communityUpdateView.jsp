<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness Potential</title>
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
    <span class="tags">
        <input type="text" name="tag" id="tag"> <input type="button" onclick="addTag(event)" value="addTag"> <br>
    </span>
    <form action="/community/${community.id}" method="post">
        <input type="hidden" name="_method" value="put">
        title: <input type="text" name="title" id="title" value="${community.title}"> <br>
        content: <input type="text" name="content" id="content" value="${community.content}"> <br>
        <c:forEach var="tag" varStatus="status" items="${community.tags}">
            <span>
                <input type="text" name="tags[]" value="${tag}" />
                <input type="button" value="X" onclick="deleteTag(event)">
                <br>
            </span>
        </c:forEach>
        <input type="submit" value="submit">
    </form>
    <a href="/community/${community.id}"><h1>back</h1></a>
</body>
</html>