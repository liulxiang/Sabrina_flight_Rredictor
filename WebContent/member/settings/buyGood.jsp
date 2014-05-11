<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">buy Good</div>
			     <div class="panel-body">
					<form  class="form-horizontal"  method="post" action="buyGood">
					    <input type="hidden" name="goodId" value="${goodId}">

						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Buyer Name：</label>
							<div class="col-md-7 controls">
								<input type="text" 
									name="buyerName" class="form-control" required="required"/>
							</div>
						</div>
						<div class="row">
							<div class="col-md-7 col-md-offset-2">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

