<%@page import="negocio.Artista"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Musica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saraiva Music - Resultado</title>
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
			
			<h3 class="titulo">${tituloResultado}</h3>
			
			<hr>
				
			<c:choose>
				<c:when test="${not empty resultadoMusicas}">
					<c:forEach var="musica" items="${resultadoMusicas}">
						<div style="margin-top: 10px;">
							<form action="BuscaController" method="post">
								<img class="album_thumbnail" src="${musica.album.capa}">
								<p><a class="resultadoBusca" id="resultadoMusica" href="BuscaMusicaController?selecaoMusica=${musica.id}">${musica}</a></p>
							</form>	
						</div>
					</c:forEach>
				</c:when>
				
				<c:when test="${not empty resultadoArtistas}">			
					<c:forEach var="artista" items="${resultadoArtistas}">
							<p><a class="resultadoBusca" href="BuscaMusicasArtistaController?selecaoArtista=${artista.id}">${artista}</a></p>
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<p class="resultadoBusca">Sua busca não apresentou resultados.</p>
				</c:otherwise>
			</c:choose>				
				
			<br>
			<br>
			<a class="botaomenu" href="home.jsp">Nova Busca</a>
		</div>
	</div>

</body>
</html>