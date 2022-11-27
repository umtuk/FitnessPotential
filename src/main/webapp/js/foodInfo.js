let categoryMap = {}

function setCategoryMap(val) {
    categoryMap = JSON.parse(
        val.replace(/=/g, ":")
            .replace(/{/g, '{"')
            .replace(/:/g, '":')
            .replace(/\[/g, '["')
            .replace(/, /g, '", "')
            .replace(/\]/g, '"]')
            .replace(/\]", "/g, '], "')
    );
    let foodInfoCategory = document.querySelector("#foodInfoCategory");
    let majorCategorySelect = foodInfoCategory.querySelector('select[name="majorCategory"]');

    for (let majorCategory in categoryMap) {
        let option = document.createElement('option');
        option.value = majorCategory;
        option.innerText = majorCategory;
        majorCategorySelect.appendChild(option);
    }
}

function majorCategoryOnChange(event) {
    let majorCategory = event.target.value;
    setDetaiedCategory(majorCategory);
}

function setMajorCategory(majorCategory) {
    let parentNode = document.querySelector("#foodInfoCategory");
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
    let parentNode = document.querySelector("#foodInfoCategory");
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