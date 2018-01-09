<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2018/1/5
  Time: 10:37
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
        <c:forEach var="provider" items="${sessionScope.providerinfo}" varStatus="varstatus">
            <c:set var="num" scope="page">
                <c:choose>
                    <c:when test="${varstatus.count == 1}">One</c:when>
                    <c:when test="${varstatus.count == 2}">Two</c:when>
                    <c:when test="${varstatus.count == 3}">Three</c:when>
                    <c:when test="${varstatus.count == 4}">Four</c:when>
                    <c:when test="${varstatus.count == 5}">Five</c:when>
                    <c:when test="${varstatus.count == 6}">Six</c:when>
                    <c:when test="${varstatus.count == 7}">Seven</c:when>
                </c:choose>
            </c:set>
            <c:set var="href" scope="page">
                collapse${varstatus.count}
            </c:set>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#${href}">
                                ${provider.providerId}:${provider.providerName}
                        </a>
                    </h4>
                </div>
                <div id="${href}" class="panel-collapse collapse">
                    <div class="panel-body" style="font-size: 10px">
                        <form method="get" action="/ProviderInfoChange">
                            <div class="row">
                                <div class="col-lg-4">
                                    <label for="providerId">供应商ID</label>
                                    <input type="text" name="providerId" id="providerId" class="form-control" value="${provider.providerId}" disabled>
                                </div>
                                <div class="col-lg-4">
                                    <label for="providerName">供应商名字</label>
                                    <input type="text" name="providerName" id="providerName" class="form-control" value="${provider.providerName}">
                                </div>
                                <div class="col-lg-4">
                                    <label for="providerPosition">供应商地址</label>
                                    <input type="text" name="providerPosition" id="providerPosition" class="form-control" value="${provider.providerLocation}">
                                </div>
                                <div class="col-lg-4">
                                    <label for="providerphone">供应商电话</label>
                                    <input type="text" name="providerphone" id="providerphone" class="form-control" value="${provider.providerPhone}">
                                </div>
                            </div>
                            <div class="row">
                                <hr/>
                            </div>
                            <div class="row" style="margin-left: 790px;">
                                <input type="submit" name="submit" id="submit" class="btn btn-primary" value="Send Message" onclick="">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="panel-group" id="accordion2">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseEight">
                        添加供应商
                    </a>
                </h4>
            </div>
            <div id="collapseEight" class="panel-collapse collapse">
                <div class="panel-body" style="font-size: 10px">
                    <form method="get" action="/ProviderInfoAdd">
                        <div class="row">
                            <div class="col-lg-4">
                                <label for="providerId">供应商ID</label>
                                <input type="text" name="providerId" id="providerId" class="form-control" value="${sessionScope.providerinfo.size() + 1}">
                            </div>
                            <div class="col-lg-4">
                                <label for="providerName">供应商名字</label>
                                <input type="text" name="providerName" id="providerName" class="form-control" >
                            </div>
                            <div class="col-lg-4">
                                <label for="providerPosition">供应商地址</label>
                                <input type="text" name="providerPosition" id="providerPosition" class="form-control" >
                            </div>
                            <div class="col-lg-4">
                                <label for="providerPhone">供应商电话</label>
                                <input type="text" name="providerPhone" id="providerPhone" class="form-control" >
                            </div>
                        </div>
                        <div class="row">
                            <hr/>
                        </div>
                        <div class="row" style="margin-left: 790px;">
                            <input type="submit" name="submit" id="submit" class="btn btn-primary" value="Send Message" onclick="">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>