$(function () {
    $('#submit').click(function () {
        $('.form-group').removeClass('has-error');
        $.post("/validate", $('#mainForm').serialize())
            .done(function (data) {
                var info = $('#info');
                info.html(data["message"]);
                if (data["success"]) {
                    info.addClass("alert-success");
                } else {
                    $('#' + data["errorField"]).parent().addClass("has-error");
                    info.addClass("alert-danger");
                }
            });
    });
});