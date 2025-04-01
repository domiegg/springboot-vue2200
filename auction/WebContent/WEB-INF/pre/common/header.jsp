<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<section class="toolbar">
    <div class="container">
        <ul class="leftBar toolbar-left">
            <li><span>|</span></li>
            <li><span>欢迎！${indexUser.nickname}</span></li>
            <li><a href="${path }/index/logout">退出</a></li>
            <c:if test="${indexUser ==null }">
                <li><a href="${path }/index/login">登录</a></li>
                <li><a href="${path }/index/reg">快速注册</a></li>
            </c:if>
        </ul>
        <ul class="rightBar toolbar-right">
            <c:if test="${indexUser!=null}">
                <li>
                    <a href="${path }/index/product">竞得商品</a></li>
                <li><a href="${path }/index/auctionlog">我的拍卖</a></li>
                <li><a href="${path }/index/product/page">我的商品</a></li>
                <li><a href="${path }/index/msgs/page?toid=${indexUser.id}">我的消息</a></li>
                <li><a href="${path }/index/product/add">发布商品</a></li>
                <li><a href="${path }/index/msgs/add?toid=9999">留言反馈</a></li>
            </c:if>
            <li><span>|</span></li>
            <li class="two-code"><a href="javascript:void (0)">&nbsp;</a></li>
        </ul>
    </div>
</section>
<header class="container">
    <div class="logoArea leftBar">
        <a href="${path}/"><img src="${path}/static/imgs/logo.png" style="height: 100px;"/></a>
    </div>
    <div class="logoArea leftBar" style="float: right;margin-right: 50px">
        <form action="${path}/">
            <input name="title" style="border: solid #60a411"/>
            <button type="submit" style="background-color: #60a411">搜索</button>
        </form>

    </div>
</header>