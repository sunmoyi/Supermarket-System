<%@ page import="JavaBean.Employee" %><%--
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
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/demo.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/screen.css" media="screen" />
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
            <div>
                <div class="container" style="width: 65%">
                    <form class="contact" action="/EmployeeChange" method="get" onsubmit="return validate()">
                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="EmployeeId">EmployeeId</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="EmployeeId" name="EmployeeId" data-required="true"
                                       placeholder="${sessionScope.account.employeeId}"disabled>
                            </div>
                        </div>

                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="Password">Password</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="Password" name="Password" data-required="true"
                                       value="${sessionScope.account.password}" >
                            </div>
                        </div>

                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="LastLogin">LastLogin</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="LastLogin" name="LastLogin" data-required="true"
                                       placeholder="${sessionScope.account.lastLogin}" disabled>
                            </div>
                        </div>

                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="EmployeeSex">EmployeeSex</label>
                            </div>
                            <div class="ctrl">
                                <select id="EmployeeSex" name="EmployeeSex" class="form-control">
                                    <option value="男" ${sessionScope.employee.employeeSex == "男"? "selected":" "}>男</option>
                                    <option value="女" ${sessionScope.employee.employeeSex == "女"? "selected":" "}>女</option>
                                </select>
                            </div>
                        </div>

                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="EmployeePosition">EmployeePosition</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="EmployeePosition" name="EmployeePosition"
                                    value="${sessionScope.employee.employeePosition}">
                            </div>
                        </div>

                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="EmployeePhone">EmployeePhone</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="EmployeePhone" name="EmployeePhone"
                                    value="${sessionScope.employee.employeePhone}">
                            </div>
                        </div>

                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="EmployeeName">EmployeeName</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="EmployeeName" name="EmployeeName"
                                    value="${sessionScope.employee.employeeName}">
                            </div>
                        </div>

                        <div class="row  clearfix" style="text-align: center">
                            <div class="span10 offset2" style="">
                                <input type="submit" name="submit" id="submit" class="submit" value="Send Message" onclick="">
                                <input type="reset" name="reset" id="reset" class="submit"    value="  返     回  " onclick="javascrtpt:window.location.href='/index.jsp'">
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>