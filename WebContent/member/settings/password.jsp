<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			    <div class="panel-heading">modify password</div>
  <div class="panel-body">      
      <form id="settings-password-form" class="form-horizontal" method="post" action="modifyPassword">
        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_currentPassword" class="required">Current password</label></div>
          <div class="controls col-md-8 controls">
            <input type="password"  name="oldPassword" required="required"  class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_newPassword" class="required">New Password</label></div>
          <div class="controls col-md-8 controls">
            <input type="password"  name="newPassword" required="required" class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_confirmPassword" class="required">Confim Password</label></div>
          <div class="controls col-md-8 controls">
            <input type="password" name="newPassword2" required="required" class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"></div>
          <div class="controls col-md-8 controls">
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
