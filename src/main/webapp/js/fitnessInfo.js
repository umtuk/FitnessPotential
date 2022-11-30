
const categoryMap = {
    전체: [
        "전체"
    ],
    팔: [
        "전완 굴곡근", "전완 신전근", "상완이두근", "상완삼두근",
    ],
    어깨: [
        "전면 삼각근", "측면 삼각근", "후면 삼각근",
    ],
    등: [
        "등 전체", "광배근", "능형근", "중간 승모근",
    ],
    하체: [
        "대퇴사두근", "슬굴곡근", "비복근", "가자미근",
    ],
    복부: [
        "복직근", "복사근",
    ],
    가슴: [
        "대흉근 상부", "대흉근 중앙", "대흉근 하부", "대흉근 바깥쪽", "대흉근 안쪽",
    ],
}
function majorCategoryOnChange(event) {
    let majorCategory = event.target.value;
    setDetaiedCategory(majorCategory);
}

function setMajorCategory(majorCategory) {
    let parentNode = document.querySelector("#fitnessInfoCategory");
    let majorCategorySelect = parentNode.querySelector('select[name="majorCategory"]');
    for (let option of majorCategorySelect.childNodes) {
        if (option.value == majorCategory) {
            option.selected = true; break;
        }
    }
}

function setDetaiedCategory(majorCategory, defaultDetailedCategory) {
    if (!Boolean(majorCategory)) {
        majorCategory = "전체";
    }
    let parentNode = document.querySelector("#fitnessInfoCategory");
    let beforeDetailedCategorySelect = parentNode.querySelector('select[name="detailedCategory"]');
    let afterDetailedCategorySelect = document.createElement("select");
    afterDetailedCategorySelect.name = "detailedCategory";
    let detailedCategories = categoryMap[majorCategory];
    for (let detailedCategory of detailedCategories) {
        let option = document.createElement("option");
        option.value = detailedCategory;
        option.innerText = detailedCategory;
        if (Boolean(defaultDetailedCategory) && detailedCategory == defaultDetailedCategory) {
            option.selected = true;
        }
        afterDetailedCategorySelect.appendChild(option);
    }

    parentNode.replaceChild(afterDetailedCategorySelect, beforeDetailedCategorySelect);
}