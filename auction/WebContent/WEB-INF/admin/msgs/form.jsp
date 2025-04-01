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

            <form role="form" action="<c:if test="${edit==true }">${path }/msgs/update</c:if><c:if test="${edit==false }">${path }/msgs/add</c:if>" method="post">
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
						  <label for="msg">信息</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="msg" value="${record.msg}" id="msg" placeholder="信息">


						</div>
						<div class="form-group">
						  <label for="fromid">发送人</label>
                  		  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="fromid" value="${record.fromid}" id="fromid" placeholder="发送人(只能为数字)">


						</div>
						<div class="form-group">
						  <label for="toid">接收人</label>
                  		  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="toid" value="${record.toid}" id="toid" placeholder="接收人(只能为数字)">


						</div>
						<div class="form-group">
						  <label for="fromname">发送人</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="fromname" value="${record.fromname}" id="fromname" placeholder="发送人">


						</div>
						<div class="form-group">
						  <label for="toname">接受人</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="toname" value="${record.toname}" id="toname" placeholder="接受人">


						</div>
						<div class="form-group">
						  <label for="created">发送时间</label>
	                  	  <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="created" value="${record.created}" id="created" placeholder="发送时间">


						</div>
                <div class="has-error">
                <span class="help-block">${msg }</span>
                </div>
              </div>

              <div class="box-footer">
  			<c:if test="${edit==false }"><button onclick="${path }/msgs" class="btn btn-primary">返回</button></c:if>
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
