<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="fr.gtm.proxibanquesi.domaine.Conseiller, fr.gtm.proxibanquesi.domaine.Client, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/styles.css">
<script src="jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<title>ProxiBanque SI</title>
</head>

<body class="bg_img">

	<%
		Conseiller user = (Conseiller) session.getAttribute("user");
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", new String(""));
		}

		ArrayList<Client> listeClients = (ArrayList<Client>) session.getAttribute("clients");
		pageContext.setAttribute("listeClients", listeClients);
	%>

	<div class="container-fluid">

		<div id="frontHead" class="page-header">
			<h1 class="text-center">ProxiBanqueSI</h1>
			<p class="text-center">Bienvenue sur ProxiBanque SI.</p>
			<p class="text-left">
				Bonjour
				<c:out value="${user.prenom}"></c:out>
			<p>
		</div>

		<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="user-page.jsp">Home</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Opération courante <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="GClientNew.jsp">creation client</a></li>
            <li><a href="GClientModif.jsp">information client</a></li>
            <li><a href="GCompte.jsp">creation compte</a></li>
            <li><a href="virement.jsp">virement</a></li>
          </ul>
        </li>
        <li class="dropdown"><a href="pasMethode.jsp">Placement </a>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Crédit<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="pasMethode.jsp">consommation</a></li>
            <li><a href="pasMethode.jsp">immobilier</a></li>
          </ul>
        <li class="dropdown"><a href="pasMethode.jsp">Audit <span ></span></a>
        </li>
        </li>
      </ul>
    </div>
  </div>
</nav>
		
		<div class=row>
			<div class="col-sm-8">
				</div>
			<div class="col-sm-4 maClasse">
				<table class="table table-bordered">
					<caption class="text-center">Liste des clients</caption>
					<tr class="active">
						<th>ID</th>
						<th>Nom</th>
						<th>Prenom</th>
					</tr>
					<c:forEach items="${listeClients}" var="current">
						<tr>
							<td><c:out value="${current.id}" /></td>
							<td><c:out value="${current.nom}" /></td>
							<td><c:out value="${current.prenom}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>Confirmer la suppression du compte utilisateur.</p>
					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<p id="message" class="text-center"><%=request.getAttribute("message")%></p>
		</div>

		<div class="bottom">
			<a href="accueil.jsp"> <img width="40" src="accueil.png">
			</a>
		</div>
	</div>


</body>
</html>