<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>403</title>
	<link href='<spring:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />' ></script>
	<script src='<spring:url value="/resources/js/bootstrap.js" />' ></script>
</head>
<body>
	<div class="container py-5">
		<div class="row">
			<div class="col-md-12">
				<h2>Acesso negado.</h2>
				<p>
					Aceso negado devido políticas de segurança.<br />
					Por favor, volte a tela anterior e continue navegando. 😓
				</p>
				<a class="btn btn-danger" href="javascript:history.back()">Voltar</a>
			</div>
		</div>
	</div>
</body>
</html>