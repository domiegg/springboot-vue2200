<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<section class="content-header"></section>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<!-- Horizontal Form -->
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">查询条件</h3>
							</div>
							<form class="form-horizontal" method="post" action="${path }${url}">
								<input type="hidden" name="page" id="page" value="1"> <input type="hidden" name="pageSize" id="pageSize" value="20">
								<div class="box-body">
									<div class="form-group pull-left">
										<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="username" id="inputEmail3" placeholder="用户名">
										</div>
										<label for="inputPassword3" class="col-sm-2 control-label">昵称</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="nickname" id="inputPassword3" placeholder="昵称">
										</div>
									</div>
									<div class="margin pull-right">
										<div class="btn-group">
											<a href="${path }/${url}/add" class="btn btn-sm btn-info ">添加</a>
										</div>
										<div class="btn-group ">
											<button type="submit" id="searchButton" class="btn btn-sm btn-default">查询</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">用户列表</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>用戶名</th>
											<th>昵称</th>
											<th>创建日期</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="d" items="${datas.data }">
											<tr>
												<td>${d.username }</td>
												<td>${d.nickname }</td>
												<td><fmt:formatDate value="${d.created }" pattern="yyyy年MM月dd日  HH:mm" /></td>
												<td><c:choose>
														<c:when test="${d.status==0 }">
															<small class="label bg-primary">启用</small>
														</c:when>
														<c:when test="${d.status==1 }">
															<small class="label bg-red">禁用</small>
														</c:when>
													</c:choose></td>
												<td><c:choose>
														<c:when test="${d.status==0 }">
															<a class="btn btn-danger" href="javascript:;" onclick="lock(this)" data-id="${d.id }">禁用</a>
														</c:when>
														<c:when test="${d.status==1 }">
															<a class="btn btn-primary" href="javascript:;" onclick="lock(this)" data-id="${d.id }">启用</a>
														</c:when>
													</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
								<jsp:include page="../common/page.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<script>
  $(function () {
	$(".search").on("click",function(){
		$("#page").val($(this).attr("data-page"));
		$("#searchButton").click();
	});
    $('#example2').DataTable({
      "paging": false,
      "info": false,
      "searching":false,
      "language":
      {
	      "infoPostFix":    "",
	      "thousands":      ",",
	      "lengthMenu":     "Show _MENU_ entries",
	      "loadingRecords": "加载中...",
	      "processing":     "Processing...",
	      "zeroRecords":    "无结果",
	      "paginate": {
	          "first":      "第一页",
	          "last":       "最后一页",
	          "next":       "后一页",
	          "previous":   "前一页"
	      }
      }
    });
  });
  function lock(obj){
	  $.get("${path}/user/lock", { id: $(obj).attr("data-id")},
			  function(data){
				  if(data.result){
					  $('#example2').reload();
				  }
			  });
	  window.location.reload();
  }

</script>
</body>
</html>
