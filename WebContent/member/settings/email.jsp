<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
				<div class="panel-heading">set email</div>
				<div class="panel-body">
					<form id="setting-email-form" class="form-horizontal" method="post" action="modifyEmail">


						<div class="form-group">
							<div class="col-md-2 control-label">
								<label>current mail</label>
							</div>
							<div class="col-md-8 controls">
								<c:if test="${sessionScope.UserConstant_VISITOR != null}">
								  <input type="text"  class="form-control"  value="${sessionScope.UserConstant_VISITOR.email}" readonly="readonly"/>
				                 </c:if>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="form_password" class="required">login password</label>
							</div>
							<div class="col-md-8 controls">
								<input type="password" name="password"
									required="required" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="form_email" class="required">new email</label>
							</div>
							<div class="col-md-8 controls">
								<input type="text"  name="newEmail"
									required="required" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label"></div>
							<div class="col-md-8 controls">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
	</div>






<script>
	$('#tooltip-right').tooltip();
</script>
