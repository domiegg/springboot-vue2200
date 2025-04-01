<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<aside class="main-sidebar">
	<section class="sidebar">
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${path}/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${loginUser.nickname }</p>
			</div>
		</div>
		<ul class="sidebar-menu">
			<li class="header">导航</li>
			<c:forEach items="${menu }" var="m">
				<li class='<c:if test="${m.code==urlmain }">active</c:if> <c:if test="${!empty m.childs}">treeview</c:if>'><a href="${path}/${m.code}"> <i class="fa ${m.icon}"></i> <span>${m.title }</span>
						<c:if test="${!empty m.childs}">
							<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
							</span>
						</c:if>
				</a> <c:if test="${!empty m.childs}">
						<ul class="treeview-menu">
							<c:forEach items="${m.childs }" var="cm">
								<li class="<c:if test="${cm.code==url }">active</c:if>"><a href="${path}/${cm.code }"><i class="fa ${cm.icon }"></i>${cm.title }</a></li>
							</c:forEach>
						</ul>
					</c:if></li>
			</c:forEach>
		</ul>
	</section>
</aside>
