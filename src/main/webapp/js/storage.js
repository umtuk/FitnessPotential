function storageSubmit(event, targetSelector) {
    let form = event.target.parentNode;
    console.log(form);
    let imagesInput = form.querySelector("input[name='images']");
    console.log(imagesInput);
    let formData = new FormData();
    formData.append("images", imagesInput.files[0]);
    axios.post("/storage", formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    }).then((res) => {
        console.log(res);
        let targetInput = document.querySelector(targetSelector);
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
    }).catch((err) => {
        console.log(err);
    });
}