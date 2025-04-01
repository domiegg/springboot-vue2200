<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <div class="col-xs-12">
  <!-- Horizontal Form -->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">查询条件</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" method="post" action="${path }/cate">
              <input type="hidden" name="page" id="page" value="1">
              <input type="hidden" name="pageSize" id="pageSize" value="20">

              <div class="box-body">
                <div class="form-group pull-left">
                 
               <!--  <select class="form-control" name="sectionid">
											<option value=""></option>
												<c:forEach items="${sections}" var="s">
													<option value="${s.id }">${s.name }</option>
												</c:forEach>
											</select>  -->
						  <label for="name" class="col-sm-2 control-label">分类名</label>
		                  <div class="col-sm-4">
		                    <input type="text" class="form-control" name="name" id="name" placeholder="可惜名">
		                  </div>
                </div>
                <div class="margin pull-right">
					<div class="btn-group">
			            <a href="${path }/cate/add" class="btn btn-sm btn-info ">添加</a>
					</div>
					<div class="btn-group ">
			            <button type="submit"  id="searchButton" class="btn btn-sm btn-default">查询</button>
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
              <h3 class="box-title">分类列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
	            <table id="example2" class="table table-bordered table-hover">
	                <thead>
	                <tr>
	                  <th>分类名</th>
	                <th>操作</th>

	                </tr>
	                </thead>
	                <tbody>
	                <c:forEach var="d" items="${datas.data }">
	                <tr>
	                  <td>
	                  ${d.name }
	                  </td>
	                  <td>
	                  	<a class="btn btn-info" href="${path}/cate/view?id=${d.id }" >查看</a>
	                  	<a class="btn btn-primary" href="${path}/cate/edit?id=${d.id }" >编辑</a>
	                  	<a class="btn btn-danger" href="${path}/cate/del?id=${d.id }" >删除</a>
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
