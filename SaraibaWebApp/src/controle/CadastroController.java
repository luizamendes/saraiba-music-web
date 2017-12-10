package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import dao.MusicaDao;
import negocio.Cliente;


public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Cliente cliente;
	
    public CadastroController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("cadastro.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cliente = new Cliente();
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		if(nome == "" || sobrenome == "" || email == "" || cpf == "" || senha == "") {
			
			request.setAttribute("erroCampos", "Preencha todos os campos!");
			
			if(request.getParameter("tela").equals("naoLogado")) {
				request.getRequestDispatcher("naoLogado.jsp").forward(request, response);
			}
			
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
			

		} else {
		
			cliente.setNome(nome);
			cliente.setSobrenome(sobrenome);
			cliente.setEmail(email);
			cliente.setCpf(cpf);
			cliente.setSenha(senha);
			
			ClienteDao.cadastrarCliente(cliente);
			
			request.getRequestDispatcher("cadastroSucesso.jsp").forward(request, response);
		
		}
		
	}

}
