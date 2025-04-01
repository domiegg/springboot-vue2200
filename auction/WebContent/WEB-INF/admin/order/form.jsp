<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/static.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../common/menu.jsp"></jsp:include>
		 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">填写信息</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->

            <form role="form" action="<c:if test="${edit==true }">${path }/order/update</c:if><c:if test="${edit==false }">${path }/order/add</c:if>" method="post">
              <c:if test="${edit==true }">
                  <input type="hidden" name="id" value="${record.id }">
                  <input type="hidden" name="productid" value="${record.productid }">
			  </c:if>
              <div class="box-body">
              <!-- <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="sectionid">
				  <c:forEach items="${sections}" var="s">
				  		<option value="${s.id }" <c:if test="${s.id==record.sectionid }"> selected </c:if>>
				  		${s.name }
				  		</option>
				  </c:forEach>
			  </select> -->
              

						<div class="form-group">
						  <label for="status">状态</label>
                            <select name="status" class="form-control">
                                <option value="0" <c:if test="${0==record.status }"> selected </c:if>>待发货</option>
                                <option value="1" <c:if test="${1==record.status }"> selected </c:if>>已发货</option>
                                <option value="2" <c:if test="${2==record.status }"> selected </c:if>>已完成</option>
                                <option value="3" <c:if test="${3==record.status }"> selected </c:if>>已退货</option>
                            </select>


						</div>
						<div class="form-group">
						  <label for="address">收货地址</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="address" value="${record.address}" id="address" placeholder="收货地址">


						</div>
						<div class="form-group">
						  <label for="tel">电话</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="tel" value="${record.tel}" id="tel" placeholder="电话">


						</div>

                <div class="has-error">
                <span class="help-block">${msg }</span>
                </div>
              </div>

              <div class="box-footer">
  			<c:if test="${edit==false }"><button onclick="${path }/order" class="btn btn-primary">返回</button></c:if>
                 <c:if test="${edit==true || edit==null}"><button type="submit" class="btn btn-primary">保存</button></c:if>
                </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>

</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
$(function () {
//Date picker

});
</script>
</html>
