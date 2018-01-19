<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
        <title>Robot</title>
        <link rel="icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
        <link href="${basePath}static/mui/css/mui.min.css" rel="stylesheet"/>
        <script src="${basePath}static/mui/js/mui.min.js"></script>
        <script src="${basePath}static/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" charset="utf-8">
            mui.init();
        </script>
    </head>
<body>
    <form class="mui-input-group" id="forms">
        <div class="mui-input-row">
            <label>用户名</label>
            <input type="text" id="name" class="mui-input-clear" placeholder="请输入用户名" value="11">
        </div>
        <div class="mui-input-row">
            <label>密码</label>
            <input type="password" id="pwd" class="mui-input-password" placeholder="请输入密码" value="123456">
        </div>
        <div class="mui-input-row msage" style="display: none;">
            <label class="back-msg"></label>
        </div>
        <div class="mui-button-row">
            <button type="button" class="mui-btn mui-btn-primary sub" >确认</button>
            <button type="button" class="mui-btn mui-btn-danger" >取消</button>
        </div>
    </form>

    <script>
        $(function(){
            $(".sub").click(function(){
                $.post("${basePath}robot/login",{"pwd":$("#pwd").val(),"name":$("#name").val()},function(result){
                    var obj = eval("("+result+")");
                    $(".msage").css("display","block");
                    var message = obj.message;
                    if(obj.ok != null){
                        $(".back-msg").css("color","green");
                        $(".back-msg").html(message);
                        setTimeout(function(){
                            window.location.href = "${basePath}robot/openApplication";
                        },1000);
                    }else{
                        $(".back-msg").html(message);
                        $(".back-msg").css("color","red");
                    }
                });
            });
        })
    </script>
</body>
</html>