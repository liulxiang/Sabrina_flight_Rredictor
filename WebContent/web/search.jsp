<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li class="active"><a href="partys">search</a></li>
			</ul>
		</div>
	</div>
<div class="container">
    <div class="col-md-12">
       <div class="leading">
        <h2>搜索结果</h2>
      </div>
    <div class="row">
			<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>航班号</th>
							<th>出发机场</th>
							<th>gate No</th>
							<th>计划出发</th>
							<th>到达</th>
							<th class="tr">实际出发到达时间</th>
						</tr>
					</thead>
					<tbody>
			   <c:if test="${fightWeather!= null}">
						<tr>
							<td>
							${fightWeather.currently.temperature}
							</td>
							<td>
							 ${fightWeather.currently.visibility}
							</td>
							<td>
							 ${fightWeather.currently.windSpeed}
							</td>
							<td>
							 ${fightWeather.currently.cloudCover}
							</td>
							<td>
							 ${fightWeather.currently.summary}
							</td>
							<td class="tr">
							${fightWeather.currently.time}
							</td>
						</tr>
				</c:if>
					
					</tbody>
				</table>
		</div>
    </div>
</div>




<script>
$('#tooltip-right').tooltip();
</script>
 