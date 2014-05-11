<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/nav-header.css"/>" />
<div id="header" class="header_color light_bg_color">
     <div id="header_main" class="container_wrap container_wrap_logo">
         <div class="container">
			<strong class="logo"> <a href="<c:url value="/index"/>""> <img
					src="<c:url value="/resources/web/images/Logo_youyika.png"/>" alt="Whoopes"></a></strong>
			  <div class="top_nav">
                <ul class="nav nav-pills">
                     <li class="active"><a href="<c:url value="/web/partys"/>">Party&nbsp;&nbsp;</a></li>
                     <li><a href="<c:url value="/web/goods"/>">shop&nbsp; by &nbsp;department</a></li>
				</ul>
             </div>
			 <div class="top_about">
                 <ul class="nav nav-pills">
                 <c:if test="${sessionScope.UserConstant_VISITOR == null}">
                     <li><a href="#loginModal" data-toggle="modal">Login&nbsp;&nbsp;</a></li>
                     <li><a href="<c:url value="/preRegister"/>">register&nbsp;&nbsp;</a></li>
                 </c:if>
                    <c:if test="${sessionScope.UserConstant_VISITOR != null}">
                      <li class="color_f63">
                      <a href="<c:url value="/viewMemberInfo"/>?memberId=${sessionScope.UserConstant_VISITOR.userid }">${sessionScope.UserConstant_VISITOR.username }</a></li>
                      <li>  <a href="<c:url value="/member/settings/settings"/>">Setting</a></li>
					   <li><a href="<c:url value="/logout"/>" title="logout ">
									logout</a></li>
					   <li><a href="<c:url value="/member/settings/browseMessage"/>">
					   <span class="glyphicon glyphicon-bullhorn"></span>
					    <span class="badge">${sessionScope.UserConstant_VISITOR.messageSum}</span></a></li>
					</c:if>
				</ul>
             </div>
      <div class="top_middle">
	      <form class="navbar-form" action="<c:url value="/web/search"/>">
		      <select class="form-control categoryType" name="categoryType" >
	              <option value="1">good</option>
	              <option value="2">party</option>
	            </select>
	          <input type="text" class="form-control navbar-form-width" name="content" required="required">
	          <button type="submit" class="btn btn-primary">search</button>
        </form>
      </div>
             <!-- end container-->
         </div>
         <!-- end container_wrap-->
     </div>
     <div class="header_bg">
     </div>
     <!-- end header -->
 </div>
 
 

 <!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
 		<div class="modal-dialog panel-primary login-panel">
          <div class="modal-content">
	         <div class="modal-body login-panel">
			          <form class="form-horizontal login-panel-left" action='<c:url value="/memberLogin"/>' method="post">
							<div class="form-group">
								<h3>Sign in</h3>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">email：</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" placeholder="email" name="email" required="required"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">password：</label>
								<div class="col-lg-10">
									<input type="password" class="form-control"
										placeholder="password"  name="password" required="required"/>
								</div>
							</div>
							<div class="form-group tc">
								<button type="submit" class="btn btn-info btn-lg"> Login </button>
							</div>
					   </form>
					   <div class="login-panel-middle"></div> 
			          <form class="form-horizontal login-panel-right" action='<c:url value="/memberLogin"/>' method="post">
							<div class="form-group">
							</div>
							<div class="form-group">
							</div>
							<div class="form-group">
							</div>
							<div class="form-group">
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-info btn-lg" data-dismiss="modal">facebook Login </button>
							</div>
							<div class="form-group">
							
							</div>
							
					   </form> 
				 </div>
	<!-- 
		      <div class="modal-footer">
	              <button type="button" class="btn btn-default " data-dismiss="modal">cancel</button>
	              <button type="submit" class="btn btn-primary" >login</button>
            </div>
     -->
       </div><!-- /.modal-content //-->
    </div><!-- /.modal-dialog //-->
  
</div><!-- /.modal -->



<c:if test="${requestScope.status !=null}">
<c:if test="${requestScope.status !=0}">
 <div class="alert  alert-block navbar-fixed-top container">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <p>${requestScope.message}</p>
</div>
</c:if>
</c:if>
<c:if test="${param.status !=null}">
<c:if test="${param.status !=0}">
 <div class="alert  alert-block navbar-fixed-top container">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <p>${param.message}</p>
</div>
</c:if>
</c:if>
