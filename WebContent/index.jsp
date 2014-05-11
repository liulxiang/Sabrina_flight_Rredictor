<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/index-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/index-scrollpic.css"/>" />

<div class="row first-row">
    <div class="col-lg-12">
      <div id="carousel-example-generic" class="carousel slide">
        <!-- Indicators //-->
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <img src="resources/img/hero.jpg" alt="">
            <div class="carousel-caption">
            <div class="col-md-6">
              <div class="row">
				<h1>Buy and Sell Gift Cards on Raise</h1>
				<p class="lead tl">Turn unused gift cards into cash and shop for discounted gift cards on our marketplace.</p>
				</div>
              <a href="<c:url value="/preRegister"/>" class="btn btn-xlarge btn-primary">Join Whoopes</a>
              </div>
              </div>
          </div>
        </div>
      </div><!-- carousel end //-->
    </div>
    
  </div>
  
<script>
$('.carousel').carousel();
</script>




<div class="row mt90" style="padding-top: 20px;">
  <div class="container">
		<c:if test="${partys!= null}">
			<c:forEach var="party" varStatus="status" items="${partys}">
				<div class="col-lg-3">
					<div class="thumbnail">
						<img src="<c:url value="${party.icon}"/>" alt="${party.title}" />
						<div class="caption">
							<h3>${party.title}</h3>
							<p>${party.description}</p>
							<p>
							 <a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>" class="btn btn-primary">detail</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
  </div>
  
