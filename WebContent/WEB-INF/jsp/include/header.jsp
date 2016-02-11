<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <nav class="navbar navbar-default ">
         <div class="container-fluid">
            <ul class="nav navbar-nav navbar-default ">
               <li class="active"><a href="<c:url value="/"/>">Home</a></li>
               <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Members<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/summoners/search?username=gwoschefbandit"/>">Gwos chef bandit</a></li>
                        <li><a href="<c:url value="/summoners/search?username=johnyxu"/>">JohnyXu</a></li>
                        <li><a href="<c:url value="/summoners/search?username=sirethundar"/>">sireThundar</a></li>
                        <li><a href="<c:url value="/summoners/search?username=chaosson"/>">Chaosson</a></li>
                        <li><a href="<c:url value="/summoners/search?username=cptbranlomanche"/>">Cpt Branlomanche</a></li>
                        <li><a href="<c:url value="/summoners/search?username=kpuc"/>">Kpuc</a></li>
                        <li><a href="<c:url value="/summoners/search?username=gashyr"/>">Gashyr</a></li>
                        <li><a href="<c:url value="/summoners/search?username=lemalfrat"/>">Le Malfrat</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="https://www.youtube.com/watch?v=d9Vs6q_7ug0">Josélito Michaud</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/ranking/winrateStanding"/>">Team standing</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-default ">
                <form class="navbar-form navbar-left navbar-default "  action="<c:url value="/summoners/search"/>" method="get">
                    <div class="form-group has-feedback">
                        <input name="username" type="text" class="form-control" placeholder="Summoner's name" />
                        <i class="glyphicon glyphicon-user form-control-feedback"></i>
                    </div>
                </form>
                <li><a href="<c:url value="/aboutUs"/>">About us</a></li>
               
            </ul>
         </div>
      </nav>
      <div class="page-header">
		 <h1>Example Page Header</h1>
	 </div>