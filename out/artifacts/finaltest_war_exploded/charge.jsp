<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2018/1/4
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2018/1/2
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
        <li><a href="/Statistic">统计</a></li>
    </ul>
    <div class="line1"></div>
    
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <form method="get" action="/chargeOne" id="add">
                <div class="row">
                    <div class="col-lg-6">
                        <label for="customerId" style="font-size: 14px">用户ID</label>
                        <input type="text" name="customerId" id="customerId" class="form-control" >
                    </div>
                    <div class="col-lg-6">
                        <label for="employee" style="font-size: 14px">收银员ID</label>
                        <input type="text" name="employee" id="employee" class="form-control" >
                    </div>
                </div>
                <div id="testadd">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#1">
                                商品1
                            </a>
                        </h4>
                    </div>
                    <div id="1" class="panel-collapse collapse">
                        <div class="panel-body" style="font-size: 10px">
                            <div class="row">
                                <div class="col-lg-6">
                                    <label for="employeeid1">商品编号</label>
                                    <input type="text" name="employeeid1" id="employeeid1" class="form-control" value="0">
                                </div>
                                <div class="col-lg-6">
                                    <label for="password1">数量</label>
                                    <input type="text" name="password1" id="password1" class="form-control" value="0">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-left: 0px;margin-right: 0px">
                        <hr/>
                    </div>
                </div>
                <label style="font-size: 100px; color: red" id="labelmoney"></label>
                <div class="row" style="margin-left: 740px;margin-bottom: 10px">
                    <input type="submit" name="submit" id="submit" class="btn btn-primary" value="Send Message" onclick="">
                </div>
            </form>
            <button class="btn btn-primary" id="addtest" style="margin-left: 740px;margin-bottom: 10px">添加商品</button>
        </div>
    </div>
</div>
<script type="text/javascript" charset="UTF-8">
    var sum = 1;
    var str = "<div> \n" +
        "                    <div class=\"panel-heading\">\n" +
        "                        <h4 class=\"panel-title\">\n" +
        "                            <a data-toggle=\"collapse\" data-parent=\"#accordion\"\n" +
        "                               href=\"#1\">\n" +
        "                                商品1\n" +
        "                            </a>\n" +
        "                        </h4>\n" +
        "                    </div>\n" +
        "                    <div id=\"1\" class=\"panel-collapse collapse\">\n" +
        "                        <div class=\"panel-body\" >\n" +
        "                            <div class=\"row\">\n" +
        "                                <div class=\"col-lg-6\">\n" +
        "                                    <label for=\"employeeid1\">商品编号</label>\n" +
        "                                    <input type=\"text\" name=\"employeeid1\" id=\"employeeid1\" class=\"form-control\" value=\"0\">\n" +
        "                                </div>\n" +
        "                                <div class=\"col-lg-6\">\n" +
        "                                    <label for=\"password1\">数量</label>\n" +
        "                                    <input type=\"text\" name=\"password1\" id=\"password1\" class=\"form-control\" value=\"0\">\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"row\" style=\"margin-left: 0px;margin-right: 0px\">\n" +
        "                        <hr/>\n" +
        "                    </div>\n" +
        "                </div>";
    $("#addtest").click(function () {
        var num = sum + 1;
//        alert(num);
        var str2 = str.replace(/1/g, num);
//        alert(str2);
        sum = sum + 1;
        $("#testadd").append(str2);
    });
</script>
</body>
</html>
