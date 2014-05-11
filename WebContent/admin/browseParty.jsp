<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		
	
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
            <th>id</th>
            <th>icon</th>
            <th>title</th>
            <th>startTime</th>
            <th>endTime</th>
            <th>join sum</th>
            <th>statu</th>
            <th>manager</th>
          </tr>
									</thead>
									<tbody>
								      
		<c:if test="${partys!=null }">
            <c:forEach var="party" varStatus="status" items="${partys}">
           <tr>
            <td>${party.id }</td>
            <td>
             <img alt="${party.title }" src="<c:url value="${party.icon}"></c:url>" width="120px" height="60px">
            </td>
            <td>${party.title }</td>
            <td>
             <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td><fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${party.joinSum}</td>
            <td>
            <c:if test="${party.state==0}">
              有效
            </c:if>
            <c:if test="${party.state==1}">
              已删除
            </c:if>
            </td>
            <td>
            <a href="<c:url value="/admin/deleteParty"/>?partyId=${party.id}">delete</a> 
			<a href="<c:url value="/web/partyDetail"/>?partyId=${party.id}">view</a>
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
