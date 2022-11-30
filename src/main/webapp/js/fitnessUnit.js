function addSetInputs(event) {
    let fitnessUnitCreateForm = document.querySelector("#fitnessUnitCreate");
    let setsDiv = fitnessUnitCreateForm.querySelector(".sets");
    let setClass = document.createElement("div");

    setClass.className = "set";
    let repsInput = createNumberInput("reps[]");
    repsInput.min = "1";
    repsInput.required = true;
    let breakTimesPerSet = createNumberInput("breakTimesPerSet[]");
    breakTimesPerSet.min = "1";
    breakTimesPerSet.required = true;
    let weights = createNumberInput("weights[]");
    weights.min = "1";
    weights.required = true;
    let deleteButton = document.createElement("button");
    deleteButton.innerText = "삭제"
    deleteButton.className="btn btn-outline-primary me-2";
    deleteButton.addEventListener('click', event => {
        event.preventDefault();
        deleteSetInputs(event);
    });
    setClass.appendChild(document.createTextNode("반복 횟수"));
    setClass.appendChild(repsInput);
    setClass.appendChild(document.createElement('br'));
    setClass.appendChild(document.createElement('br'));

    setClass.appendChild(document.createTextNode("쉬는 시간(초)"));
    setClass.appendChild(breakTimesPerSet);
    setClass.appendChild(document.createElement('br'));
    setClass.appendChild(document.createElement('br'));

    setClass.appendChild(document.createTextNode("중량(kg)"));
    setClass.appendChild(weights);
    setClass.appendChild(document.createElement('br'));
    setClass.appendChild(document.createElement('br'));

    setClass.appendChild(deleteButton);

    setsDiv.appendChild(setClass);
    updateSetsInput();
}

function deleteSetInputs(event) {
    let deleted = event.target.parentNode;
    while (deleted.className != "set") {
        deleted = deleted.parentNode;
    }
    deleted.parentNode.removeChild(deleted);
    updateSetsInput();
}

function updateSetsInput() {
    let fitnessUnitCreateForm = document.querySelector("#fitnessUnitCreate");
    let setsDiv = fitnessUnitCreateForm.querySelector(".sets");
    let setsInput = fitnessUnitCreateForm.querySelector('input[name="sets"]');
    setsInput.value = setsDiv.querySelectorAll(".set").length;
}


function createNumberInput(name) {
    let input = document.createElement("input");
    input.type = "number";
    input.name = name;
    return input;
}