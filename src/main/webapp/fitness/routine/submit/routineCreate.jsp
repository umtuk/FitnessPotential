<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../../head.jsp"></jsp:include>
    <script>
        function addUnit(event) {
            let text = document.querySelector('.units input[name="units"]').value;
            let input = document.createElement('input');
            input.type = "text";
            input.name = "units[]";
            input.value = text;
            input.readOnly = true;
            let btn = document.createElement('input');
            btn.type = "button";
            btn.value = "X";
            btn.addEventListener("click", (e) => {
                deleteUnit(e);
            })

            let span = document.createElement('span');
            span.appendChild(input);
            span.appendChild(btn);
            span.appendChild(document.createElement('br'));


            let form = document.querySelector('form');
            let submit = form.querySelector('input[type="submit"]');
            form.insertBefore(span, submit);
        }

        function deleteUnit(event) {
            let btn = event.target;
            let span = btn.parentNode;
            span.remove();
        }
    </script>
</head>
<body>
    <jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/fitness/routine" method="post">
            title:
            <input type="text" class="w-100" name="title" id="title"> <br>
            <br>
            <input type="submit" class="btn btn-outline-primary me-2" value="submit">
        </form><br>
        <span class="unit">
            <input type="text" name="unit" id="unit"> <input class="btn btn-outline-primary me-2" type="button" onclick="addUnit(event)" value="addUnit"> <br>
        </span><br>
        <a href="/fitness/routine"><h1>back</h1></a>
    </div>
</body>
</html>