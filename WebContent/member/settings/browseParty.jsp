<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<div class="col-md-9 content">
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Partys</div>
			     <div class="panel-body">
					<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>id</th>
            <th>icon</th>
            <th>title</th>
            <th>startTime</th>
            <th>endTime</th>
            <th>join sum</th>
            <th>statu</th>
            <th>manager</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${partys!=null }">
            <c:forEach var="party" varStatus="status" items="${partys}">
           <tr>
            <td>${party.id }</td>
            <td>
             <img alt="${party.title }" src="<c:url value="${party.icon}"></c:url>" width="120px" height="60px">
            </td>
            <td>
            
            ${party.title }
            </td>
            <td>
             <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td><fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${party.joinSum}</td>
            <td> <c:if test="${party.state==0 }">
										进行中
										</c:if>
										<c:if test="${party.state==1 }">
										  已结束
										</c:if></td>
           
            
            <td><a href="deleteParty?partyId=${party.id}">delete</a> 
            <a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>">view</a>
            <a href="<c:url value="overParty?partyId=${party.id}"/>">over</a>
		    <!-- <a href="party?partyId=${party.id}">view</a> -->
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
