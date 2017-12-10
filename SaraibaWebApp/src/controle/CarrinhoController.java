package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MusicaDao;
import negocio.Musica;

public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CarrinhoController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idMusicaAtual = Long.valueOf(request.getParameter("idMusicaAtual"));

		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		List<Musica> cart = (List<Musica>)session.getAttribute("cart");

		int index = jaExiste(idMusicaAtual, cart);
		
		cart.remove(index);

		session.setAttribute("cart", cart);
		
		request.getRequestDispatcher("carrinho.jsp").forward(request, response);
		
	}

	private int jaExiste(long idMusica, List<Musica> cart) {
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getId() == idMusica) {
				return i;
			}
		}
		return -1;
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idMusicaAtual = Long.valueOf(request.getParameter("idMusicaAtual"));

		Musica musicaAtual = MusicaDao.obterPorId(idMusicaAtual);
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cart") == null) {
			List<Musica> cart = new ArrayList<Musica>();
			cart.add(musicaAtual);
			session.setAttribute("cart", cart);
			request.setAttribute("qtdItensCarrinho", cart.size());
		} else {
			@SuppressWarnings("unchecked")
			List<Musica> cart = (List<Musica>)session.getAttribute("cart");
			
			int index = jaExiste(idMusicaAtual, cart);
			
			if(index == -1) {
				cart.add(musicaAtual);
			} else {
				request.setAttribute("produtoRepetido", "Este produto já está no seu carrinho!");
			}
			
			session.setAttribute("cart", cart);
			request.setAttribute("qtdItensCarrinho", cart.size());
		}
			
		request.getRequestDispatcher("carrinho.jsp").forward(request, response);
	
	}

}
