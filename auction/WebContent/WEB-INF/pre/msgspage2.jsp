<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="./common/static.jsp"></jsp:include>
<body>
	<!--======================================工具栏=======================================-->
	<jsp:include page="./common/header.jsp"></jsp:include>
	<!--======================================logo区=======================================-->
<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="container">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<a href="${path }">首页</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!--=======================================购物车开始====================================-->
	<section class="carts">
		<div class="container">
			<div class="title clearfix">
				<h3>我的消息</h3>
			</div>
			<div class="cart-box clearfix">
				<table class="col-xs-12 clearfix">
					<tr class="no-h">
                        <td class="len-lg">发送者</td>
                        <td class="len-lg">消息</td>
					</tr>
					<c:forEach items="${datas.data }" var="d">
					<tr>
                        <td>${d.fromname }</td>
                        <td>${d.msg }</td>
					</tr>
										</c:forEach>

				</table>
			</div>
		</div>
	</section>
	<!--===========================================售后服务==============-->
	<!--===========================================猜你喜欢==================================-->
	<!--===========================================售后服务=============================-->
	<!---==========================================侧边栏=================================-->
	<script src="${path}/static/pre/scripts/jquery-1.11.1.min.js"></script>
	<script src="${path}/static/pre/scripts/bootstrap.min.js"></script>
	<script src="${path}/static/pre/scripts/main.js"></script>
</body>
</html>