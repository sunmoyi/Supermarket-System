<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2018/1/2
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <c:forEach var="New" items="${sessionScope.News}" varStatus="varstatus">
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
                        collapse${num}
                    </c:set>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion"
                                   href="#${href}">
                                    ${New.newsTitle}
                                </a>
                            </h4>
                        </div>
                        <div id="${href}" class="panel-collapse collapse">
                            <div class="panel-body" style="font-size: 10px">
                                <form method="get" action="/NewsPageChange">
                                    <label for="NewsId"><h1>新闻序号</h1></label>
                                    <textarea id="NewsId" name="NewsId" class="form-control" rows="1" ${sessionScope.postNews ? "":"disabled"}>${New.newsId}</textarea>
                                    <label for="Title"><h1>新闻标题</h1></label>
                                    <textarea id="Title" name="Title" class="form-control" rows="1" ${sessionScope.postNews ? "":"disabled"}>${New.newsTitle}</textarea>
                                    <label for="News"><h1>新闻内容</h1></label>
                                    <textarea id="News" name="News" class="form-control" rows="3" ${sessionScope.postNews ? "":"disabled"}>${New.newsBody}</textarea>
                                    <c:if test="${sessionScope.postNews}">
                                        <hr>
                                        <input type="submit" class="btn btn-primary" style="margin-left:850px" value="提交"/>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <c:if test="${sessionScope.postNews}">
                <div class="panel-group" id="accordion2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion2"
                                   href="#collapseEight">
                                    添加新闻
                                </a>
                            </h4>
                        </div>
                        <div id="collapseEight" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <form method="get" action="/NewsPageAdd">
                                    <label for="newsid"><h1>新闻序号</h1></label>
                                    <textarea id="ID" name="ID"class="form-control" rows="1">${sessionScope.News.size() + 1}</textarea>
                                    <label for="newstitle"><h1>新闻标题</h1></label>
                                    <textarea id="newstitle" name="Title" class="form-control" rows="1" ></textarea>
                                    <label for="newsbody"><h1>新闻内容</h1></label>
                                    <textarea id="newsbody" name="Body" class="form-control" rows="3"></textarea>
                                    <hr>
                                    <input type="submit" class="btn btn-primary" style="margin-left:850px" value="提交"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
