<%@page import="negocio.Musica"%>
<%@page import="negocio.Artista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Música</title>
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
	
				
	<form action="CarrinhoController" method="get">
		<input class="carrinho" type="button" name="carrinho">
		<p>${qtdItensCarrinho}</p>
	</form>
	
	<div class="container">
		
		<div class="box">
			
			<img class="fotoAlbum" src="${musica.album.capa}">
			
			<div class="musicaDescricao">
				<h3 class="tituloInfoMusica">Artista</h3>
				<p class="infoMusica">${artista.nome}</p>
				
				<h3 class="tituloInfoMusica">Música</h3>
				<p class="infoMusica">${musica.nome}</p>
				
				<h3 class="tituloInfoMusica">Album</h3>
				<p class="infoMusica">${musica.album.nome}</p>
				
				<h3 class="tituloInfoMusica">Data de Lançamento</h3>
				<p class="infoMusica">${lancamento}</p>
				
				<form action="CarrinhoController" method="post">
					<input type="submit" name="adicionaCarrinho" class="addCarrinho" value="Adicionar ao Carrinho">
					<input type="hidden" name="idMusicaAtual" value="${musica.id}">
				</form>
				
				<br><br>
				
				<a class="botaomenu" href="home.jsp">Nova Busca</a>
			</div>
		</div>
	</div>
	
</body>
</html>