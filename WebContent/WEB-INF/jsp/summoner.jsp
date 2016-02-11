<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/style.css"/>" />
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
		<h1 class="media-heading top-20px">${summoner.name}</h1><br>
		
         <div class="panel panel-info row">
            <div class="panel-heading">Ranked Stats</div>
            <div class="panel-body">
               <div class="col-md-3">
                  <div class="text-center">${summoner.rankedDivision.tier} ${summoner.rankedDivision.division}</div>
                  <div class="text-center">
                     <img class="img-division" src="<c:url value="/resources/tier/${summoner.rankedDivision.tier}_${summoner.rankedDivision.division}.png"/>">
                  </div>
               </div>
               <div class="col-md-3">
                  <div class="text-left bottom-10px">${summoner.summaryStats.totalSessionsWon} Wins, ${summoner.summaryStats.totalSessionsLost} Losses</div>
                  <div class="winrate-text text-left bottom-10px">${summoner.summaryStats.winrate}%</div>
                  <div class="text-left bottom-10px">${summoner.summaryStats.totalChampionKills} / ${summoner.summaryStats.totalDeathsPerSession} / ${summoner.summaryStats.totalAssists}</div>
                  <div class="kda-text text-left bottom-10px">${summoner.summaryStats.kda}</div>
               </div>
               <div class="col-md-3">
                  <dl>
                     <dt>Double kill : </dt>
                     <dd>${summoner.summaryStats.totalDoubleKills}</dd>
                     <dt>Triple kill : </dt>
                     <dd>${summoner.summaryStats.totalTripleKills}</dd>
                     <dt>Quadra kill : </dt>
                     <dd>${summoner.summaryStats.totalQuadraKills}</dd>
                     <dt>Penta kill  : </dt>
                     <dd>${summoner.summaryStats.totalPentaKills}</dd>
                  </dl>
               </div>
               <div class="col-md-3">
                  <dl>
                     <dt>First blood : </dt>
                     <dd>${summoner.summaryStats.totalFirstBlood}</dd>
                     <dt>Turret kill : </dt>
                     <dd>${summoner.summaryStats.totalTurretsKilled}</dd>
                     <dt>Living spree : </dt>
                     <dd>${summoner.summaryStats.maxTimeSpentLivingStringFormat}</dd>
                  </dl>
               </div>
            </div>
         </div>
          
         <c:forEach items="${mostPlayedChampions}" var="championMap">
            <div class="panel panel-default row">
               <div class="panel-heading">${championMap.key.name}, <em>${championMap.key.title}</em></div>
               <div class="panel-body">
                  <div class="col-md-3 text-center">
                     <img class="img-champion img-circle" src="http://ddragon.leagueoflegends.com/cdn/6.2.1/img/champion/${championMap.key.image}.png">
                  </div>
                  <div class="col-md-3">
                     <div class="text-left bottom-10px">${championMap.value.totalSessionsWon} Wins, ${championMap.value.totalSessionsLost} Losses</div>
                     <div class="winrate-text left bottom-10px">${championMap.value.winrate}%</div>
                  </div>
                  <div class="col-md-3">
                     <div class="text-left bottom-10px">${championMap.value.averageKills} / ${championMap.value.averageDeaths} / ${championMap.value.averageAssists}</div>
                     <div class="kda-text left bottom-10px">${championMap.value.kda}</div>
                     <div class="text-left bottom-10px">${championMap.value.averageCS} CS</div>
                  </div> 
               </div>
            </div>
         </c:forEach>
         
      </div>
   </body>
</html>

