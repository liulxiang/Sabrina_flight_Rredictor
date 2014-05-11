<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
</head>
<body>

<div class="container">
<div class="mt40">dddd</div>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p>${size}</p>
<div class="pg">
    
    <c:if test="${showPage.totalPage>0}">
    
        <ul class="pagination pagination-lg">
        
        <c:if test="${showPage.currentPage!=1}">
            <li><a href="/pages?page=${showPage.prePage }">«</a></li>
        </c:if>
        
        <c:forEach begin="${showPage.pageNumStart }" end="${showPage.pageNumEnd }" var="pageIndex">
            <c:if test="${showPage.currentPage>pageIndex }">
                <li><a href="/pages?page=${pageIndex }">${pageIndex }</a></li>
            </c:if>
            <c:if test="${showPage.currentPage==pageIndex }">
                <li><a >${pageIndex }</a></li>
            </c:if>
            <c:if test="${showPage.currentPage<pageIndex }">
              <li><a href="/pages?page=${pageIndex }">${pageIndex }</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${showPage.currentPage!=showPage.totalPage}">
            <li><a href="/pages?page=${showPage.nextPage }">»</a></li>
        </c:if>
        </ul>
    </c:if>
    
    
    
</div>
 </div>  
</body>
</html>
