<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Casa de Show</title>
	<link href='<spring:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />'></script>
	<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
	
	<spring:url value="/adm/casaShow/salva/" var="salva" />
	<spring:url value="/adm/casaShow/deleta/" var="deleta" />
	<spring:url value="/adm/casaShow/altera/" var="altera" />
	
</head>
<body>
	<jsp:include page="${request.contextPath}/cabecalho" />

	<div class="container mt-5">
		<div class="row">
			<jsp:include page="${request.contextPath}/menuLateral" />
			<div class="col mt-3">
				<c:if test="${not empty mensagemErro}">
					<div id="divMensagemErro" class="alert alert-danger" role="alert">
						${mensagemErro}</div>
				</c:if>
				<h3>Casa de Show</h3>
				<hr />
				<form:form action="${salva}" modelAttribute="casaShow">
					<form:hidden path="id" />
					<div class="form-group">
						<label>Nome</label>
						<input type="text" maxlength="50" class="form-control" name="nome" value="${casaShow.nome}" />
					</div>
					<div class="form-group">
						<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Capacidade Comum</label>
								<input type="number" class="form-control" name="capacidadeComum" value="${casaShow.capacidadeComum}" />
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label>Capacidae VIP</label>
								<input type="number" class="form-control" name="capacidadeVip" value="${casaShow.capacidadeVip}" />
							</div>
						</div>
					</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Endereço</label> <input type="text" class="form-control"
									maxlength="255" name="logradouro" value="${casaShow.logradouro}" />
							</div>
						</div>
						<div class="col col-lg-2">
							<div class="form-group">
								<label>Nº</label> <input type="text" class="form-control"
									maxlength="10" name="numero" value="${casaShow.numero}" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Cidade</label> <input type="text" class="form-control"
									maxlength="30" name="cidade" value="${casaShow.cidade}" />
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label>Estado</label> 
								<select class="form-control" id="estado" name="estado">
									<option>Acre</option>
									<option>Alagoas</option>
									<option>Amapá</option>
									<option>Amazonas</option>
									<option>Bahia</option>
									<option>Ceará</option>
									<option>Distrito Federal</option>
									<option>Espírito Santo</option>
									<option>Goiás</option>
									<option>Maranhão</option>
									<option>Mato Grosso</option>
									<option>Mato Grosso do Sul</option>
									<option>Minas Gerais</option>
									<option>Pará</option>
									<option>Paraíba</option>
									<option>Paraná</option>
									<option>Pernambuco</option>
									<option>Piauí</option>
									<option>Rio de Janeiro</option>
									<option>Rio Grande do Norte</option>
									<option>Rio Grande do Sul</option>
									<option>Rondônia</option>
									<option>Roraima</option>
									<option>Santa Catarina</option>
									<option>São Paulo</option>
									<option>Sergipe</option>
									<option>Tocatins</option>
								</select>
							</div>
						</div>
					</div>
					<input type="submit" class="btn btn-primary" name="salva"
						value="${casaShow.id eq 0 ? 'Cadastrar' : 'Alterar'}" />

					<c:if test="${casaShow.id ne 0}">
						<input type="submit" class="btn btn-warning" name="cancela"	value="Cancelar" />
					</c:if>
				</form:form>
				<hr />
				<h4>Casas de Show cadastradas</h4><br />
				<c:if test="${not empty casas}">
					<table class="table table-striped mt-3">
						<thead class="thead-light">
							<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome</th>
								<th scope="col">Capacidade Comum</th>
								<th scope="col">Capacidade VIP</th>
								<th scope="col">Endereço</th>
								<th scope="col">Cidade</th>
								<th scope="col">Estado</th>
								<th class="text-center" scope="col" colspan="2">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="casaShow" items="${casas}">
								<tr>
									<td>${casaShow.id}</td>
									<td>${casaShow.nome}</td>
									<td>${casaShow.capacidadeComum}</td>
									<td>${casaShow.capacidadeVip}</td>
									<td>${casaShow.logradouro}, ${casaShow.numero}</td>
									<td>${casaShow.cidade}</td>
									<td>${casaShow.estado}</td>
									<td><a href="${altera}${casaShow.id}"
										class="btn btn-outline-warning">Alterar</a></td>
									<td><a href="${deleta}${casaShow.id}"
										class="btn btn-outline-danger"
										onclick="return confirm('Deseja deletar esse produto?');">Deletar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
		});
	</script>
</body>
</html>