<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Compra</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.0.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
	<jsp:include page="${request.contextPath}/cabecalho" />

	<div class="container mt-5">
		<div class="row">
			<jsp:include page="${request.contextPath}/menuLateral" />
			<div class="col mt-3"></div>

		</div>
	</div>
</body>
</html>