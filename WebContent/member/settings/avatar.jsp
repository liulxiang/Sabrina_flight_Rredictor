<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-9 content">
	<div class="row">
		<div class="panel panel-default panel-col">
			<div class="panel-heading">头像</div>
			<div class="panel-body">
				<form class="form-horizontal" method="post"
					enctype="multipart/form-data"
					action="<c:url value="/member/settings/modifyPhoto"/>">
					<div class="form-group">
						<div class="col-md-2 control-label">
							<b>当前头像</b>
						</div>
						<div class="controls col-md-8 controls">
							<img src="<c:url value="${acountInfo.photo }"/>" width="120px" height="160px">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-2 control-label">
							<label for="form_avatar" class="required">新头像</label>
						</div>
						<div class="controls col-md-8 controls">
							<input type="file" name="avatar" required="required"
								accept="image/gif,image/jpeg,image/png" />
							<p class="help-block">
								你可以上传JPG、GIF或PNG格式的文件，文件大小不能超过<strong>524.3MB</strong>。
							</p>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-2 control-label"></div>
						<div class="controls col-md-8 controls">
							<button type="submit" class="btn btn-primary">上传</button>
						</div>
					</div>


				</form>
			</div>
		</div>
	</div>
</div>

