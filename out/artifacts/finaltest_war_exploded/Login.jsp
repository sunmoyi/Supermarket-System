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
        <script type="text/javascript" src="jQuery-lib/jquery-3.2.1.js"></script>
        <script type="text/javascript" charset="UTF-8">
            var code ; //在全局 定义验证码
            var n = 50621;
            var e = 229;
            function createCode(){
                code = "";

                var codeLength = 5;//验证码的长度
                //所有候选组成验证码的字符，可以用中文
                var ans = 0;
                for(var i=0;i < codeLength;i++){
                    ans = ans * 10;
                    var charIndex = Math.floor(Math.random()*10);
                    ans += charIndex;
                    //alert(ans);
                }
                code = ans % 50000;
                return ans % 50000;
            }
            function validate (){
                var inputCode = document.getElementById("Verification").value.toLowerCase();
                //alert(inputCode);
                if(inputCode.length <= 0){
                    alert("请输入验证码！");
                    return false;
                }
                var ans = 1;
                for(var i = 1; i <= e; i++)
                    ans = ans * inputCode % n;
                //alert(ans);
                //alert(code);
                if(ans != code){
                    alert("验证码输入错误！");
                    show();//刷新验证码
                    return false;
                }else{
                    return true;
                }
            }
            function show(){
                //显示验证码
                document.getElementById("code").src="/yanzheng?code="+createCode();
            }
            window.onload = function() {
                //document.onload=show();
                show();//页面加载时加载验证码
                //这时无论在ie还是在firefox中，js没有加载完，页面的东西是不会被执行的；
            }
        </script>
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
                        <span>Login</span>
                    </h1>
                </div>
                <div class="container" style="width: 70%">
                    <form class="contact" action="/login" method="get" onsubmit="return validate()">
                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="EmployeeId">EmployeeId</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="EmployeeId" name="EmployeeId" data-required="true" data-validation="text"
                                       data-msg="Invalid Name" placeholder="Ex: 员工ID">
                            </div>
                        </div>
                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="Password">Password</label>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="Password" name="Password" data-required="true" data-validation="email"
                                       data-msg="Invalid E-Mail" placeholder="Ex: 1-10位数字">
                            </div>
                        </div>
                        <div class="row clearfix">
                            <div class="lbl">
                                <label for="Verification">Verification</label>
                                <img title="换一张试试" name="code" id="code" src="" onclick="show(); return false;"/>
                            </div>
                            <div class="ctrl">
                                <input type="text" id="Verification" name="Verification" data-required="true" data-validation="email"
                                       data-msg="Invalid E-Mail">
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
        </div>
    </body>
</html>
