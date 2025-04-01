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
							<!-- /.box-header -->
							<!-- form start -->
							<form class="form-horizontal" method="post" action="${path }/product">
								<input type="hidden" name="page" id="page" value="1"> <input type="hidden" name="pageSize" id="pageSize" value="20">
								<div class="box-body">
									<div class="form-group pull-left">
										<!--  <select class="form-control" name="sectionid">
											<option value=""></option>
												<c:forEach items="${sections}" var="s">
													<option value="${s.id }">${s.name }</option>
												</c:forEach>
											</select>  -->
										<label for="catename" class="col-sm-2 control-label">分类名</label>
										<div class="col-sm-4">
											<select class="form-control" name="cateid">
												<option value=""></option>
												<c:forEach items="${cates}" var="s">
													<option value="${s.id }">${s.name }</option>
												</c:forEach>
											</select>
										</div>
										<label for="username" class="col-sm-2 control-label">发布人</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="username" id="username" placeholder="发布人">
										</div>
										<label for="title" class="col-sm-2 control-label">标题</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="title" id="title" placeholder="标题">
										</div>
										<label for="buyername" class="col-sm-2 control-label">得主</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="buyername" id="buyername" placeholder="得主">
										</div>
										<label for="status" class="col-sm-2 control-label">状态</label>
										<div class="col-sm-4">
											<select class="form-control" name="catstatuseid">
												<option value=""></option>
												<option value="0">待拍卖</option>
												<option value="1">拍卖中</option>
												<option value="2">拍卖结束</option>
												<option value="3">流拍</option>
											</select>
										</div>
									</div>
									<div class="margin pull-right">
										<div class="btn-group">
											<a href="${path }/product/add" class="btn btn-sm btn-info ">添加</a>
										</div>
										<div class="btn-group ">
											<button type="submit" id="searchButton" class="btn btn-sm btn-default">查询</button>
										</div>
									</div>
								</div>
								<!-- /.box-body -->
								<!-- /.box-footer -->
							</form>
						</div>
					</div>
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">商品列表</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>分类名</th>
											<th>发布人</th>
											<th>起拍价</th>
											<th>类型</th>
											<th>图片</th>
											<th>标题</th>
											<th>创建时间</th>
											<th>得主</th>
											<th>状态</th>
											<th>现价</th>
											<th>结束时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="d" items="${datas.data }">
											<tr>
												<td>${d.catename }</td>
												<td>${d.username }</td>
												<td>${d.price }</td>
												<td>
												<c:if test="${d.type==0}">拍卖</c:if>
                                                    <c:if test="${d.type==1}">一口价</c:if>
                                                    <c:if test="${d.type==2}">特殊拍卖</c:if>
												</td>
												<td><img src="${d.picurl }" style="width:150px;height:150px;"></td>
												<td>${d.title }</td>
												<td>
													<fmt:formatDate value="${d.created }" pattern="yyyy年MM月dd日  HH:mm" />
												</td>
												<td>${d.buyername }</td>
												<td>
												<c:if test="${d.status==0}">待拍卖</c:if>
												<c:if test="${d.status==1}">拍卖中</c:if>
												<c:if test="${d.status==2}">拍卖结束</c:if>
												<c:if test="${d.status==3}">流拍</c:if>

</td>
												<td>${d.nowprice }</td>
												<td>
													<fmt:formatDate value="${d.enddate }" pattern="yyyy年MM月dd日  HH:mm" />
												</td>
												<td>
													<a class="btn btn-info" href="${path}/product/view?id=${d.id }">查看</a>
													<a class="btn btn-primary" href="${path}/product/edit?id=${d.id }">编辑</a>
													<a class="btn btn-danger" href="${path}/product/del?id=${d.id }">删除</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
								<jsp:include page="../common/page.jsp"></jsp:include>
							</div>
							<!-- /.box-body -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->
	<!-- page script -->
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

</script>
</body>
</html>
