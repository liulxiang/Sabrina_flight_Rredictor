<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
	
			<div id="content-header">
				<h1>商品</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">商品</a>
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
            <th>Logo</th>
            <th>name</th>
            <th>title</th>
            <th>price</th>
            <th>level</th>
            <th>statu</th>
            <th>manager</th>
          </tr>
									</thead>
									<tbody>
								      
								<c:if test="${goods!=null }">
								<c:forEach var="good" varStatus="status"
									items="${goods}">
									<tr>
										<td>${good.goodId }</td>
										<td>${good.name }</td>
										<td>${good.title }</td>
										<td>${good.price }</td>
										<td>${good.level }</td>
										<td>
										<c:if test="${party.statu==0}">
              有效
            </c:if>
            <c:if test="${party.statu==1}">
              已删除
            </c:if>
										</td>
										
										<td>
										<a href="<c:url value="/admin/deleteGood"/>?goodId=${good.goodId }">delete</a> 
										<a href="<c:url value="/web/goodDetail"/>?goodId=${good.goodId}">view</a>
										</td>
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
