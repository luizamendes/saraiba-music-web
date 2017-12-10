package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistaDao;
import dao.MusicaDao;
import negocio.Artista;

public class BuscaMusicasArtistaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public BuscaMusicasArtistaController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long idArtista = Long.valueOf(request.getParameter("selecaoArtista"));
		
		Artista artistaSelecionado = ArtistaDao.obterArtistaPorId(idArtista);
		
		request.setAttribute("resultadoMusicas", MusicaDao.obterPorArtista(artistaSelecionado));

		request.setAttribute("tituloResultado", "Músicas de '" + artistaSelecionado.getNome() + "'");

		request.getRequestDispatcher("busca.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
