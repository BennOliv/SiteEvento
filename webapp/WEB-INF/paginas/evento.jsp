<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${evento.nome}</title>
	<link href='<spring:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />'></script>
	<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
	<jsp:include page="${request.contextPath}/cabecalho" />
	<div class="container mt-5">
		<div class="row">
			<jsp:include page="${request.contextPath}/menuLateral" />
			<div class="col mt-3">
				<h3>${evento.nome}</h3>
				<hr />
				<div class="row">
					<div class="col-md-auto">
						<img src="data:image/jpge;base64,${evento.imagemEvento}">
					</div>
					<div class="col-tg">
						<div class="row">
							<div class="col"><p>${evento.descricao}</p></div>
						</div>
						<div class="row align-items-end">
								<form:form class="form-inline" action="compra" modelAttribute="itemVenda">
									<div class="form-group">
										<label for="select">Selecione a quantidade de ingressos</label>
										<select class="form-control" id="exampleFormControlSelect1">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
										</select>
									</div>
									<div class="form-group">
										<security:authorize access="!isAuthenticated()">
											<form:button type="submit" class="btn btn-outline-info disable" data-toggle="tooltip" data-placement="top" title="Para realizar uma compra você precisa estar logado">Adicionar ao carrinho</form:button>
										</security:authorize>
										<security:authorize access="isAuthenticated()">
											<form:button type="submit" class="btn btn-prymary bg-info" >Adicionar ao carrinho</form:button>
										</security:authorize>
									</div>
								</form:form>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>