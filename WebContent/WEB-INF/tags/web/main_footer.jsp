<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/nav-footer.css"/>" />

<div class="bottom_box footer" id="footer">
	<div class="bottom container">
		<div class="bottom_right">
			<p>Copyright ©2013-2017 All Rights Reserved</p>
		</div>
	</div>
</div>




<script src="<c:url value="/resources/js/jquery.ez-pinned-footer.js"/>" type="text/javascript"></script>
<script type="text/javascript">
$(window).bind("load", function() { 
	$("#footer").pinFooter("relative");
});

$(document).ready(function(){
	//$("#footer").pinFooter("relative");
	});
$(window).resize(function() {
     $("#footer").pinFooter("relative");
});
</script>

 
<!-- chuancheng.cn Baidu tongji analytics 
<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F58e671f2084760268b6201eca4f6aa98' type='text/javascript'%3E%3C/script%3E"));
</script>
-->