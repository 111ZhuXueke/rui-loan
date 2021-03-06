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
    <div class="mui-content">
        <div class="mui-row">
            <div class="mui-col-sm-6 mui-col-xs-12">
                <button type="button" class="mui-btn mui-btn-primary run" data-commond="播放/暂停网易云音乐">运行网易云音乐</button>
            </div>
        </div>
    </div>
    <script>
        $(function(){
            $(".run").click(function(){
                $.post("${basePath}robot/openApplication",{"sendMsg":$(".run").attr("data-commond")},function(result){
                    var obj = eval('('+result+')');
                    mui.toast(obj.message,{ duration:'short', type:'div' })
                });
            });
        })
    </script>
</body>
</html>