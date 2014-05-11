<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" />
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">View Party</div>
			     <div class="panel-body">
					<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="submitParty">

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">School：</label>
							</div>
							<div class="col-md-7 controls radios">
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${school.name }" readonly="readonly">
							</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Title：</label>
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${party.title }" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Img:</label>
							</div>
							<div class="col-md-7 controls">
								<img alt="" src="<c:url value="${party.icon }"></c:url>">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Start Time</label>
							</div>
							<div class="col-md-7 controls">
                             <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd HH:mm"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">End Time</label>
							</div>
							<div class="col-md-7 controls">
                             <fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd HH:mm"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">Description：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="description"
									class="form-control" rows="10">${party.description}</textarea>
							</div>
						</div>

					
					</form>



				</div>
			</div>
		</div>
	</div>

<script src="<c:url value="/resources/js/bootstrap-datetimepicker.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/locales/bootstrap-datetimepicker.zh-CN.js"/>" type="text/javascript"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	$('#tooltip-right').tooltip();
</script> 

