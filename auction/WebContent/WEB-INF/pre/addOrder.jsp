<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h3>填写订单</h3>
        </div>
        <form action="<c:if test="${edit!=true}">${path }/index/order/add</c:if><c:if test="${edit==true}">${path }/index/product/update</c:if>" method="post" enctype="multipart/form-data">
            <div class="cart-box clearfix">
                <table class="col-xs-12 clearfix">
                    <input type="hidden" name="id" value="${record.id }">
                    <input type="hidden" name="preuserid" value="${indexUser.id }">
                    <input type="hidden" name="productid" value="${record.productid }">
                    <input type="hidden" name="preusername" value="${indexUser.nickname }">
                    <tr class="no-h">
                        <td class="len-sm" style="text-align: right">地址：</td>
                        <td class="len-sm no-see"><input style="float:left;border: 1px solid" required type="text" name="address" /> </td>
                    </tr>
                    <tr class="no-h" style="line-height: 40px;">
                        <td class="" style="text-align: right">电话：</td>
                        <td class=""><input style="    float: left;border: 1px solid" required name="tel" /></td>
                    </tr>
                </table>


            </div>
            <div class="carts-b clearfix">
                <div class="buy_box clearfix">
                    <button type="submit"><a class="go_plus">提交</a></button>
                </div>
            </div>
        </form>
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