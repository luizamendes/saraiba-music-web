package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import negocio.Cliente;


public class PerfilClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PerfilClienteController() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idCliente = Long.valueOf(request.getParameter("idCliente"));
		
		Cliente clienteLogado = ClienteDao.obterPorId(idCliente);
		
		request.setAttribute("clienteLogado", clienteLogado);
		
		request.getRequestDispatcher("perfil.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("operacao").equals("Alterar")) {
			Long idCliente = Long.valueOf(request.getParameter("idCliente"));
			
			Cliente clienteLogado = ClienteDao.obterPorId(idCliente);
			
			clienteLogado.setNome(request.getParameter("nome"));
			clienteLogado.setSobrenome(request.getParameter("sobrenome"));
			clienteLogado.setEmail(request.getParameter("email"));
			clienteLogado.setSenha(request.getParameter("senha"));

			ClienteDao.alterarCadastro(clienteLogado);
			
			request.setAttribute("cadastroAlterado", "Cadastro alterado com sucesso!");
			
			request.setAttribute("clienteLogado", clienteLogado);
			
			request.getRequestDispatcher("perfil.jsp").forward(request, response);

			
		}
		else if(request.getParameter("operacao").equals("Excluir Cadastro")) {
			
			Long idCliente = Long.valueOf(request.getParameter("idCliente"));
			
			Cliente clienteLogado = ClienteDao.obterPorId(idCliente);
			
			ClienteDao.excluir(clienteLogado);
			
			HttpSession session = request.getSession();
			
			session.removeAttribute("loginCliente");
			
			request.getRequestDispatcher("cadastroExcluido.jsp").forward(request, response);
			
		}

	}

}
