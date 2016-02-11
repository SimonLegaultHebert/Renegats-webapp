<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link type="text/css" rel="stylesheet" href="
      <c:url value="/resources/style/style.css"/>
      " />
      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
      <!-- jQuery library -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
      <!-- Latest compiled JavaScript -->
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   </head>
   
   <body> 
      <jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
      
      <div class="container">
      		<ul class="nav nav-tabs">
			  <li class="active"><a href="<c:url value="/ranking/winrateStanding"/>">Winrate</a></li>
			  <li><a href="<c:url value="/ranking/KDAStanding"/>">KDA</a></li>
			</ul>
      		<table class="table table-vcenter">
    			<thead>
				      <tr>
				        <th></th>
						<th class="text-center">Wins</th>
						<th class="text-center">Losses</th>
						<th class="text-center">Winrate</th>
				      </tr>
    			</thead>
    			<tbody>
    				<c:forEach items="${teamList}" var="summoner">
				      <tr>
				        <td><img class="img-icon img-circle" src="http://ddragon.leagueoflegends.com/cdn/6.2.1/img/profileicon/${summoner.profileIconId}.png"><span class="left-10px">${summoner.name}</span></td>
						<td class="text-center">${summoner.summaryStats.totalSessionsWon}</td>
						<td class="text-center">${summoner.summaryStats.totalSessionsLost}</td>
						<td class="text-center winrate-text">${summoner.summaryStats.winrate}%</td>
				      </tr>
			   		</c:forEach>			 
    			</tbody>
  			</table>	
      </div>
   </body>
</html>