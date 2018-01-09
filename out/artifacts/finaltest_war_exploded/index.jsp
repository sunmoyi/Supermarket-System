<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2017/12/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
            <li><a href="/Statistic">统计</a></li>
		</ul>
		<div class="line1"></div>
		<%--<div id="pitch1">--%>
        <div id="myCarousel" class="carousel slide" style=" margin-bottom: 10px">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators" >
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img style="width:100%;"  src="/images/index1.jpg" alt="First slide">
                </div>
                <div class="item">
                    <img style="width:100%;" src="/images/index2.jpg" alt="Second slide">
                </div>
                <div class="item">
                    <img style="width:100%;" src="/images/index3.jpg" alt="Third slide">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;</a>
        </div>
        <%--</div>--%>
        <hr>
		<div class="third1">
			<h3> <%= session.getAttribute("title1")%> </h3>
			<p> <%= session.getAttribute("body1")%> </p>
		</div>
		<div class="third1">
			<h3> <%= session.getAttribute("title2")%> </h3>
			<p> <%= session.getAttribute("body2")%> </p>
		</div>
		<div class="third1 last1">
			<h3> <%= session.getAttribute("title3")%> </h3>
			<p> <%= session.getAttribute("body3")%> </p>
		</div>
		<div class="line1"></div>
		<div class="left1">
			<h4>Join the Movement</h4>
			<p><em>Laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</em></p>
		</div>
		<div class="right1">
			<h3>12 / 2009</h3>
			<p>Duis rutrum dapibus diam. Sed turpis sem, suscipit et, ullamcorper vel, aliquam in, tellus. Phasellus interdum. Sed pede. Fusce semper tellus quis sapien.</p>
			<br />
			<h3>12 / 2009</h3>
			<p>Duis rutrum dapibus diam. Sed turpis sem, suscipit et, ullamcorper vel, aliquam in, tellus. Phasellus interdum. Sed pede. Fusce semper tellus quis sapien.</p>
		</div>
		<div id="footer1">
			<p style="text-align: center">&copy; Copyright 2009 Distinctive &minus; Design: Luka Cvrk, <a href="http://www.cssmoban.com" title="Free CSS Templates">cssMoban.com</a></p>
		</div>	
	</div>
</body>
</html>