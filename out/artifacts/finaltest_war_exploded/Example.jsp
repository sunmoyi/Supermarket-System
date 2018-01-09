﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jQuery Contact Form Plugin: FFForm</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <!--Framework-->
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <!--End Framework-->
     <script src="js/jquery.ffform.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#form').ffform({ animation: 'fade', submitButton: '#submit', validationIndicator: '#validation', errorIndicator: '#error', successIndicator: '#success', 'fields': [{ 'id': 'name', required: true, requiredMsg: 'Name is required', type: 'alpha', validate: true, msg: 'Invalid Name' }, { 'id': 'email', required: true, requiredMsg: 'E-Mail is required', type: 'email', validate: true, msg: 'Invalid E-Mail Address' }, { 'id': 'phone', required: false, type: 'custom', validate: false, msg: 'Invalid Phone #' }, { 'id': 'message', required: false, type: 'text', validate: false, msg: ''}] });
        });
    </script>
</head>
<body class="flipInX animated">
    <section id="getintouch">
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>Login</span>
            </h1>
        </div>
        <div class="container">
            <form class="contact" action="#" method="post" id="form">
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="name">Name</label>
                    </div>
                    <div class="ctrl">
                        <input type="text" id="name" name="name" data-required="true" data-validation="text"
                            data-msg="Invalid Name" placeholder="Ex: John Donga">
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="email">
                            E-Mail</label>
                    </div>
                    <div class="ctrl">
                        <input type="text" id="email" name="email" data-required="true" data-validation="email"
                            data-msg="Invalid E-Mail" placeholder="Ex: youremail@domain.com">
                        <img src="yanzheng.jsp" alt=""/>
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="email">
                            Phone</label>
                    </div>
                    <div class="ctrl">
                        <input type="text" id="phone" name="phone" data-required="true" data-validation="custom"
                            data-msg="Invalid Phone #" placeholder="Ex: 111-258-444">
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="subject">
                            Subject</label>
                    </div>
                    <div class="ctrl">
                        <input type="text" name="subject" id="subject" placeholder="Ex: Quote for Project">
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="lbl">
                        <label for="message">
                            Message</label>
                    </div>
                    <div class="ctrl">
                        <textarea id="message" name="message" rows="6" cols="10"></textarea>
                    </div>
                </div>
                <div class="row  clearfix">
                    <div class="span10 offset2">
                        <input type="submit" name="submit" id="submit" class="submit" value="Send Message">
                    </div>
                </div>
            </form>
            <div id="success">
                Your E-Mail has been sent successfully!</div>
            <div id="error">
                Unable to send e-mail at the moment, please try later.</div>
            <div id="validation">
            </div>
        </div>
    </section>
</body>
</html>
