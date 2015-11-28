/**
 * Created by jcchen on 15-11-28.
 */

function init_csrf_token() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        console.log(header + ": " + token);
        xhr.setRequestHeader(header, token);
    });
}

jQuery(function($) {
    init_csrf_token();

    $("#ajaxLogin").click(function() {
        $.post("/login", {
            username: "dba",
            password: "hello"
        }).done(function(data, textStatus, jqXhr) {
            console.log(data);
            console.log(textStatus);
            console.log(jqXhr);
        }).fail(function(err) {
            console.log(err);
        });
    });
});