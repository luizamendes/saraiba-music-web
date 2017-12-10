package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistaDao;
import dao.MusicaDao;

public class Busca2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Busca2Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//busca pela letra do artista
		
		char letraEscolhida = request.getParameter("letraEscolhida").charAt(0);
		
		request.setAttribute("resultadoArtistas", ArtistaDao.obterArtistasLetra(letraEscolhida));

		request.setAttribute("tituloResultado", "Artistas com a letra '" + letraEscolhida + "'");
		
		request.getRequestDispatcher("busca.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//busca as musicas do artista selecionado
		
		int idArtista = Integer.valueOf(request.getParameter("artistaEscolhido"));
				
		request.setAttribute("resultadoMusicas", MusicaDao.obterPorArtista(ArtistaDao.obterArtistaPorId(idArtista)));
		
		request.getRequestDispatcher("busca.jsp").forward(request, response);
		
	}

}
