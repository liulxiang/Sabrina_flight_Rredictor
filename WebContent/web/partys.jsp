<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li class="active"><a href="partys">Party</a></li>
			</ul>
		</div>
	</div>
<div class="container">
    <div class="col-md-12">
       <div class="leading">
        <h2>
           </h2>
      </div>
  
      
      
    <div class="row-fluid">
			<ul class="unstyled product-sources">
				
				
			   <c:if test="${partys!= null}">
					<c:forEach var="party" varStatus="status" items="${partys}">
						<li class="product-source"><a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>">
								<span class="img thumbnail"> 
							    <img src="<c:url value="${party.icon}"/>" alt="${party.title}" width="160" height="98"/>
							</span> 
							 <c:if test="${party.state==0 }">
										 <span class="badge badge-success">进行中</span>
							</c:if>
							<c:if test="${party.state==1 }">
								<span class="badge badge-danger">已经结束</span>
							</c:if>
							<span class="name">${party.title}</span> 
							<span class="info">Sum in Party（${party.joinSum}）</span>
						</a>
						</li>
					</c:forEach>
				</c:if>
				
				
			</ul>
		</div>
		<div class="row">
			<ul class="pager">
			    <c:if test="${isPre==1 }">
				<li class="previous"><a href="<c:url value="/web/partys"/>?curPage=${curPage-1}&pageSize=12">&larr; 上一页</a></li>
				</c:if>
				<c:if test="${isNext==1 }">
				<li class="next"><a href="<c:url value="/web/partys"/>?curPage=${curPage+1}&pageSize=12"">下一页 &rarr;</a></li>
				</c:if>
		   </ul>
		</div>


      
    </div>
    

</div>




<script>
$('#tooltip-right').tooltip();
</script>
 