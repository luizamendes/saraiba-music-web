package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import negocio.Cliente;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("loginCliente");
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailInserido = (String)request.getParameter("login");
		String senhaInserida = (String)request.getParameter("senha");
		
		if(emailInserido == "" || senhaInserida == "") {
			
			String erro = "Preencha todos os campos!";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		Cliente cliente = ClienteDao.logar(emailInserido, senhaInserida);
		
		if(cliente != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginCliente", cliente);
			request.getRequestDispatcher("home.jsp").forward(request, response);
    
		}
		else {
			
			String erro = "E-mail e senha não conferem";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

}
