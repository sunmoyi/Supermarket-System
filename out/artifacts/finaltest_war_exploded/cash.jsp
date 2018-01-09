<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2017/12/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="Robots" content="index,follow" />
    <meta name="author" content="Luka Cvrk (www.cssmoban.com)" />
    <meta name="description" content="Description" />
    <meta name="keywords" content="key, words" />
    <title>Distinctive - web development company</title>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jQuery Contact Form Plugin: FFForm</title>
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <!--Framework-->
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <!--End Framework-->
    <script src="js/jquery.ffform.js" type="text/javascript"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/demo.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/screen.css" media="screen" />
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body class="flipInX animated">
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

    <section id="getintouch">
        <div class="container" style="border-bottom: 0; width: 70%">
            <h1>
                <span>收银</span>
            </h1>
        </div>
        <div class="container" style="width: 70%">
            <form class="contact" action="/chargeTwo" method="get" onsubmit="return validate()">
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="price">总价</label>
                    </div>
                    <div class="ctrl" style="text-align: center">
                        <label id="price" style="font-size: 30px;color: red;">${sessionScope.sumprice}</label>
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="shouru">实收</label>
                    </div>
                    <div class="ctrl">
                        <input type="text" id="shouru" name="shouru" data-required="true" data-validation="email"
                               data-msg="Invalid E-Mail" >
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="charge">找零</label>
                    </div>
                    <div class="ctrl" style="text-align: center">
                        <label id = "charge" style="font-size: 30px;color: red; text-align: center" ></label>
                    </div>
                </div>
                <div class="row  clearfix" style="text-align: center">
                    <div class="span10 offset2" style="">
                        <input type="submit" name="submit" id="submit" class="submit" value="Send Message" onclick="variation()">
                        ${sessionScope.error}
                    </div>
                </div>
            </form>
        </div>
    </section>
    <script type="text/javascript" charset="UTF-8">
        $("#shouru").blur(function () {
            var ling = $(this).val() - $("#price").html();
           $("#charge").html("￥" + ling);
        });
    </script>
</div>
</body>
</html>
