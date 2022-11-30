function storageSubmit(event, targetSelector) {
    let form = event.target.parentNode;
    let imagesInput = form.querySelector("input[name='images']");
    let formData = new FormData();
    formData.append("images", imagesInput.files[0]);
    axios.post("/storage", formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    }).then((res) => {
        putImg(targetSelector, res)
    }).catch((err) => {
        console.log(err);
    });
}
function storageDelete(event, targetSelector){
    let form = event.target.parentNode;
    let targetInput = document.querySelector(targetSelector);
    form.removeChild(form.lastChild);
    targetInput.value = null;
}

function putImg(targetSelector, res) {
    console.log(targetSelector);
    console.log(res);
    console.log(res.data);
    let form = document.querySelector(".storage-create");
    console.log(form);
    let targetInput = document.querySelector(targetSelector);
    console.log(targetInput);
    targetInput.value = res.data;
    let img = document.createElement("img");
    img.src = "/storage/" + res.data;
    let prev = form.querySelector("img");
    if (Boolean(prev)) {
        form.replaceNode(img, prev);
    }
    else {
        form.appendChild(img);
    }
}