let set = 0;

function startFitness(event) {
    hideInfo();
    showBreakTimeTimer();
}

function nextSet(event) {
    showInfo();
    hideBreakTimeTimer();
    set++;
    let routineStartForm = document.querySelector("#routineStart");
    let setsDiv = routineStartForm.querySelector(".sets");
    let setList = setsDiv.querySelectorAll(".set");
    for (let i = 0; i < setList.length; i++) {
        if (set == i) {
            setList[i].style.display = "block";
        }
        else {
            setList[i].style.display = "none";
        }
    }
}

function breakStart(event) {
    let parent = event.target.parentNode;
    let clock = parent.querySelector(".clock");
    let id = setInterval(() => {
        let next = Number(clock.innerText) - 1
        if (next < 0) {
            clearInterval(id);
            return;
        }
        clock.innerText = next;
    }, 1000);
}

function initRoutineStart() {
    let routineStartForm = document.querySelector("#routineStart");
    let setsDiv = routineStartForm.querySelector(".sets");
    let setList = setsDiv.querySelectorAll(".set");
    for (let i = 1; i < setList.length; i++) {
        setList[i].style.display = "none";
    }

    hideBreakTimeTimer();

    setsDiv.querySelectorAll(".startFitness").forEach((button) => {
        button.addEventListener("click", event => {
            event.preventDefault();
            startFitness(event);
        });
    });

    setsDiv.querySelectorAll(".nextSet").forEach((button) => {
        button.addEventListener("click", event => {
            event.preventDefault();
            nextSet(event);
        });
    });

    setsDiv.querySelectorAll(".breakStart").forEach((button) => {
        button.addEventListener("click", event => {
            event.preventDefault();
            breakStart(event);
        });
    });
}

function hideInfo() {
    let routineStartForm = document.querySelector("#routineStart");
    let setsDiv = routineStartForm.querySelector(".sets");
    let infoDivList = setsDiv.querySelectorAll(".info");
    for (let i = 0; i < infoDivList.length; i++) {
        infoDivList[i].style.display = "none";
    }
}

function hideBreakTimeTimer() {
    let routineStartForm = document.querySelector("#routineStart");
    let setsDiv = routineStartForm.querySelector(".sets");
    let breakTimeTimerDivList = setsDiv.querySelectorAll(".breakTimeTimer");
    for (let i = 0; i < breakTimeTimerDivList.length; i++) {
        breakTimeTimerDivList[i].style.display = "none";
    }
}

function showInfo() {
    let routineStartForm = document.querySelector("#routineStart");
    let setsDiv = routineStartForm.querySelector(".sets");
    let infoDivList = setsDiv.querySelectorAll(".info");
    for (let i = 0; i < infoDivList.length; i++) {
        infoDivList[i].style.display = "block";
    }
}

function showBreakTimeTimer() {
    let routineStartForm = document.querySelector("#routineStart");
    let setsDiv = routineStartForm.querySelector(".sets");
    let breakTimeTimerDivList = setsDiv.querySelectorAll(".breakTimeTimer");
    for (let i = 0; i < breakTimeTimerDivList.length; i++) {
        breakTimeTimerDivList[i].style.display = "block";
    }
}