<!DOCTYPE html>
<html>
<jsp:include page="../../../head.jsp"></jsp:include>
<body>
    <jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/fitness/diary/${fitnessDiary.id}" method="post">
            <input type="hidden" name="_method" value="put">
            title:
            <input type="text" class="w-100" name="title" id="title" value="${fitnessDiary.title}"> <br><br>
            sets:
            <input type="text" name="sets" id="sets" value="${fitnessDiary.sets}"><br><br>
            reps:
            <input type="text" name="reps" id="reps" value="${fitnessDiary.reps}"><br><br>
            breakTimesPerSet:
            <input type="text" name="breakTimesPerSet" id="breakTimesPerSet" value="${fitnessDiary.breakTimesPerSet}"><br><br>
            year:
            <input type="text" name="year" id="year" value="${fitnessDiary.year}"><br><br>
            month:
            <input type="text" name="month" id="month" value="${fitnessDiary.month}"><br><br>
            day:
            <input type="text" name="day" id="day value="${fitnessDiary.day}""><br><br>
            <input type="submit" class="btn btn-outline-primary me-2" value="create diary">
        </form>
        <a href="/fitness/diary/${fitnessDiary.id}"><h1>back</h1></a>
    </div>
</body>
</html>
