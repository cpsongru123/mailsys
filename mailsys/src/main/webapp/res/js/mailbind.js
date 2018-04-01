function bind() {
    $.ajax({

        type: "POST",
        url: "/bind",
        data: $('#bindform').serialize(),// 你的formid
        async: true,
        error: function(request) {
            alert("Connection error");
        },
        success: function (data) {
            console.log(data);
            alert(data);
        }
    });
}

function unbind(id) {
    $.ajax({
        type: "POST",
        url: '/unbind',
        data:{id:id},
        error: function(request) {
            alert("Connection error");
        },
        success:function (result) {
            alert("result:"+result);
            console.log(result);
            window.location.reload(true);
        }
    });
}