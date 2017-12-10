<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
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
		
			<h3 class="titulo">Revisão do pedido</h3>
			<hr>
			<table  class="tabelaCarrinho" cellpadding="2" cellspacing="2" border="0">
				<tr class="titulosTabela">
					<th>Opção</th>
					<th>Música</th>
					<th>Artista</th>
					<th>Album</th>
					<th>Preço</th>		
				</tr>
				<c:set var="total" value="0"></c:set>
				<c:forEach var="song" items="${sessionScope.cart}">
					<c:set var="total" value="${total + song.preco}"></c:set>
					<tr>
						<td>
						<form action="CarrinhoController" method="get">
							<input class="excluirCarrinho"  type="submit" onclick="return confirm('Tem certeza que deseja excluir essa música?')" value="Excluir">
							<input type="hidden" name="idMusicaAtual" value="${song.id}">
						</form>
						</td>
						<td>${song.nome}</td>
						<td>${song.artista.nome}</td>
						<td>${song.album.nome}</td>
						<td>${song.preco}</td>
					</tr>
				</c:forEach>
				<tr>
					<td id="totalTabela" colspan="4" align="right">Total</td>
					<td>${total}</td>
				</tr>	
			</table>
		
			<form action="CheckOutController" method="post">
				<input type="hidden" name="valorTotal" value="${total}">
				<br>
				<h3 class="titulo">Dados de pagamento</h3>
				<hr>
				<h3 class="dadosPagamento">Nome impresso no cartão:</h3>
				<input class="dadosPagamento" type="text" name="nome">
				
				<h3 class="dadosPagamento">Numero do cartão</h3>
				<input class="dadosPagamento" type="text" name="numeroCartao">
				
				<h3 class="dadosPagamento">Código de segurança:</h3>
				<input class="dadosPagamento" type="text" name="codigoSeguranca">
				
				<h3 class="dadosPagamento">Data de validade:</h3>
				<input class="dadosPagamento" type="text" name="validade">
				<br>
				<input class="addCarrinho" type="submit" value="Finalizar Compra">
			</form>
		</div>
		
	</div>

</body>
</html>