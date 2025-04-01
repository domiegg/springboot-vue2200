<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0023)http://sso.corp.273.cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml" class="hb-loaded">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
object {
	outline: none;
}
</style>
<title>登录页面</title>
<script src="${path}/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<style type="text/css">
html, body {
	height: 100%;
	overflow: hidden;
}

body {
	margin: 0;
	font-size: 14px;
	background: -moz-linear-gradient(top, #173147, #8396a3 45%, #8396a3 70%);
	background: -webkit-gradient(linear, 0 0, 0 70%, from(#132f43),
		to(#8396a3));
	background-repeat: no-repeat;
}

.login {
	position: relative;
	margin: auto;
	background: url(${path}/static/dist/img/login_bg3.png)
		no-repeat;
	width: 590px;
	height: 590px;
}

.login .mlogo {
	height: 197px;
}

.login .info {
	position: absolute;
	left: 84px;
	width: 350px;
	height: 300px;
	padding: 38px 35px 0 35px;
}

.input_box {
	margin: 0 0 10px;
	color: #f6f6f6;
	position: relative;
}

.input1, .input2 {
	margin: 0;
	width: 332px;
	height: 20px;
	line-height: 20px;
	padding: 9px 0 9px 16px;
	border: 1px solid #ddd;
	color: #727272;
	font-size: 14px;
	outline: none;
}

.input2 {
	margin: 0 10px 0 0;
	width: 236px;
}

.icon-true, .icon-false {
	background: url(${path}/static/dist/img/i.png) no-repeat;
	display: inline-block;
	height: 21px;
	margin: 10px 0 0 6px;
	width: 21px;
	position: absolute;
}

.icon-false {
	background-position: 0 -24px;
}

.input_box img {
	vertical-align: middle;
	margin-top: -3px;
	margin-bottom: 1px;
	width: 84px;
	height: 40px;
	border: 1px solid #ddd;
	cursor: pointer;
}

.button1 {
	width: 350px;
	height: 40px;
	line-height: 40px;
	border: 0;
	margin: 5px 0;
	text-align: center;
	background: #3a7aa7;
	color: #fff;
	font-size: 18px;
	font-family: "Microsoft YaHei" ! important;
}

a {
	display: inline-block;
	color: #676767;
	text-decoration: none;
	line-height: 40px;
	float: right;
	cursor: pointer;
}

a:hover {
	text-decoration: underline;
}

p {
	position: fixed;
	width: 100%;
	bottom: 15px;
	text-align: center;
	color: #fff;
	margin: 0;
	font-size: 12px;
	font-family: Arial, "宋体";
}

.input_box i.app {
	background: url("${path}/static/dist/img/p.png") no-repeat
		scroll -230px 3px;
	display: inline-block;
	float: left;
	height: 17px;
	position: relative;
	top: 10px;
	width: 15px;
}

.input_box .phone {
	float: right;
}
</style>
</head>
<body huaban_collector_injected="true">
	<div class="login" style="top: 12%;">
		<div class="mlogo"></div>
		<form method="post" action="${path }/login">
			<div class="info" style="padding-top: 60px;">
				<div class="input_box">
					<input name="u" value="" type="text" class="input1" placeholder="用户名"><span class=""></span>
				</div>
				<div class="input_box">
					<input type="password" name="p" value="" class="input1" placeholder="密码">
				</div>
				<div class="input_box">
					<input type="submit" name="submit" class="button1" value="登录"> <!--   <div style="float:right; margin-right: 10px;">
            <i class="app"></i>
            <a class="phone" target="_blank" href="http://www.273.cn/static/showPhone.html">用手机上业管</a>
            </div> -->
					<div name="result" class="pull-left" style="margin-top: 10px; color: red;">${msg }</div>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(
				function() {
					var input_account = $("input[name=u]");
					var input_password = $("input[name=p]");
					var div_result = $("div[name=result]");
					var btn_submit = $("input[name=submit]");
					btn_submit.click(function() {
						var checkSubmit = true;

						div_result.html("");

						if ($.trim(input_account.val()) == "") {
							div_result.html("用戶名不能空");
							checkSubmit = false;
						} else if ($.trim(input_password.val()) == "") {
							div_result.html("密码不能为空");
							checkSubmit = false;
						} else if ($("input[name=valid]").length > 0
								&& $.trim($("input[name=valid]").val()) == "") {
							div_result.html("验证码不能空");
							checkSubmit = false;
						} else {

						}

						return checkSubmit;
					})
				})
	</script>
</body>
</html>