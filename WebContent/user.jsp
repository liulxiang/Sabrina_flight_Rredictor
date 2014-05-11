<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/user.css"/>" />
<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>Home</a></li>
			<li class="active"><a href="<c:url value="/viewMemberInfo"/>?memberId=${member.memberId}">Member Info</a></li>
		</ul>
	</div>
</div>
<div class="container">
	
<div class="es-row-wrap  container-gap userpage-header">
  <div class="row">
    <div class="col-md-3">
      <img class="avatar" src="<c:url value="${acountInfos.photo }"/>">
      <div class="userpage-header-info">
          <h1>${acountInfos.name }</h1>
         <div class="tags">
			<em class="S_txt2">发布商品数：</em>
			<a href="" title="${acountInfos.successSum}">${acountInfos.successSum}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">积分：</em>
			<a href="" title="${acountInfos.points }">${acountInfos.points }</a>
		</div>
		<div class="tags">
			<em class="S_txt2">学校：</em>
			<a href="" title="${acountInfos.schoolName }">${acountInfos.schoolName }</a>
		</div>
		<div class="tags">
			<em class="S_txt2">专业：</em><a href="" title="${acountInfos.major}">${acountInfos.major}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">失约次数：</em><a href="" title="${acountInfos.reputation}">${acountInfos.reputation}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">组织活动次数：</em><a href="" title="${acountInfos.partyCreateSum}">${acountInfos.partyCreateSum}</a>
		</div>
		<div class="tags">
			<em class="S_txt2">参加组织活动次数：</em><a href="" title="${acountInfos.partyJoinSum}">${acountInfos.partyJoinSum}</a>
		</div>
      </div>
      
    </div>
    
	<div class="col-md-9">
	   <section id="about-us">
          <div class="page-header">
            <h1>关于${acountInfos.name }</h1>
          </div>
          <p class="lead about">
             ${acountInfos.description }
        </section>
	   <section id="parties">
          <div class="page-header">
            <h1>我组织的活动</h1>
          </div>
          <p class="lead">
          <ul class="unstyled product-sources">
              <c:if test="${partys!= null}">
					<c:forEach var="party" varStatus="status" items="${partys}">
						<li class="product-source"><a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>">
								<span class="img thumbnail"> 
							    <img src="<c:url value="${party.icon}"/>" alt="${party.title}" width="160" height="98"/>
							</span> <span class="name">${party.title}</span> <span class="info">Sum in Party（${party.joinSum}）</span>
						</a>
						</li>
					</c:forEach>
				</c:if>
		</ul>
        </section>
         <section id="goods">
          <div class="page-header">
            <h1>good</h1>
          </div>
          <p class="lead">
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
							 <p><h3>${good.name }</h3></p>
							 <p>${good.title}</p>
							</td>
							<td class="tr"><span class="badge badge-danger">${good.price }</span>元</td>
						</tr>
						
						
						
					</c:forEach>
				</c:if>
					
					</tbody>
				</table>
        </section>
   </div>
</div>
</div>
</div>

