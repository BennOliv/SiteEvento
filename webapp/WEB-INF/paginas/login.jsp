<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<spring:url value="/loga" var="loga" />
<spring:url value="/carregaRegistro" var="carregaRegistro" />

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
				<c:if test="${ not empty mensagemErro }">
					<div id="divMensagemErro" class="alert alert-danger" role="alert">
						${mensagemErro }</div>
				</c:if>
				<div class="row mt-5">
					<div class="col border-right">
						<h3>Cadastro</h3>
						<hr />
						<p>
							Se ainda não é cadastrado em nosso sistema não perca mais tempo!<br />
							Cadastre-se agora mesmo.<br /><br/>
							<a href="${carregaRegistro}" class="btn btn-primary">Cadastre-se</a>
						</p>
					</div>
					<div class="col">
						<h3>Login</h3>
						<hr />
						<form:form action="${loga}">
							<div class="form-group">
								<label>e-Mail</label><br />
								<input class="w-100" type="email" name="username" id="login" />
							</div>
							<div class="form-group">
								<label>Senha</label><br />
								<input class="w-100" type="password" name="password" id="password" />
							</div>
							<input type="submit" class="btn btn-success" value="logar">
						</form:form>
						<div id="">
							<a class="" href="#">Esqueceu sua senha?</a>
						</div>
						<!-- fazer tela para alterar senha c/ teste para dados (data nascimento)  -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>