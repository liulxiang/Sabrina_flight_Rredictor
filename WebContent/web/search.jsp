<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li class="active"><a href="partys">search</a></li>
			</ul>
		</div>
	</div>
<div class="container">
    <div class="col-md-12">
       <div class="leading">
        <h2>搜索结果</h2>
      </div>
    <div class="row">
			<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>航班号</th>
							<th>出发机场</th>
							<th>gate No</th>
							<th>计划出发</th>
							<th>到达</th>
							<th class="tr">实际出发到达时间</th>
						</tr>
					</thead>
					<tbody>
			   <c:if test="${goods!= null}">
					<c:forEach var="good" varStatus="status" items="${goods}">
						<tr>
							<td><span class="img"> <a
									href="<c:url value="/web/goodDetail?goodId=${good.goodId}"/>">
										<img width="69" height="43"
										src="<c:url value="${good.logo}"/>"
										alt="${good.name}">
								</a>
							</span></td>
							<td>
							 <p><h3>
							 
							 <c:if test="${good.statu==0 }">
										 <span class="badge badge-success">销售中</span>
										</c:if>
										<c:if test="${good.statu==1 }">
										  <span class="badge badge-danger">已卖</span>
										</c:if>
							 ${good.name }</h3> 
							 
							 </p>
							 <p>${good.title}</p>
							</td>
							<td class="tr"><span class="badge badge-danger">${good.price }</span>元</td>
						</tr>
						
						
						
					</c:forEach>
				</c:if>
					
					</tbody>
				</table>
		</div>
		<div class="row">
			<ul class="pager">
			    <c:if test="${isPre==1 }">
				<li class="previous"><a href="<c:url value="/web/partys"/>?curPage=${curPage-1}&pageSize=12">&larr; 上一页</a></li>
				</c:if>
				<c:if test="${isNext==1 }">
				<li class="next"><a href="<c:url value="/web/partys"/>?curPage=${curPage+1}&pageSize=12">下一页 &rarr;</a></li>
				</c:if>
		   </ul>
		</div>
    </div>
</div>




<script>
$('#tooltip-right').tooltip();
</script>
 