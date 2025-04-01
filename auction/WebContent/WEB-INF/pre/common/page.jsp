<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
 <p>
				<c:choose>
				<c:when test="${datas.totalPage==0 }">
				</c:when>
				<c:when test="${datas.totalPage==1 }">
					<a href="javascript:;" class="current">1</a>
				</c:when>
				<c:when test="${datas.totalPage==2}">
					<a href="javascript:;"  class="<c:if test="${datas.page==1}"> current</c:if>">1</a>
	<a href="javascript:;"  class="<c:if test="${datas.page==2}"> current</c:if>">2</a>
				</c:when>
				<c:when test="${datas.totalPage==datas.page}">
					<c:if test="${datas.totalPage>=3 }">
						<span>…</span>
					</c:if>
					<a href="javascript:;" class="search" >${datas.page-1}</a>
				<a href="javascript:;" class="current" >${datas.page}</a>
				</c:when>
				<c:otherwise>
					<c:choose>
					<c:when test="${datas.page==1 }">
					<a href="javascript:;" class="current" >1</a>
						<a href="javascript:;" class="search" class="${datas.page+1}">${datas.page+1}</a>
						<span>…</span>
					</c:when>
					<c:when test="${datas.page==datas.totalPage }">
						<span>…</span>
						<a href="javascript:;" class="search" class="${datas.page-1}">${datas.page-1}</a>
						<a href="javascript:;" class="current " >${datas.page}</a>
					</c:when>
					<c:otherwise>
						<c:if test="${datas.totalPage>3 && 1!=datas.totalPage-1}}">
							<span>…</span>
						</c:if>
						<a href="javascript:;" class="search" >${datas.page-1}</a>
						<a href="javascript:;" class="current search" >${datas.page}</a>
						<a href="javascript:;" class="search" >${datas.page+1}</a>
						<c:if test="${datas.totalPage>3 && datas.page<datas.totalPage-1}">
							<li class=" "><span>…</span>
						</c:if>
					</c:otherwise>
					</c:choose>

				</c:otherwise>
				</c:choose>    </p>
