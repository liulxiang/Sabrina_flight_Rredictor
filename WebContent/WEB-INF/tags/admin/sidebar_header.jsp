<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar">
	<a href="#" class="visible-phone"><i class="icon icon-home"></i>
		后台管理系统</a>
	<ul>
		<li class="active"><a href="<c:url value="/admin/index"/>"><i
				class="icon icon-home"></i> <span>后台首页</span></a></li>
		<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>Goods</span> <span class="label">2</span></a>
					<ul>
						<li><a href="<c:url value="/admin/browseGood"/>">Browse Good</a></li>
						<li><a href="<c:url value="/admin/browseCategory"/>">Browse Category</a></li>
					</ul>
	  </li>
		<li><a href="<c:url value="/admin/browseParty"/>"><i class="icon icon-th"></i> <span>Party列表</span></a></li>
		<li><a href="<c:url value="/admin/browseMember"/>"><i class="icon icon-th"></i> <span>会员列表</span></a></li>
	</ul>

</div>
