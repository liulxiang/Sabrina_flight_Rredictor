<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="fixed_header">
<head>
  <c:import url="/WEB-INF/tags/web/header_title.jsp"/> 	
  <c:import url="/WEB-INF/tags/web/jsPlugin.jsp"/>
  <link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
  <link rel="stylesheet" href="<c:url value="/resources/web/css/common-content-left.css"/>" />
</head>

<body>
  <c:import url="/WEB-INF/tags/web/nav_header.jsp" />
    <div class="youyika nav-common">
	</div>
<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"/>'>Home</a></li>
			<li class="active"><a href="<c:url value="${path }"/>">${pathName }</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3 nav_member_setting_left">
	    <div class="memberInfo">
	       <div class="photo">
	         <img src="<c:url value="${sessionScope.UserConstant_VISITOR.photo}"/>" width="100px" height="140px" class="thumbnail"/>
	      </div>
	      <div class="information">
	         <span class="name">${sessionScope.UserConstant_VISITOR.username}</span>
		  </div>
		<div class="tags">
			<em class="S_txt2">参加活动数：</em>
			<a href="" title="${sessionScope.UserConstant_VISITOR.joinSum}">${sessionScope.UserConstant_VISITOR.joinSum}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">积分：</em>
			<a href="" title="${sessionScope.UserConstant_VISITOR.point}">${sessionScope.UserConstant_VISITOR.point}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">学校：</em>
			<a href="" title="${sessionScope.UserConstant_VISITOR.schoolName}">${sessionScope.UserConstant_VISITOR.schoolName}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">专业：</em><a href="" title="${sessionScope.UserConstant_VISITOR.major}">${sessionScope.UserConstant_VISITOR.major}</a>
		</div>
	    </div>
		<div class="list-group mt20">
			<a href="settings" class="list-group-item ">
			  <span class="glyphicon glyphicon-cog"></span>
			   member base info
			</a> 
			
			<a href="password" class="list-group-item">
			  <span class="glyphicon glyphicon-lock"></span>
			 modify  password 
			</a> 
			<a href="avatar" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			     modify photo
			</a> 
			<a href="addGood" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   add good
			</a> 
			<a href="browseGood" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   browse goods
			</a> 
			<a href="party" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   add party
			</a> 
			<a href="browseParty" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			     browse partys
			</a> 
			<a href="browseMessage" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			     browse Messages
			</a> 
		</div>
	</div>
	<sitemesh:write property="body"/>
  </div>
 <c:import url="/WEB-INF/tags/web/main_footer.jsp"/>
</body>
</html>