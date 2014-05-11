<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li class="active"><a href="goods">Good</a></li>
			</ul>
		</div>
	</div>
<div class="container">
	<div class="col-md-3">
      <div class="list-group">
        <a href="<c:url value="/web/goods"/>" class="list-group-item active">Category</a>
        <c:if test="${categorys!=null }">
          <c:forEach var="category" varStatus="status" items="${categorys}">
						 <a href="<c:url value="/web/goods"/>?categoryId=${category.id}" class="list-group-item">${category.name}</a>
		  </c:forEach>
        </c:if>
        
      </div>
    </div>
    <div class="col-md-9 content">
       <div class="leading">
        <h2>Good
        </h2>
      </div>
  
      
      
			<div class="row-fluid">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>title</th>
							<th class="tr">price</th>
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
				<li class="previous"><a href="<c:url value="/web/goods"/>?curPage=${curPage-1}&pageSize=12&categoryId=${categoryId}">&larr; pre</a></li>
			</c:if>
			 <c:if test="${isNext==1 }">	
				<li class="next"><a href="<c:url value="/web/goods"/>?curPage=${curPage+1}&pageSize=12&categoryId=${categoryId}">next &rarr;</a></li>
			 </c:if>
			</ul>
		</div>
    </div>
    

</div>




<script>
$('#tooltip-right').tooltip();
</script>
 