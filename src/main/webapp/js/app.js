$(function () { //网页加载完成执行方法
    //使用$("#id")通过id获取页面元素，绑定表单提交事件
    $("#login_form").submit(function () {
        //自己ajax提交表单数据
        $.ajax({
            url:"../login",
            type:"post",
            //content-type: "application/json"//请求数据类型，不使用默认表单数据类型，如果是json要注明
            data:$("#login_form").serialize(),//序列化表单格式
            dataType:"json",//响应数据类型
            success:function (r) {
                if(r.success){//用户登录业务操作成功
                    //跳转到文章列表
                    window.location.href = "../jsp/articleList.jsp";
                }else {
                    alert("错误码：" + r.code + "\n错误信息" + r.message);
                }
            }
        })
        //禁用默认表单提交
        return false;
    })
})