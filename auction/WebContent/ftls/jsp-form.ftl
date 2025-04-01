<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${r"${pageContext.request.contextPath}"}"></c:set>
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

            <form role="form" action="<c:if test="${r"${edit==true }"}">${r"${path }/"}${bean.name?uncap_first }/update</c:if><c:if test="${r"${edit==false }"}">${r"${path }/"}${bean.name?uncap_first }/add</c:if>" method="post">
              <c:if test="${r"${edit==true }"}">
              <input type="hidden" name="id" value="${r"${record.id }"}">
			  </c:if>
              <div class="box-body">
              <!-- <select class="form-control" <c:if test="${r"${edit==false }"}">disabled</c:if> name="sectionid">
				  <c:forEach items="${r"${sections}"}" var="s">
				  		<option value="${r"${s.id }"}" <c:if test="${r"${s.id==record.sectionid }"}"> selected </c:if>>
				  		${r"${s.name }"}
				  		</option>
				  </c:forEach>
			  </select> -->
              
                  <#list bean.attrs as attr>
                  	<#if attr.dbname!="id">
						<div class="form-group">
						  <label for="${attr.jname?uncap_first}">${attr.comment}</label>
						  <#if attr.jtype=="Integer">
                  		  <input type="text" class="form-control" <c:if test="${r"${edit==false }"}">disabled</c:if> name="${attr.jname?uncap_first}" value="${r"${record."}${attr.jname?uncap_first}${r"}"}" id="${attr.jname?uncap_first}" placeholder="${attr.comment}(只能为数字)">
	                  	  <#elseif  attr.ogdtype=="TEXT">
	                  	  <textarea  class="textarea" <c:if test="${r"${edit==false }"}">readonly</c:if> name="${attr.jname?uncap_first}" style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>

	                  	  <#else>
	                  	  <input type="text" class="form-control" <c:if test="${r"${edit==false }"}">disabled</c:if> name="${attr.jname?uncap_first}" value="${r"${record."}${attr.jname?uncap_first}${r"}"}" id="${attr.jname?uncap_first}" placeholder="${attr.comment}">
	                  	  </#if>


						</div>
	                 </#if>
                  </#list>
                <div class="has-error">
                <span class="help-block">${r"${msg }"}</span>
                </div>
              </div>

              <div class="box-footer">
  			<c:if test="${r"${edit==false }"}"><button onclick="${r"${path }/"}${bean.name?uncap_first }" class="btn btn-primary">返回</button></c:if>
                 <c:if test="${r"${edit==true || edit==null}"}"><button type="submit" class="btn btn-primary">保存</button></c:if>
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
<#list bean.attrs as attr>
<#if attr.jtype=="Date">
${r"$('#"}${attr.jname?uncap_first}').datepicker({
autoclose: true
});
</#if>
</#list>

});
</script>
</html>
