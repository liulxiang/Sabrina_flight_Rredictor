<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Base infomation</div>
			     <div class="panel-body">
					<form id="user-profile-form" class="form-horizontal" method="post" action="modifyMemberInfo">

						<div class="form-group">
							<label class="col-md-2 control-label">photo</label>
							<div class="col-md-7 controls">
								<img src="<c:url value="${member.photo}"/>" alt="${party.title}"  width="180px" height="240px"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Nick Name</label>
							<div class="col-md-7 controls">
								<input type="text"
									name="username" class="form-control" value="${member.name }" required="required"/>
							</div>
						</div>

			
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">School</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" 
									class="form-control" value="${v.schoolName }" readonly="readonly"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Major</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="major"
									class="form-control" value="${member.major }" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">phone</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="phone"
									class="form-control" value="${member.phone }" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">email</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" 
									class="form-control" value="${member.email }" readonly="readonly"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">Introduce</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="description"
									class="form-control" rows="20" required="required">${member.description }</textarea>
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

<script>
	$('#tooltip-right').tooltip();
</script>
