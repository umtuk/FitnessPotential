<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fitnessInfoUpdate</title>
</head>
<body>
<form action="/fitness/info/${fitnessInfo.id}" method="post">
    <input type="hidden" name="_method" value="put">
    title: <input type="text" name="title" id="title" value="${fitnessInfo.title}"> <br>
    summary: <input type="text" name="summary" id="summary" value="${fitnessInfo.summary}"><br>
    content: <input type="text" name="content" id="content" value="${fitnessInfo.content}"><br>
    <input type="submit" value="submit">
</form>
<a href="/fitness/info/${fitnessInfo.id}"><h1>back</h1></a>
</body>
</html>

