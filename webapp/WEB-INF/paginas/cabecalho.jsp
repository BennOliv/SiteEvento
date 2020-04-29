<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/" var="home" />
<spring:url value="/logout" var="logout"></spring:url>
<spring:url value="/login" var="logar"></spring:url>

<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style= "background-color:#94bced;">
	<div class="container">
		<a class="navbar-brand" href="${home}">Projeto Eventos</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarItens" aria-controls="navbarItens" aria-expanded="false" aria-label="Toggle navigation">
        	<span class="navbar-toggler-icon"></span>
    	</button>
    	<div class="collapse navbar-collapse" id="navbarItens">
        <ul class="navbar-nav ml-auto">
       	<li class="nav-item active">
       		<a class="nav-link" href="${home}">Home
              <span class="sr-only">(current)</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" >${usuarioLogado.name == 'anonymousUser' ? '' : usuarioLogado.name}</a>
        </li>
        <li class="nav-item">
        <c:if test="${usuarioLogado.name ne 'anonymousUser' }">
            <a class="nav-link" href="${logout}">Deslogar</a>
        </c:if>
        <c:if test="${usuarioLogado.name eq 'anonymousUser' }">
            <a class="nav-link" href="${logar}">Logar</a>
        </c:if>
        </li>
        </ul>
      </div>
	</div>
</nav>
<div class="mb-2"></div>