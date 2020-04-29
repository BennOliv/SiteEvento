<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Projeto Eventos</title>
	<link href='<spring:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />'></script>
	<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
	<spring:url value="/evento/" var="eventourl" />
</head>
<body>
	<jsp:include page="${request.contextPath}/cabecalho" />
	<div class="container mt-5">
		<div class="row">
			<jsp:include page="${request.contextPath}/menuLateral" />

			<div class="col mt-3">
				<h3 class="mt-5">Eventos em <b>Hype</b></h3>
				<hr />
				<c:if test="${not empty eventos}">
					<div id="carroselHype" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carroselHype" data-slide-to="0" class="active"></li>
							<li data-target="#carroselHype" data-slide-to="1" class=""></li>
							<li data-target="#carroselHype" data-slide-to="2" class=""></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block w-100"
									alt="First slide [800x400]" src="data:image/jpge;base64,${eventosTop[0].imagemEncoded}"
									data-holder-rendered="true">
								<div class="carousel-caption d-none d-md-block">
									<h5>${eventos[0].nome}</h5>
									<p>${eventos[0].descricao}</p>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100"
									alt="Second slide [800x400]" src="data:image/jpge;base64,${eventosTop[1].imagemEncoded}"
									data-holder-rendered="true">
								<div class="carousel-caption d-none d-md-block">
									<h5>${eventos[1].nome}</h5>
									<p>${eventos[1].descricao}</p>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100"
									alt="Third slide [800x400]" src="data:image/jpge;base64,${eventosTop[2].imagemEncoded}"
									data-holder-rendered="true">
								<div class="carousel-caption d-none d-md-block">
									<h5>${eventos[2].nome}</h5>
									<p>${eventos[2].descricao}</p>
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carroselHype"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Anterior</span>
						</a> <a class="carousel-control-next" href="#carroselHype"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Próximo</span>
						</a>
					</div>
				</c:if>
				
				<h3 class="mt-2">Eventos Ativos</h3>
				<hr />
					<c:if test="${not empty eventos}">
					<div class="row">
						<c:forEach var="evento" items="${eventos}">
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="card h-100">
									<a href="#"><img class="card-img-top"
										src="data:image/jpge;base64,${evento.imagemEncoded}" alt=""></a>
									<div class="card-body">
										<h4 class="card-title">
											<a href="${eventourl}${evento.id}">${evento.nome}</a>
										</h4>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					</c:if>
			</div>
		</div>
	</div>
</body>
</html>