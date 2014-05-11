<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-9 content">
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Information</div>
			     <div class="panel-body">
					<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>Logo</th>
            <th>name</th>
            <th>title</th>
            <th>price</th>
            <th>level</th>
            <th>buy statu</th>
            <th>manager</th>
          </tr>
        </thead>
        <tbody>
							
							<c:if test="${goods!=null }">
								<c:forEach var="good" varStatus="status"
									items="${goods}">
									<tr>
										<td>${good.goodId }</td>
										<td>${good.name }</td>
										<td>${good.title }</td>
										<td>${good.price }</td>
										<td>${good.level }</td>
										<td>
										<c:if test="${good.statu==0 }">
										 拍卖中
										</c:if>
										<c:if test="${good.statu==1 }">
										  已买
										</c:if>
										
										
										</td>
										<td><a href="deleteGood?goodId=${good.goodId }">delete</a> 
										<a href="<c:url value="/web/goodDetail?goodId=${good.goodId}"/>">view</a>
										<a href="<c:url value="/member/settings/preBuyGood?goodId=${good.goodId}"/>">sold</a>
										<!-- <a href="addGood?goodId=${good.goodId}">view</a> -->
										
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






<script>
	$('#tooltip-right').tooltip();
</script>
