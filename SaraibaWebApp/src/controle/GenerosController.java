package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistaDao;
import dao.GeneroDao;
import negocio.Genero;


public class GenerosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GenerosController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("generos", GeneroDao.obterGeneros());
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//busca artistas pelo genero

		long idGenero = Long.valueOf(request.getParameter("generoEscolhido"));
		
		Genero generoEscolhido = GeneroDao.obterPorId(idGenero);
	
		request.setAttribute("tituloResultado", "Artistas de '" + generoEscolhido.getNome() + "'");
		
		request.setAttribute("resultadoArtistas", ArtistaDao.obterArtistasGenero(generoEscolhido));
		
		request.getRequestDispatcher("busca.jsp").forward(request, response);
		
	}

}
