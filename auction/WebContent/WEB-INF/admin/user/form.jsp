<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${sitename}</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
            <form role="form" action="${path }/user/add" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">用户名</label>
                  <input type="text" class="form-control" name="username" id="exampleInputEmail1" placeholder="用户名">
                </div>
                   <div class="form-group">
                  <label for="exampleInputEmail1">昵称</label>
                  <input type="text" class="form-control" name="nickname" id="exampleInputEmail1" placeholder="昵称">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">密码</label>
                  <input type="password" class="form-control" name="psw" id="exampleInputPassword1" placeholder="密码">
                </div>
                <div class="has-error">
                <span class="help-block">${msg }</span>
                </div>
              </div>
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">保存</button>
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
</html>
