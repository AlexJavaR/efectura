$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/sectors",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            addOption(data, 0);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
});

function addOption(json, level) {
    var indent = "";
    for (var k = 0; k < level*4; k++) {
        indent += "&nbsp;";
    }
    var selectBox = document.getElementById("sector-box");
    for (var i = 0; i < json.length; i++) {
        var option = document.createElement('option');
        option.value = json[i].id;
        option.innerHTML = indent + json[i].name;
        selectBox.appendChild(option);
        if (json[i].children.length !== 0) {
            var child = json[i].children;
            addOption(child, ++level);
            level--;
        }
    }
}

$(document).ready(function () {

    $("#sector-form").submit(function (event) {

    });
});