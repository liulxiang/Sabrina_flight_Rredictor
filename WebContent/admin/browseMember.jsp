<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
	
			<div id="content-header">
				<h1>在线列表</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">在线列表</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<h5>目前在线用户统计</h5>
							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered data-table">
									<thead>
									<tr>
									<th>id</th>
									<th>name</th>
									<th>email</th>
									</tr>
									</thead>
									<tbody>
									 <c:if test="${members!= null}">
											<c:forEach var="member" varStatus="status" items="${members}">
												<tr class="gradeX">
												<td>${member.id}</td>
												<td>${member.name}</td>
												<td>${member.email}</td>
												</tr>
										   </c:forEach>
								      </c:if>
									</tbody>
									</table>  
							</div>
						</div>
					</div>
				</div>
				
			</div>
		
      <script src="<c:url value="/resources/admin/js/unicorn.tables.js"/>"></script> 
