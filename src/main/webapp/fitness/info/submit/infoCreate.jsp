<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container-sm">
    <form action="/fitness/info" method="post">
        title:
        <input type="text" name="title" id="title"><br>
        summary:
        <input type="text" name="summary" id="summary"><br>
        content:
        <textarea type="text" name="content" id="content" rows="10" cols="100" class="w-100">

        </textarea>
        <input type="submit" class="btn btn-outline-primary me-2" value="create info">
    </form>
    <a href="/fitness/info"><h1>back</h1></a>
</div>
</body>