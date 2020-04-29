<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="/adm/casaShow" var="casaShow"/>
<spring:url value="/adm/evento" var="evento"/>
<spring:url value="/" var="home" />

<div class="col-lg-3 mt-5">
		<div class="list-group">
			<a href="${home}" class="list-group-item">Home</a>
		</div>
	<security:authorize access="hasRole('USER')">
		<div class="list-group">
			<a class="list-group-item" href="${usuario}">Meus Ingressos</a>
		</div>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<div class="list-group">
			<a class="list-group-item" href="${evento}">Eventos</a>
		</div>	
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<div class="list-group">
			<a class="list-group-item" href="${casaShow}">Casas de Show</a>
		</div>	
	</security:authorize>
</div>