<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/buy-card.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">活动详情</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<span> <img width="233" height="145"
			class="product-image thumbnail"
			src="<c:url value="${party.icon}"/>"
			alt="${party.title }">
		</span>
		<p class="text-primary tc">
		  ${party.title }
		</p>
		<p class="text-primary"><span class="color_f63 fb">活动发起人：</span>
		   ${member.name} 
		  </p>
		<p class="text-primary"><span class="color_f63 fb">活动时间：</span>
		   <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd"/>~
		  <fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd"/>
		  </p>
		  <p class="text-primary"><span class="color_f63 fb">活动地点：</span>
		  ${party.address }
		  </p>
		<div class="media-body">
		   <span class="color_f63 fb">活动简介：</span>
		   ${party.description }
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="leading mb20">
			<h2>
				Member of Join
				<a href="<c:url value="/web/leaveMessage" />?partyId=${party.id}"><button class="btn btn-success fr ml20">message</button></a>
				<a href="<c:url value="/member/joinParty" />?partyId=${party.id}"> <button class="btn btn-success fr mb20">Join</button></a>
				
			</h2>
		</div>
		<div class="row-fluid">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>name </th>
							<th>school</th>
							<!-- 
							<th class="tr">View</th>
							 -->
						</tr>
					</thead>
					<tbody>
					<c:if test="${acountInfos!=null }">
					  <c:forEach var="acountInfo" items="${acountInfos }" varStatus="statu">
					     <tr>
							<td><span class="img"> <a 
									href="<c:url value="/viewMemberInfo"/>?memberId=${acountInfo.id}">
										<img width="69" height="43"
										src="<c:url value="${acountInfo.photo }"/>"
										alt="${acountInfo.name }">
								</a>
							</span></td>
							<td>${acountInfo.name }</td>
							<td>${acountInfo.schoolName }</td>
							<!-- 
							<td class="tr"><button class="btn btn-success">View</button></td>
							 -->
						</tr>
					  </c:forEach>
					</c:if>
					</tbody>
				</table>
		</div>


	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
