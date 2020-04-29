<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Clientes</title>

<spring:url value="/registra" var="registra" />

<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>

</head>
<body>
	<jsp:include page="${request.contextPath}/cabecalho" />

	<div class="container mt-5">
		<div class="row">
			<jsp:include page="${request.contextPath}/menuLateral" />
			<div class="col mt-3">
				<c:if test="${ not empty mensagemErro }">
					<div id="divMensagemErro" class="alert alert-danger" role="alert">
						${mensagemErro }</div>
				</c:if>
				<div class="row mt-5">
					<h3>Novo Usuário</h3>
				</div>
				<form:form action="${registra}" modelAttribute="usuario">
					<div class="form-group">
						<label>Nome</label> <input type="nome" class="form-control"
							name="nome" value="${usuario.nome}" />
					</div>
					<div class="form-group">
						<label>E-mail</label> <input type="email" class="form-control"
							name="email" value="${usuario.email}" />
					</div>
					<div class="form-group">
						<label>Senha</label> <input type="text" class="form-control"
							maxlength="20" name="senha" value="${usuario.senha}" />
					</div>
					<div class="form-group">
						<label>CPF</label> <input type="text" class="form-control"
							name="cpf" value="${usuario.cpf}" />
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Endereço</label> <input type="text" class="form-control"
									maxlength="255" name="logradouro" value="${usuario.logradouro}" />
							</div>
						</div>
						<div class="col col-lg-2">
							<div class="form-group">
								<label>Nº</label> <input type="text" class="form-control"
									maxlength="10" name="numero" value="${usuario.numero}" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Cidade</label> <input type="text" class="form-control"
									maxlength="30" name="cidade" value="${usuario.cidade}" />
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label>Estado</label> 
								<select class="form-control" id="estado" name="estado" name="${usuario.estado}">
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
					<div class="form-group">
						<label>Data de Nascimento</label><br />
						<input type="date" class="for-control" name="dataNascimento" value="${usuario.dataNascimento }" />
					</div>
					<br />
					<input type="submit" class="btn btn-success" value="Cadastrar" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>