package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicaDao;
import negocio.Musica;

public class BuscaMusicaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscaMusicaController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idMusica = Long.valueOf(((request.getParameter("selecaoMusica"))));
		
		Musica musica = MusicaDao.obterPorId(idMusica);
		
		request.setAttribute("musica", musica);
		
		request.setAttribute("artista", musica.getArtista());
		
		request.setAttribute("lancamento", musica.lancamentoToString());
		          
		request.getRequestDispatcher("musica.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
