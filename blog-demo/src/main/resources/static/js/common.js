$(document).ajaxSend(function (e, xhr, opt) {
    var token = localStorage.getItem("user_token");
    xhr.setRequestHeader("user_token_header", token);
});
function selectById(url) {
    $.ajax({
        type: "get",
        url: url,
        success: function (result) {
            if (result.code == "SUCCESS" && result.data != null) {
                var data = result.data;
                $(".left.card h3").val(data.userName);
                $(".left.card a").attr("href",data.githubUrl);
            } else {
                alert(result.errMsg);
            }
        },
        error: function (error) {
            if (error != null && error.status == 401) {
                location.href = "blog_login.html";
            }
        }


    });

}
function logout() {
    localStorage.removeItem("user_token");
    location.href = "blog_list.html";

}