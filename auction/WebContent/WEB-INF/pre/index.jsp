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
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="container">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="sorts"><a href="${path }">全部商品分类 &gt;&gt;</a>
							<ul class="sorts-content">
								<c:forEach items="${cates }" var="c">
									<li class="clearfix sorts-one">
										<div class="sorts-title">
											<a href="${path }/?cateid=${c.id}"> <i>&nbsp;</i>${c.name }
											</a>
										</div>
									</li>
								</c:forEach>
							</ul></li>
						<li><a href="${path }">首页</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!--========================================产品列表=====================================-->
	<section class="list-content">
		<div class="container">
			<div class="leftBar clearfix"></div>
			<div class="rightBar">
				<div class="right-content">
					<div class="img-display">
						<ul class="block-list-box">
							<c:forEach items="${datas.data }" var="p">
								<li class="block-list"><a href="${path }/index/product/view?id=${p.id}"> <img src="${p.picurl}" alt="" /> ${p.title }
								</a>
									<p class="price">
										<strong>¥ ${p.price }</strong>
									</p>
									<div class="market-price">
										<small><del></del></small>
									</div>
									<p class="buy-btn">
										<c:if test="${p.type==1 }">
											<a href="${path }/index/cart/add?id=${p.id}">加价拍</a>
										</c:if>
										<c:if test="${p.type==0 }">
											<a href="${path }/index/cart/add2?id=${p.id}">一口价购买</a>
										</c:if>
									</p></li>
							</c:forEach>
						</ul>
					</div>
					<div class="page rightBar">
						<jsp:include page="./common/page.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!---==========================================侧边栏=================================-->
	<script src="${path}/static/pre/scripts/jquery-1.11.1.min.js"></script>
	<script src="${path}/static/pre/scripts/bootstrap.min.js"></script>
	<script src="${path}/static/pre/scripts/main.js"></script>
</body>
</html>