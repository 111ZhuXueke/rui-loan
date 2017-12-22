<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>学海无涯</title>
        <link rel="icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="${basePath}static/image/logo.ico" type="image/x-icon" />
        <link href="${basePath}static/css/index.css" rel="stylesheet">
        <link href="${basePath}static/css/public.css" rel="stylesheet">
    </head>
<body>

    <header></header>
    <main>
        <div class="lg">
            <div class="lg-img">
                <img src="${basePath}static/image/xuehai.jpg">
            </div>
            <div class="lg-input">
                <input type="text" id="xh" autocomplete="off" /><button class="btn-found">找找看</button>
            </div>
        </div>
    </main>
    <footer></footer>

    <script src="${basePath}static/js/index.js"></script>
    <script src="${basePath}static/js/public.js"></script>
</body>
</html>