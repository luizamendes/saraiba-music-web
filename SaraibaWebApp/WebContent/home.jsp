<%@page import="dao.ArtistaDao"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Genero"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saraiba Music</title>
<link rel="stylesheet" href="reset.css" type="text/css">
<link rel="stylesheet" href="styles.css" type="text/css">

</head>
<body>

	<div class="topo">

		<a href="home.jsp"><img class="logo" src="images/SaraibaMusicLogo2.png" alt="Saraiba Music" height="40"></a>

		<a class="login" href="carrinho.jsp">Carrinho: ${fn:length(sessionScope.cart)}</a>
		
		<c:if test="${empty loginCliente}">
			<a class="login" href="CadastroController">Cadastrar</a>
		</c:if>
		
		<form action="LoginController" method="get">
			<c:if test="${empty loginCliente}">
				<a class="login" href="login.jsp">Login</a>
				<input type="hidden" name="op" value="login">
			</c:if>
				
			<c:if test="${not empty loginCliente}">
				<input class="login" type="submit" value="Sair">
			</c:if>
		</form>

		<form action="PerfilClienteController" method="get">
			<c:if test="${not empty loginCliente}">
				<input class="login" type="submit" value="Olá, ${loginCliente.nome}">
				<input type="hidden" name="idCliente" value="${loginCliente.id}">
			</c:if>
		</form>
	</div>
	
	<div class="container">
				
		<div class="box">
			<div style="padding-left: 50px;">
				<a class="botaomenu" href="ArtistasController">Artistas</a>
				
				<a class="botaomenu" href="GenerosController">Gêneros</a>
				
				<a class="botaomenu" href="LancamentosController">Lançamentos</a>
			</div>
			<br><br>
			
			<form action="Busca2Controller" method="get">
				
				<c:if test="${not empty alfabeto}">
					<c:forEach var="letra" items="${alfabeto}">
						<input class="testeLetras" type="submit" name="letraEscolhida" value="${letra}">
					</c:forEach>
				</c:if>

			</form>
				
				
				<c:if test="${not empty generos}">
					<c:forEach var="genero" items="${generos}">
						<form class="classForm" action="GenerosController" method="post">
							<input class="testeLetras" type="submit" value="${genero.nome}">
							<input type="hidden" value="${genero.id}" name="generoEscolhido">
						</form>
					</c:forEach>
				</c:if>
				
						
			
			<form action="BuscaController" method="get">

				<input class="search" type="text" name="search" placeholder="Digite o nome de uma música">
				
				<p class="legenda">Digite uma palavra-chave para pesquisar uma música. Ex: Paranoid</p>
				
				<div style="margin-left: 175px;">
					<input class="botaomenu" type="submit" value="Buscar" name="search_btn">
				</div>	
			</form>
		
		</div>
	</div>
		
</body>

</html>