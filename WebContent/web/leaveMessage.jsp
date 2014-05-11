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
		   ${member.name} <a href="<c:url value="/member/levelMessage" />?partyId=${party.id}">message</a>
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
	   <div class="row">
	   <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>id</th>
            <th>用户Id</th>
            <th>内容</th>
            <th>时间</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${messages!=null }">
            <c:forEach var="message" varStatus="status" items="${messages}">
           <tr>
            <td>${message.messageId }</td>
            <td>
            ${message.messageMemberName }
            </td>
            <td>
             ${message.messageContent }
            </td>
            <td>
             <fmt:formatDate value="${message.messageCreateTime }" pattern="yyyy-MM-dd HH:mm"/>
            </td>
          </tr>
		   </c:forEach>
        </c:if>
         
         
        </tbody>
      </table>
      
      
	   </div>
	   <div class="row">
			<ul class="pager">
			 <c:if test="${isPre==1 }">
				<li class="previous"><a href="<c:url value="/web/leaveMessage"/>?curPage=${curPage-1}&pageSize=12&partyId=${party.id}">&larr; pre</a></li>
			</c:if>
			 <c:if test="${isNext==1 }">	
				<li class="next"><a href="<c:url value="/web/leaveMessage"/>?curPage=${curPage+1}&pageSize=12&partyId=${party.id}">next &rarr;</a></li>
			 </c:if>
			</ul>
		</div>
		<div class="row">
	   <form action="<c:url value="/member/subLeaveMessage"/>" method="post" class="wpcf7-form">
          <div id="output" class="alert"> leave u message</div>
          <input type="hidden" name="partyId" value="${party.id}" />
         
		<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">Message</label>
							</div>
							<div class="col-md-7 controls">
								<textarea  name="message"
									class="form-control" rows="10" required="required"></textarea>
							</div>
		</div>
          
          <div class="row mt20">
			<div class="col-md-7 col-md-offset-2 mt20">
				<button type="submit" class="btn btn-primary">留言</button>
			</div>
		</div>
        </form>
		</div>
	</div>


</div>

