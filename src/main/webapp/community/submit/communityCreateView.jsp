<!DOCTYPE html>
<html lang="en">
<head>
    <head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
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
    <head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
    <div class="container-sm">
        <form action="/community" method="post">
            title:
            <input type="text" class="w-100" name="title" id="title"> <br>

            content:
            <textarea type="text" name="content" id="content" rows="10" cols="100" class="w-100">

            </textarea>
            <input class="btn btn-outline-primary me-2" type="submit" value="submit">
        </form>
        <span class="tags">
            <input type="text" name="tag" id="tag"> <input type="button" class="btn btn-outline-primary me-2" onclick="addTag(event)" value="addTag"> <br>
        </span>
        <a href="/community"><h1>back</h1></a>
    </div>
</body>
</html>