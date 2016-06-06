$(function () {
    $('#calc').click(function () {
        var var1 = $('#var1').val();
        var var2 = $('#var2').val();
        var operation = $('#operation').val();

        $('#result').load("/basic?var1=" + var1 + "&var2=" + var2 + "&operation=" + operation);
    });

    $('#hello_text').click(function () {
        $('#say_hello').load("/basic");
    });

    $(function () {
        $('#answer_random').load("/basic?var1=random");

    });

    $('#closer-submit').click(function () {
        var m = $('#m').val();
        var n = $('#n').val();
        $('#closer-result').load("/basic?var1=closer&m=" + m + "&n=" + n);
    });

    $('#roots-submit').click(function () {
        var a = $('#a').val();
        var b = $('#b').val();
        var c = $('#c').val();
        $.get("/BasicServlet", {var1: "roots", a: a, b: b, c: c})
            .done(function (data) {
                $('#roots-result').html(data);
            });
    });
    $.get("/basic", {var1: "table"})
        .done(function (data) {
            console.log(data);
            drawTable("#random-table", data);

        });
    $.get("/basic", {var1: "tableMax"})
        .done(function (data) {
            console.log(data);
            drawTable("#random-table-max", data["table"]);
            drawList("#maximums", data["maximums"]);
        });


});


function drawTable(id, data) {
    for (var i = 0; i < data.length; i++) {
        drawRow(id, data[i]);
    }
}

function drawRow(id, rowData) {
    var row = $("<tr />");
    $(id).append(row);
    for (var j = 0; j < rowData.length; j++) {
        row.append($("<td>" + rowData[j] + "</td>"));
    }
}


function drawList(id, data) {
    var ul = $(id);

    $.each(data, function (i, obj) {
        $('<li>', {text: obj, class: "list-group-item"}).appendTo(ul);
    });
}