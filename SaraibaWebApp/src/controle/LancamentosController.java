package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicaDao;


public class LancamentosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LancamentosController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("resultadoMusicas", MusicaDao.obterLancamentos());
		
		request.setAttribute("tituloResultado", "Lan�amentos");

		request.getRequestDispatcher("busca.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
