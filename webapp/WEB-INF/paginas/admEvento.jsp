<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Eventos</title>
	<link href='<spring:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />'></script>
	<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
	
	<spring:url value="/adm/casaShow/" var="casaShow" />
	<spring:url value="/adm/evento/salva/" var="salva" />
	<spring:url value="/adm/evento/deleta/" var="deleta" />
	<spring:url value="/adm/evento/altera/" var="altera" />
	
</head>
<body>
	<jsp:include page="${request.contextPath}/cabecalho" />
	
		<div class="container mt-5">
		<div class="row">
			<jsp:include page="${request.contextPath}/menuLateral" />
			<div class="col mt-3">
				<h3>Evento</h3>
				<hr />
				<form:form action="${salva}" modelAttribute="evento">
					<form:hidden path="id" />
					<div class="form-group">
						<label>Nome</label>
						<input type="text" maxlength="20" class="form-control" name="nome" value="${evento.nome}" />
					</div>
					<div class="form-group">
						<label>Descrição</label>
						<textarea rows="3" name="descricao" maxlength="255" value="${evento.descricao}" class="form-control"></textarea>
					</div>
					<div class="form-group">
						<label>Imagem</label>
						<div class="custom-file">
							<input type="file" name="imagem" class="custom-file-input"
								value="${imagemEvento}" /> <label
								class="custom-file-label">Escolha uma imagem</label>
						</div>
					</div>
					<c:if test="${not empty casas}">
						<div class="form-group">
							<label>Casa de Show</label>
							<select class="form-control" id="selCasa" name="casaShow">
								<c:forEach var="casa" items="${casas}">
									<option var="${casa}">${casa.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label>Ingressos Comuns</label>
										<input type="number" min="0" max="" class="form-control"
											name="capacidadeComum" />
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>Ingressos VIP</label>
										<input type="number" min="0" max="" class="form-control"
											name="capacidadeVip" />
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${empty casas}">
						<label class="txt-danger">Não há registro de casas de
							eventos no sistema.<br /> <a href="${casaShow}">Cadastre
								aqui</a>
						</label>
					</c:if>
					<div class="form-group">
						<label>Data</label>
						<input type="date" class="form-control" name="data" value="${evento.data}" />
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Horário Abertura</label><br /> <input type="time"
									name="horarioAbertura" />
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label>Horário Encerramento</label><br /> <input type="time"
									name="horarioEncerramento" />
							</div>
						</div>
					</div>
					<c:if test="${not empty casas}">
						<input type="submit" class="btn btn-primary" value="Salva" />
					</c:if>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>