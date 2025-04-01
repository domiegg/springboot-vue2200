<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="./common/static.jsp"></jsp:include>
<body>
	<!--======================================工具栏=======================================-->
	<jsp:include page="./common/header.jsp"></jsp:include>


<!--======================================导航区=======================================-->
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
              </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </div><!-- /.container-fluid -->
</nav>


<div class="login-bg">
    <!---==========================================登录=================================-->
    <div class="container">
        <div class="login clearfix">
            <div class="leftBar col-md-6 col-sm-6">
                <img src="${path}/static/pre/images/login_show1.jpg" alt="登录">
            </div>
            <div class="regBox col-md-6 col-sm-6 col-xs-12">
                <div class="row">
                    <ul class="reg_title">
                        <li class="col-md-6 col-sm-6 col-xs-6 on">
                            <a href="javascript: void (0)">登录</a>
                        </li>
                        <li class="col-md-6 col-sm-6 col-xs-6">
                            <a href="javascript: void (0)">新用户注册</a>
                        </li>
                    </ul>
                </div>
                <form class="reg_list visible" action="${path}/index/login" method="post">
                    <ul>
                        <li class="clearfix">
                            <label>登录名</label>
                            <input type="text" name="username">
                            <span>请输入您注册的登录名</span>
                        </li>
                        <li class="clearfix">
                            <label>密码</label>
                            <input type="password" name="password">
                            <span><a href="javascript: void (0)">忘了密码？</a></span>
                        </li>
                        <li class="agree">
                            <input class="login-bg" type="submit" name="submit">
                        </li>
                    </ul>
                    <div class="more-way">

                    </div>
                </form>
                <form class="reg_list" action="${path}/index/reg" method="post">
                    <ul>
                        <li class="clearfix">
                            <label for="firstName">昵称</label>
                            <input type="text" id="firstName" name="nickname">
                            <span>请输入你的昵称</span>
                        </li>
                        <li class="clearfix">
                            <label for="firstName">登录名</label>
                            <input type="text" id="firstName" name="username">
                            <span>请输入你的账号</span>
                        </li>
                        <li class="clearfix">
                            <label for="password1">密码</label>
                            <input type="password" id="password1" name="password">
                            <span>6-16位数字和字母组成,区分大小写</span>
                        </li>
                        <li class="clearfix">
                            <label for="password2">确认密码</label>
                            <input type="password" id="password2" name="repassword">
                            <span>请重复输入上面的密码</span>
                        </li>
                          <li class="clearfix">
                            <span>${msg}</span>
                        </li>
                        <li class="agree clearfix">
                            <input type="submit" name="submit">
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    <!---==========================================注册=================================-->

    <!--===========================================售后服务=============================-->

    <section class="sale-nav">

        <div class="main-nav clearfix">
            <div class="container">
            </div>
        </div>
        <div class="small-nav clearfix">
            <div class="container">
                <div class="small-nav-1 clearfix">
                    <div class="small-nav-top col-md-9 col-sm-9">
                    </div>
                    <div class="col-md-3 col-sm-3 service"><img src="${path}/static/pre/images/fot_tel.png" alt="服务热线"></div>
                </div>
            </div>
        </div>
        <!--===========================================版权区=============================-->
        <div class="copyRight clearfix">
            <div class="container">
                <div class="leftBar">
                </div>
                <div class="rightBar">
                    <img src="${path}/static/pre/images/fot_ico1.png" alt="">
                    <img src="${path}/static/pre/images/fot_ico2.png" alt="">
                </div>
            </div>
        </div>
    </section>



    <!---==========================================侧边栏=================================-->
    <section class="sidebar">

    </section>


</div>


<script src="${path}/static/pre/scripts/jquery-1.11.1.min.js"></script>
<script src="${path}/static/pre/scripts/bootstrap.min.js"></script>
<script src="${path}/static/pre/scripts/main.js"></script>

</body>
</html>