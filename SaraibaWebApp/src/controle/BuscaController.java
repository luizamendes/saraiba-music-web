package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicaDao;

public class BuscaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BuscaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//busca pela musica
		
		String busca = (String)request.getParameter("search");
			
		request.setAttribute("busca", busca);
       
		if(busca != null) {
			
			request.setAttribute("tituloResultado", "Resultados para '" + busca + "'");
				
			request.setAttribute("resultadoMusicas", MusicaDao.obterPorNome(busca));
				
			request.getRequestDispatcher("busca.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

}
