<%--
  Created by IntelliJ IDEA.
  User: sunqilong
  Date: 2017/12/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>HTML5 Canvas折线图表和柱形图表DEMO演示</title>

    <script type="text/javascript" src="jQuery.js"></script>
    <script type="text/javascript" src="jqplot.js"></script>

</head>
<body>
    <div class="col-lg-3">
        <label for="employeesex">查看月份</label>
        <select id="employeesex" name="employeesex" class="form-control">
            <option value="1">1月</option>
            <option value="2">2月</option>
            <option value="3">3月</option>
            <option value="4">4月</option>
            <option value="5">5月</option>
            <option value="6">6月</option>
        </select>
    </div>
    <div class="line1"></div>
	<div id="chart1"></div>
    <div style="text-align:center;clear:both;">
        <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
        <script src="/follow.js" type="text/javascript"></script>
    </div>
	<div id="chart2"></div>

	<script type="text/javascript">
	var data1 = [[8,2,3,4,7,6,3,5,9]];
    var data2 = [[7,2,3,4,3,6,5,8,3]];
    var data3 = [[7,3,5,6,9,1,4,5,8]];
    var data4 = [[4,2,5,4,5,2,7,8,4]];
    var data5 = [[4,2,3,4,2,6,5,4,9]];
    var data6 = [[3,2,3,4,3,6,7,8,5]];
    var b = [];
    b[1] = data1;b[2] = data2;b[3] = data3;b[4] = data4;b[5] = data5;b[6] = data6;

	var data_max = 15; //Y轴最大刻度

	var y_label = ""; //Y轴标题
	var x_label = "种类"; //X轴标题
	var x = [1,2,3,4,5,6,7,8,9]; //定义X轴刻度值


    $("#employeesex").change(function () {
        var yue = $("#employeesex").val();
        $("#chart1").empty();
        $("#chart2").empty();
        var title = yue + "月不同种类商品销量情况"; //统计图标标题
        var line_title = [title]; //曲线名称
        j.jqplot.diagram.base("chart1", b[yue], line_title, title, x, x_label, y_label, data_max, 1);
        j.jqplot.diagram.base("chart2", b[yue], line_title, title, x, x_label, y_label, data_max, 2);
    });

    </script>
</body>
</html>

