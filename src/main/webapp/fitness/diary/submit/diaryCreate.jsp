<!DOCTYPE html>
<html lang="en">
<body>
    <jsp:include page="../../../header.jsp"></jsp:include>
    <div class="container-sm">
        <form action="/fitness/diary" method="post">
            title:
            <input type="text" class="w-100" name="title" id="title"><br><br>
            fitnessInfoId:
            <input type="text" name="fitnessInfoId" id="fitnessInfoId"><br><br>
            sets:
            <input type="text" name="sets" id="sets"><br><br>
            reps:
            <input type="text" name="reps" id="reps"><br><br>
            breakTimesPerSet:
            <input type="text" name="breakTimesPerSet" id="breakTimesPerSet"><br><br>
            year:
            <input type="text" name="year" id="year"><br><br>
            month:
            <input type="text" name="month" id="month"><br><br>
            day:
            <input type="text" name="day" id="day"><br><br>
            <input type="submit" class="btn btn-outline-primary me-2" value="create diary">
        </form>
        <a href="/fitness/diary"><h1>back</h1></a>
    </div>
</body>
