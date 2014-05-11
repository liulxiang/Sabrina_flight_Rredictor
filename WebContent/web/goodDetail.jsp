<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano-detail.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/contact.css"/>" />
<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li class="active"><a href="goods">Good</a></li>
			</ul>
		</div>
	</div>
  <div class="container">
   <div class="work" >
    <div class="row">
      <div class="col-md-4">
         <c:if test="${member!=null }">
         <h5> Sale Name </h5>
        <p>${member.name }</p>
         </c:if>
         <c:if test="${good.buyerName!=null }">
         <h5>Buyer Name </h5>
        <p>${good.buyerName }</p>
         </c:if>
        <h5>Good Name </h5>
        <p>${good.name }</p>
        <h5>Good Price </h5>
        <p>${good.price}</p>
        <h5>About Good</h5>
        <p>${good.description } </p>
        <h5>Add time:</h5>
        <p>${good.createTime }</p>
        <div id="output" class="alert">contact</div>
	     <c:if test="${goodComments!=null}">
	       <c:forEach items="${goodComments }" var="goodComment">
	       <div class="media">
	        <div class="media-body">
	          <h4 class="media-heading">
                <a 
					href="<c:url value="/viewMemberInfo"/>?memberId=${goodComment.memberId}">
						${goodComment.memberName}
				</a>
	          </h4>
	           Phone:
	           ${goodComment.phone }
	           <br/>
	           Message:
	            ${goodComment.content}
	            
	           <br/>
	           <c:if test="${isManager==0}">
	             Reply:
	              <c:if test="${goodComment.isReply==1}">
	                ${goodComment.replyContent}
	              </c:if>
	           </c:if>
	           <c:if test="${isManager==1}">
                Reply:
                   ${goodComment.replyContent}
                <br/>
                <c:if test="${goodComment.goodCommentSubs!=null }">
                    <c:forEach items="${goodComment.goodCommentSubs}" var="goodCommentSub">
                       <a 
					href="<c:url value="/viewMemberInfo"/>?memberId=${goodCommentSub.memberId}">
						${goodCommentSub.memberName}
				</a>
                       :${goodCommentSub.content}
                        <br/>
                    </c:forEach>
                </c:if>
	          <br/>      
	        <a href="#replyModal${goodComment.id}" data-toggle="modal" class="btn btn-primary">Reply</a>
	              <!-- Modal -->
<div class="modal fade" id="replyModal${goodComment.id}" tabindex="-1" role="dialog" aria-labelledby="replyModal${goodComment.id}" aria-hidden="true">
 		<div class="modal-dialog panel-primary">
          <div class="modal-content">
            <div class="modal-header panel-heading">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">reply：</h4>
            </div>
            <form class="form-horizontal" action="<c:url value="/web/replyContent"/>">
				<div class="modal-body">
					<input type="hidden" value="${goodComment.id}" name="commentId">
					<div class="form-group">
						<label class="col-lg-2 control-label">replyContent：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" name="replyContent"
								placeholder="replyContent"  required="required"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
	              <button type="button" class="btn btn-default " data-dismiss="modal">cancel</button>
	              <button type="submit" class="btn btn-primary" >submit</button>
            	</div>
          </form>   
            
            
          </div><!-- /.modal-content //-->
        </div><!-- /.modal-dialog //-->
</div><!-- /.modal -->


	           </c:if>
	          
	        </div>
	      </div>
	    </c:forEach>
      </c:if>  
      </div>
      <div class="col-md-8">
        <ul class="portfolio_showcase">
          <li> <img src="<c:url value="${good.logo}"/>" alt="Image" style="height: 400px;width: 750px"/></li>
          <c:forEach var="pic" items="${goodPics}" varStatus="statu">
            <li> <img src="<c:url value="${pic.path}"/>" alt="Image" style="height: 400px;width: 750px"/></li>
          </c:forEach>
        </ul>
        <div id="number" class="work-pagination"> </div>
        
        <div class="row contact">
      <div class="wpcf7 mt20">
        <form action="<c:url value="/member/addGoodMessage"/>" method="post" class="wpcf7-form">
          <div id="output" class="alert"> leave u contact</div>
           <div class="form-meta clearfix">
            <div class="formcol">
              <label for="fname">contact phone</label>
              <input type="text" name="phone" value="" size="40"  required="required"/>
            </div>
            </div>
          <input type="hidden" name="goodId" value="${good.goodId}" />
          <label for="message"> Message：</label>
          <textarea name="message" id="message" cols="40" rows="10" required="required"></textarea>
          <input type="submit" id="send-message" value="Send" class="btn btn-success mt20 mb20" />
        </form>
      </div>
      </div>
      </div>
    </div>
</div>
  
  
  
  <div class="row contact">
  
    <div class="col-md-8 fr">
      
    </div>
  </div>
</div>



<script src="../resources/web/js/jquery.prettyPhoto.js" type="text/javascript"></script> 
<script src="../resources/web/js/superfish.js" type="text/javascript"></script> 
<script src="../resources/web/js/jquery.isotope.min.js" type="text/javascript"></script> 
<script src="../resources/web/js/detail.js" type="text/javascript"></script>


