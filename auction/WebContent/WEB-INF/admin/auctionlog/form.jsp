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

            <form role="form" action="<c:if test="${edit==true }">${path }/auctionlog/update</c:if><c:if test="${edit==false }">${path }/auctionlog/add</c:if>" method="post">
              <c:if test="${edit==true }">
              <input type="hidden" name="id" value="${record.id }">
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
						  <label for="uid"></label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="uid" value="${record.uid}" id="uid" placeholder="">


						</div>
						<div class="form-group">
						  <label for="username">拍者</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="username" value="${record.username}" id="username" placeholder="拍者">


						</div>
						<div class="form-group">
						  <label for="pid"></label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="pid" value="${record.pid}" id="pid" placeholder="">


						</div>
						<div class="form-group">
						  <label for="ptitle">商品</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="ptitle" value="${record.ptitle}" id="ptitle" placeholder="商品">


						</div>
						<div class="form-group">
						  <label for="price">加价</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="price" value="${record.price}" id="price" placeholder="加价">


						</div>
						<div class="form-group">
						  <label for="created"></label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="created" value="${record.created}" id="created" placeholder="">


						</div>
                <div class="has-error">
                <span class="help-block">${msg }</span>
                </div>
              </div>

              <div class="box-footer">
  			<c:if test="${edit==false }"><button onclick="${path }/auctionlog" class="btn btn-primary">返回</button></c:if>
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
$('#created').datepicker({
autoclose: true
});

});
</script>
</html>
