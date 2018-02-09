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
    for (var k = 0; k < level * 4; k++) {
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
    getExistUser();
}

function getExistUser() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/document",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log(JSON.stringify(data));
            if (data !== undefined) {
                document.getElementById("input-username");
                $("#input-username").val(data.userName);
                console.log(data.userName);
                var agree = document.getElementById("input-agree");
                agree.checked = data.termAgree;

                var sectors = data.sectorIds;
                console.log("data.sectorIds - " + data.sectorIds);
                console.log($("div.id_sector select"));
                $("div.id_sector select").val(sectors);
                console.log("complete fill form");
            }
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

$(document).ready(function () {

    $("#sector-form").submit(function (event) {
        event.preventDefault();
        createObjectForSubmit();
    });
});

function createObjectForSubmit() {
    var jsonObject = {};
    var agree = document.getElementById("input-agree");
    if (agree.checked) {
        jsonObject["termAgree"] = true;
    } else jsonObject["termAgree"] = false;
    jsonObject["userName"] = $("#input-username").val();

    var sectors = [];

    $("#sector-box").find("option:selected").each(function () {
        sectors.push($(this).val());
    });

    jsonObject["sectorIds"] = sectors;

    $("#btn-save").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/document",
        data: JSON.stringify(jsonObject),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            location.reload();
            getExistUser();
            console.log("SUCCESS : ", data);
            $("#bth-save").prop("disabled", false);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            $("#bth-save").prop("disabled", false);
        }
    });
}