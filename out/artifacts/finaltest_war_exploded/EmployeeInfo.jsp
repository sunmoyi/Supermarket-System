
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
            <c:forEach var="employee" items="${sessionScope.EmployeeInfo}" varStatus="varstatus">
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
                                    ${employee.employeeId}:${employee.employeeName}
                            </a>
                        </h4>
                    </div>
                    <div id="${href}" class="panel-collapse collapse">
                        <div class="panel-body" style="font-size: 10px">
                            <form method="get" action="/EmployeeInfoChange">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <label for="employeeid">用户ID</label>
                                        <input type="text" name="employeeid" id="employeeid" class="form-control" value="${employee.employeeId}">
                                    </div>
                                    <div class="col-lg-4">
                                        <label for="password">密码</label>
                                        <input type="text" name="password" id="password" class="form-control" value="${employee.password}">
                                    </div>
                                    <div class="col-lg-4">
                                        <label for="lastLogin">最终登录时间</label>
                                        <input type="text" name="lastLogin" id="lastLogin" class="form-control" value="${employee.lastLogin}">
                                    </div>
                                </div>
                                <div class="row">
                                    <hr/>
                                </div>
                                <div class="row">
                                    <div class="col-lg-3">
                                        <label for="employeename">员工姓名</label>
                                        <input type="text" name="employeename" id="employeename" class="form-control" value="${employee.employeeName}">
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="employeesex">员工性别</label>
                                        <select id="employeesex" name="employeesex" class="form-control">
                                            <option value="男" ${sessionScope.employee.employeeSex == "男"? "selected":" "}>男</option>
                                            <option value="女" ${sessionScope.employee.employeeSex == "女"? "selected":" "}>女</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="employeephone">员工联系电话</label>
                                        <input type="text" name="employeephone" id="employeephone" class="form-control" value="${employee.employeePhone}">
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="employeeposition">员工地址</label>
                                        <input type="text" name="employeeposition" id="employeeposition" class="form-control" value="${employee.employeePositior}">
                                    </div>
                                </div>
                                <div class="row">
                                    <hr/>
                                </div>
                                <div class="row">
                                    <div class="col-lg-3">
                                        <label for="showGoods">查询商品</label>
                                        <input type="checkbox" name="showGoods" id="showGoods" class="form-control" ${employee.showGoods? "checked": ""}>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="updateGoodsNum">修改商品数目</label>
                                        <input type="checkbox" name="updateGoodsNum" id="updateGoodsNum" class="form-control" ${employee.updateGoodsNum? "checked": ""}>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="admin">管理员权限</label>
                                        <input type="checkbox" name="admin" id="admin" class="form-control" ${employee.admin? "checked": ""}>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="updateGoods">修改商品</label>
                                        <input type="checkbox" name="updateGoods" id="updateGoods" class="form-control" ${employee.updateGoods? "checked": ""}>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="postNews">添加公告</label>
                                        <input type="checkbox" name="postNews" id="postNews" class="form-control" ${employee.postNews? "checked": ""}>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="charge">收银</label>
                                        <input type="checkbox" name="charge" id="charge" class="form-control" ${employee.charge? "checked": ""}>
                                    </div>
                                    <div class="col-lg-3">
                                        <label for="chargePrice">修改商品价格</label>
                                        <input type="checkbox" name="chargePrice" id="chargePrice" class="form-control" ${employee.chargePrice? "checked": ""}>
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
                            添加新员工
                        </a>
                    </h4>
                </div>
                <div id="collapseEight" class="panel-collapse collapse">
                    <div class="panel-body" style="font-size: 10px">
                        <form method="get" action="/EmployeeInfoAdd">
                            <div class="row">
                                <div class="col-lg-4">
                                    <label for="employeeid">用户ID</label>
                                    <input type="text" name="employeeid" id="employeeid" class="form-control" value="${sessionScope.EmployeeInfo.size() + 1}">
                                </div>
                                <div class="col-lg-4">
                                    <label for="password">密码</label>
                                    <input type="text" name="password" id="password" class="form-control" value="${employee.password}">
                                </div>
                                <div class="col-lg-4">
                                    <label for="lastLogin">最终登录时间</label>
                                    <input type="text" name="lastLogin" id="lastLogin" class="form-control" value="${employee.lastLogin}">
                                </div>
                            </div>
                            <div class="row">
                                <hr/>
                            </div>
                            <div class="row">
                                <div class="col-lg-3">
                                    <label for="employeename">员工姓名</label>
                                    <input type="text" name="employeename" id="employeename" class="form-control" value="${employee.employeeName}">
                                </div>
                                <div class="col-lg-3">
                                    <label for="employeesex">员工性别</label>
                                    <select id="employeesex" name="employeesex" class="form-control">
                                        <option value="男" ${sessionScope.employee.employeeSex == "男"? "selected":" "}>男</option>
                                        <option value="女" ${sessionScope.employee.employeeSex == "女"? "selected":" "}>女</option>
                                    </select>
                                </div>
                                <div class="col-lg-3">
                                    <label for="employeephone">员工联系电话</label>
                                    <input type="text" name="employeephone" id="employeephone" class="form-control" value="${employee.employeePhone}">
                                </div>
                                <div class="col-lg-3">
                                    <label for="employeeposition">员工地址</label>
                                    <input type="text" name="employeeposition" id="employeeposition" class="form-control" value="${employee.employeePositior}">
                                </div>
                            </div>
                            <div class="row">
                                <hr/>
                            </div>
                            <div class="row">
                                <div class="col-lg-3">
                                    <label for="showGoods">查询商品</label>
                                    <input type="checkbox" name="showGoods" id="showGoods" class="form-control" ${employee.showGoods? "checked": ""}>
                                </div>
                                <div class="col-lg-3">
                                    <label for="updateGoodsNum">修改商品数目</label>
                                    <input type="checkbox" name="updateGoodsNum" id="updateGoodsNum" class="form-control" ${employee.updateGoodsNum? "checked": ""}>
                                </div>
                                <div class="col-lg-3">
                                    <label for="admin">管理员权限</label>
                                    <input type="checkbox" name="admin" id="admin" class="form-control" ${employee.admin? "checked": ""}>
                                </div>
                                <div class="col-lg-3">
                                    <label for="updateGoods">修改商品</label>
                                    <input type="checkbox" name="updateGoods" id="updateGoods" class="form-control" ${employee.updateGoods? "checked": ""}>
                                </div>
                                <div class="col-lg-3">
                                    <label for="postNews">添加公告</label>
                                    <input type="checkbox" name="postNews" id="postNews" class="form-control" ${employee.postNews? "checked": ""}>
                                </div>
                                <div class="col-lg-3">
                                    <label for="charge">收银</label>
                                    <input type="checkbox" name="charge" id="charge" class="form-control" ${employee.charge? "checked": ""}>
                                </div>
                                <div class="col-lg-3">
                                    <label for="chargePrice">修改商品价格</label>
                                    <input type="checkbox" name="chargePrice" id="chargePrice" class="form-control" ${employee.chargePrice? "checked": ""}>
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
