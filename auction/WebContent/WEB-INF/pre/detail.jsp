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

	<!--======================================导航区=======================================-->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="container">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
											<li><a href="${path }">首页</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!--背景色-->
	<div class="bg">
		<!--=======================================产品详情=======================================-->
		<section class="pro-details">
			<div class="container">
				<p class="addr-pro">
					<span></span>
				</p>
				<div class="details-display clearfix">
					<div class="leftBar imgBox">
						<div class="bigImg spec-preview">
							<a class="jqzoom" href="javascript: void (0)"> <img jqimg="${record.picurl}" src="${record.picurl}" alt="" /></a>
						</div>
						<div class="extra-infor">
							<div class="share"></div>
						</div>
					</div>
					<div class="leftBar textBox">
						<h4 class="title">${record.title }</h4>
						<div class="bigImg-title clearfix">
							<div class="clearfix">
								<span class="leftBar">拍卖价</span> <strong class="leftBar">￥${record.price }</strong>
							</div>
							<p>																	<c:if test="${record.type==0 }">
							现价：${record.nowprice }</c:if></p>
						</div>
						<ul class="chose-num">
							<li></li>
							<li>                                  <div class="carts-b clearfix">
							<div class="buy_box clearfix">
                                <a class="go_plus" href="${path }/index/msgs/add?fromid=${indexUser.id}&toid=${record.uid}">联系卖家</a>
																	<c:if test="${record.type==0 || record.type==2}">

							<a class="go_plus" href="${path }/index/cart/add?id=${record.id}">加价拍</a>
							</c:if>
																	<c:if test="${record.type==1 }">

							<a class="go_plus"  href="${path }/index/cart/add2?id=${record.id}">一口价购买</a></c:if>
							</div></div></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<!--=========================================强烈推荐===============================-->
		<section class="package-show">
			<div class="container"></div>
		</section>
		<!--=======================================商品详情、售后服务等等==========================-->
		<section>
			<div class="container">
				<div class="leftBar details-left">
					<ol class="package-title package1-title">
						<li class="active"><a href="#detail">商品详情</a></li>
					</ol>
					<div id="detail" class="des detail part">${record.desc }</div>
					<!--=========================================售后服务=======================-->
					<!--==========================物流配送=========================-->
					<!--==========================================客户评价================================-->
				</div>
				<!--==========================相关商品推荐========================-->
			</div>
		</section>
		<!--===========================================猜你喜欢==================================-->
		<section class="likes">
			<div class="container"></div>
		</section>
		<!--========================================活动进行时=============================-->
	</div>
	<!--==========================================手机版的返回顶部============================-->
	<script src="${path}/static/pre/scripts/jquery-1.11.1.min.js"></script>
	<script src="${path}/static/pre/scripts/bootstrap.min.js"></script>
	<script src="${path}/static/pre/scripts/jquery.jqzoom.js"></script>
	<script src="${path}/static/pre/scripts/main.js"></script>
</body>
</html>