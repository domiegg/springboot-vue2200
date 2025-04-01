<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<header class="main-header">
	<!-- Logo -->
	<a href="index2.html" class="logo"> <span class="logo-mini">${sitename }</span> <span class="logo-lg"><b>${sitename}</b></span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only"></span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<li class="dropdown messages-menu"><a href="${path }/logout" class="dropdown-toggle"> 退出 </a></li>
				<!-- Notifications: style can be found in dropdown.less -->
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="${path}/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
						<span class="hidden-xs">${loginUser.nickname }</span>
				</a></li>
				<li><a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a></li>
			</ul>
		</div>
	</nav>
</header>
