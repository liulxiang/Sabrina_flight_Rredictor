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
							<th>到达机场</th>
							<th>到达时间</th>
							<th class="tr">实际出发到达时间</th>
						</tr>
					</thead>
					<tbody>
			   <c:if test="${fightVo!= null}">
						<tr>
							<td>
							${fightVo.flightNumber}
							</td>
							<td>
							${fightVo.departureAirportFsCode}
							</td>
							<td>
							${fightVo.departureTerminal}
							</td>
							<td>
							${fightVo.departureTime}
							</td>
							<td>
							 ${fightVo.arrivalAirportFsCode}
							</td>
							<td>
							 ${fightVo.arrivalTime}
							</td>
							<td>
							 ${fightVo.arrivalTerminal}
							</td>
							<td class="tr">
							${fightVo.departing}
							</td>
						</tr>
				</c:if>
					
					</tbody>
				</table>
				
				
				 <c:if test="${fightWeather!= null}">
						<tr>
							<td>
							temperature=${fightWeather.currently.temperature}
							</td>
							<td>
							visibility= ${fightWeather.currently.visibility}
							</td>
							<td>
							windSpeed= ${fightWeather.currently.windSpeed}
							</td>
							<td>
							cloudCover= ${fightWeather.currently.cloudCover}
							</td>
							<td>
							summary= ${fightWeather.currently.summary}
							</td>
							<td class="tr">
							time=${fightWeather.currently.time}
							</td>
						</tr>
				</c:if>
			
		</div>
    </div>
</div>




<script>
$('#tooltip-right').tooltip();
</script>
 