<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2017/12/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="Robots" content="index,follow" />
        <meta name="author" content="Luka Cvrk (www.cssmoban.com)" />
        <meta name="description" content="Description" />
        <meta name="keywords" content="key, words" />
        <title>Distinctive - web development company</title>
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/screen.css" media="screen" />
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="content1">
            <div id="logo1">
                <h1><a href="/Login.jsp">超市管理系统</a></h1>
            </div>
            <ul id="menu1">
                <li class="current1"><a href="/index">主页</a></li>
                <li><a href="/Employee">员工名:${sessionScope.EmployeeId}</a></li>
                <li><a href="/NewsPage">公告</a></li>
                <li><a href="/GoodsPage">库存</a></li>
                <li><a href="/ProviderInfo">供应商</a></li>
                <li><a href="/EmployeeInfo">员工信息</a></li>
                <li><a href="/chargeInfo">收银</a></li>
                <li><a href="#">统计</a></li>
            </ul>
            <div class="line1"></div>
            <div class="panel-group" id="accordion">
                <jsp:include page="biaoge.jsp" />
            </div>
    </body>
</html>