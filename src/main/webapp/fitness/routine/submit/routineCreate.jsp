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
<form action="/fitness/routine" method="post">
    title: <input type="text" name="title" id="title"> <br>

    <input type="submit" value="submit">
</form>
<span class="unit">
        <input type="text" name="unit" id="unit"> <input type="button" onclick="addUnit(event)" value="addUnit"> <br>
    </span>
<a href="/fitness/routine"><h1>back</h1></a>
</body>
</html>