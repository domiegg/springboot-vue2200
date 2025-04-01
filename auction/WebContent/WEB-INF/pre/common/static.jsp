<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${sitename }</title>
    <link rel="shortcut icon" href="${path}/static/pre/images/favicon.ico" type="x-icon">
    <link rel="stylesheet" href="${path}/static/pre/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/pre/styles/reset.css">
    <link rel="stylesheet" href="${path}/static/pre/styles/main.css">
    <!--[if lt IE 9]>
  <!--html5shiv.js 实现html语义化标签的支持-->
    <script src="${path}/static/pre/scripts/html5shiv.js"></script>
    <!--respond.js实现响应式布局的支持，包括媒体查询等-->
    <script src="${path}/static/pre/scripts/respond.min.js"></script>
    <![endif]-->

</head>