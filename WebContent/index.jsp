<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/index-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/index-scrollpic.css"/>" />

<div class="first-row">
    <div class="col-lg-12">
      <div id="carousel-example-generic" class="carousel slide">
        <div class="carousel-inner">
          <div class="item active">
            <img src="resources/img/hero.jpg" alt="">
            <div class="carousel-caption">
            <div class="col-md-8">
					<form  class="form-horizontal" method="post" action="<c:url value="/web/search"/>">

						<div class="form-group">
							<label class="col-md-2 control-label">选择类型：</label>
							<div class="col-md-7 controls">
							   <span class="mr30">
								<input type="radio"
									name="flightType"  value="1" checked="checked" />By flight no
							    </span>
							    <span class="ml30">
								<input type="radio"
									name="flightType"  value="2"/> By Route
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">AirLine：</label>
							<div class="col-md-7 controls">
								<input type="text"
									name="airLine" class="form-control" value="American" required="required"/>
							</div>
						</div>

			
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Number：</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" 
									class="form-control" value="59" required="required"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Date：</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="date"
									class="form-control" value="2014-05-08" required="required"/>
							</div>
						</div>
						

						<div class="row">
							<div class="col-md-7 col-md-offset-2">
								<button type="submit" class="btn btn-primary">Search</button>
							</div>
						</div>

					</form>


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




<div class="mt90" style="padding-top: 20px;">
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
  
