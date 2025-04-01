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
			<section class="content-header"></section>
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
							<form role="form" <c:if test="${edit==null || edit==true}">enctype="multipart/form-data" </c:if> action="<c:if test="${edit==null }">${path }/product/save</c:if> <c:if test="${edit==true }">${path }/product/update</c:if><c:if test="${edit==false }">${path }/product/add</c:if>" method="post">
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
										<label for="cateid">分类</label> <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="cateid">
											<c:forEach items="${cates}" var="s">
												<option value="${s.id }" <c:if test="${s.id==record.cateid }"> selected </c:if>>${s.name }</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="price">起拍价</label> <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="price" value="${record.price}" id="price" placeholder="起拍价">
									</div>
									<div class="form-group">
										<label for="type">类型</label> <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="type">
											<option value="0" <c:if test="${0==record.type }"> selected </c:if>>拍卖</option>
											<option value="1" <c:if test="${1==record.type }"> selected </c:if>>一口价</option>
                                        <option value="2" <c:if test="${record.type==2}">selected</c:if>>特殊拍卖</option>

                                    </select>
									</div>
									<div class="form-group">
										<label for="title">标题</label> <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="title" value="${record.title}" id="title" placeholder="标题">
									</div>
									<div class="form-group">
										<label for="desc">详情</label> <textarea  class="form-control" <c:if test="${edit==false }">readonly</c:if> name="desc"  id="desc" placeholder="">${record.desc}</textarea>
									</div>


									<div class="form-group">
										<label for="status">状态：</label>

										<select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="status">
											<option value="0" <c:if test="${0==record.status }"> selected </c:if>>待拍卖</option>
											<option value="1" <c:if test="${1==record.status }"> selected </c:if>>拍卖中</option>
											<option value="2" <c:if test="${2==record.status }"> selected </c:if>>拍卖结束</option>
											<option value="3" <c:if test="${3==record.status }"> selected </c:if>>流拍</option>
										</select>

									</div>



									<div class="form-group">
										<label for="enddate">图片</label> <input type="file"  <c:if test="${edit==false }">disabled</c:if> name="file"  >
									</div>
									<div class="has-error">
										<span class="help-block">${msg }</span>
									</div>
								</div>
								<div class="box-footer">
									<c:if test="${edit==false }">
										<button onclick="${path }/product" class="btn btn-primary">返回</button>
									</c:if>
									<c:if test="${edit==true || edit==null}">
										<button type="submit" class="btn btn-primary">保存</button>
									</c:if>
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
$('#enddate').datepicker({
autoclose: true
});

});

var editor = new wangEditor('desc');
// 普通的自定义菜单
editor.config.menus = [
    'img',
    '|',     // '|' 是菜单组的分割线
    'emotion',

 ];
editor.config.uploadImgUrl="${path}/index/upload2";
editor.config.uploadImgFileName = 'file';
   editor.create();
</script>
</html>
